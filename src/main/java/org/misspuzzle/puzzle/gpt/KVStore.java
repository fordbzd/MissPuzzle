package org.misspuzzle.puzzle.gpt;

import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.*;


public class KVStore {

    private final InMemoryFileSystem fs;
    private final Map<String, String> data;

    private final static int INT_LENGTH = 4;
    private final static int CHUNK_SIZE = 1024;
    private final static String FILE_PREFIX = "chunk_";

    KVStore() {
        fs = new InMemoryFileSystem();
        data = new HashMap<>();
    }
    
    public void put(String key, String value) {
        data.put(key, value);
    }

    public String get(String key) {
        return data.get(key);          // or throw if missing – clarify with interviewer
    }

    public void shutdown() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        for (var entry : data.entrySet()) {
            byte[] keyBytes = SerializationHelpers.serializeStr(entry.getKey());
            write(out, SerializationHelpers.serializeInt(keyBytes.length));
            write(out, keyBytes);

            byte[] valueBytes = SerializationHelpers.serializeStr(entry.getValue());
            write(out, SerializationHelpers.serializeInt(valueBytes.length));
            write(out, valueBytes);
        }

        // Save file chunks
        byte[] outByte = out.toByteArray();
        int fileChunkCount = (outByte.length + CHUNK_SIZE - 1) / CHUNK_SIZE;
        fs.saveBlob("metadata", SerializationHelpers.serializeInt(fileChunkCount));

        for (int i = 0; i < fileChunkCount; i++) {
            byte[] toSave = Arrays.copyOfRange(outByte, i * CHUNK_SIZE, Math.min((i + 1) * CHUNK_SIZE, outByte.length));
            fs.saveBlob(FILE_PREFIX + i, toSave);
        }
    }

    public void restore() {
        data.clear();

        byte[] meta = fs.getBlob("metadata");
        if (meta == null || meta.length != INT_LENGTH) {
            return; // empty store
        }
        int fileChunkCount = SerializationHelpers.deserializeInt(meta);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        for (int i = 0; i < fileChunkCount; i++) {
            write(out, fs.getBlob(FILE_PREFIX + i));
        }

        byte[] b = out.toByteArray();

        ByteBuffer buffer = ByteBuffer.wrap(b);

        while (buffer.hasRemaining()) {
            int keyLen = SerializationHelpers.deserializeInt(read(buffer, INT_LENGTH));
            String key = SerializationHelpers.deserializeStr(read(buffer, keyLen));

            int valueLen = SerializationHelpers.deserializeInt(read(buffer, INT_LENGTH));
            String value = SerializationHelpers.deserializeStr(read(buffer, valueLen));

            data.put(key, value);
        }
    }

    private void write(ByteArrayOutputStream out, byte[] b) {
        out.write(b, 0, b.length);
    }

    private byte[] read(ByteBuffer buffer, int len) {
        byte[] b = new byte[len];
        buffer.get(b);

        return b;
    }

    public class InMemoryFileSystem {
        private Map<String, byte[]> storage;
        
        public InMemoryFileSystem() {
            storage = new HashMap<>();
        }

        public void saveBlob(String filename, byte[] data) {
            byte[] toStore;

            if (data == null) {
                toStore = new byte[0];
            } else {
                toStore = data.clone();   // defensive copy
            }

            storage.put(filename, toStore);
        }

        public byte[] getBlob(String filename) {
            return storage.getOrDefault(filename, new byte[0]).clone();       // defensive copy
        }
    }       

    public static class SerializationHelpers {

        // ------------------------------------------------------------------
        // Integer
        // ------------------------------------------------------------------

        /** Turn an int into exactly 4 bytes (big-endian). */
        public static byte[] serializeInt(int value) {
            return ByteBuffer.allocate(4).putInt(value).array();
        }

        /** Turn 4 bytes back into an int. */
        public static int deserializeInt(byte[] data) {
            if (data == null || data.length != 4) {
                throw new IllegalArgumentException("Expected exactly 4 bytes for an int");
            }
            return ByteBuffer.wrap(data).getInt();
        }

        // ------------------------------------------------------------------
        // String
        // ------------------------------------------------------------------

        /** Turn a string into its UTF-8 byte representation. */
        public static byte[] serializeStr(String value) {
            if (value == null) {
                throw new IllegalArgumentException("null string not allowed");
            }
            return value.getBytes(StandardCharsets.UTF_8);
        }

        /** Turn UTF-8 bytes back into a string. */
        public static String deserializeStr(byte[] data) {
            if (data == null) {
                throw new IllegalArgumentException("null byte array");
            }
            return new String(data, StandardCharsets.UTF_8);
        }
    }
}
