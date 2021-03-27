package org.misspuzzle.puzzle.leetcode.p500;

import java.util.HashMap;
import java.util.Map;

public class Q535_TinyUrl {

    private final Map<String, String> db = new HashMap<>();
    private int id = 0;
    private final char[] c = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '0',
        'a', 'b', 'c', 'd', 'e'};

    private static final String URL_PREFIX = "http://tinyurl.com/";

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String tinyUrl = getNextHash(id);

        db.put(tinyUrl, longUrl);

        return URL_PREFIX + tinyUrl;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if (shortUrl == null) {
            return null;
        }

        return db.get(shortUrl.replace(URL_PREFIX, ""));
    }

    private String getNextHash(int id) {
        id++;

        int base = c.length;
        int quotient = id;

        StringBuilder sb = new StringBuilder();

        while (quotient != 0) {
            sb.append(c[quotient % base]);
            quotient = quotient / base;
        }

        return sb.toString();
    }
}
