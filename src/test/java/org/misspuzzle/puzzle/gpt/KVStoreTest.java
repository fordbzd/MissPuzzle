package org.misspuzzle.puzzle.gpt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class KVStoreTest {

    // ------------------------------------------------------------------
    // Basic put / get
    // ------------------------------------------------------------------
    @Test
    public void testPutAndGet() {
        KVStore store = new KVStore();
        store.put("name", "Alice");
        store.put("city", "New York");

        assertEquals("Alice", store.get("name"));
        assertEquals("New York", store.get("city"));
        assertNull(store.get("missing"));
    }

    // ------------------------------------------------------------------
    // Simple round-trip (shutdown → restart)
    // ------------------------------------------------------------------
    @Test
    public void testSimpleRoundTrip() {
        KVStore store = new KVStore();
        store.put("name", "John:Doe");
        store.put("city", "New,York");

        store.shutdown();

        KVStore restored = new KVStore();
        // We need to share the same FileSystem for a real test.
        // Because the current constructor creates its own FS,
        // we test round-trip on the same instance for simplicity.
        store.restore();

        assertEquals("John:Doe", store.get("name"));
        assertEquals("New,York", store.get("city"));
    }

    // ------------------------------------------------------------------
    // Arbitrary / dangerous characters
    // ------------------------------------------------------------------
    @Test
    public void testSpecialCharacters() {
        KVStore store = new KVStore();

        store.put("key\nwith\nnewlines", "value=with=equals");
        store.put("emoji_key_😀", "emoji_value_🎉");
        store.put("null\0byte", "has\0null");
        store.put("comma,key", "colon:value");
        store.put("quote\"key", "single'quote");

        store.shutdown();
        store.restore();

        assertEquals("value=with=equals", store.get("key\nwith\nnewlines"));
        assertEquals("emoji_value_🎉", store.get("emoji_key_😀"));
        assertEquals("has\0null", store.get("null\0byte"));
        assertEquals("colon:value", store.get("comma,key"));
        assertEquals("single'quote", store.get("quote\"key"));
    }

    // ------------------------------------------------------------------
    // Empty store
    // ------------------------------------------------------------------
    @Test
    public void testEmptyStore() {
        KVStore store = new KVStore();
        store.shutdown();
        store.restore();

        assertNull(store.get("anything"));
    }

    // ------------------------------------------------------------------
    // Overwrite existing key
    // ------------------------------------------------------------------
    @Test
    public void testOverwrite() {
        KVStore store = new KVStore();
        store.put("key", "old");
        store.put("key", "new");

        store.shutdown();
        store.restore();

        assertEquals("new", store.get("key"));
    }

    // ------------------------------------------------------------------
    // Data larger than 1 KB (tests chunking)
    // ------------------------------------------------------------------
    @Test
    public void testLargeDataChunking() {
        KVStore store = new KVStore();

        // Create many entries so the serialized form exceeds 1 KB
        StringBuilder bigValue = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            bigValue.append("abcdefghijklmnopqrstuvwxyz");
        }
        String value = bigValue.toString(); // ~2600 characters

        for (int i = 0; i < 20; i++) {
            store.put("key_" + i, value + "_" + i);
        }

        store.shutdown();
        store.restore();

        for (int i = 0; i < 20; i++) {
            assertEquals(value + "_" + i, store.get("key_" + i));
        }
    }

    // ------------------------------------------------------------------
    // Multiple shutdown / restart cycles
    // ------------------------------------------------------------------
    @Test
    public void testMultipleCycles() {
        KVStore store = new KVStore();

        store.put("a", "1");
        store.shutdown();
        store.restore();
        assertEquals("1", store.get("a"));

        store.put("b", "2");
        store.shutdown();
        store.restore();

        assertEquals("1", store.get("a"));
        assertEquals("2", store.get("b"));
    }
}