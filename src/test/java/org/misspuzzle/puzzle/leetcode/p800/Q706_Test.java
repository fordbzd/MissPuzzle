package org.misspuzzle.puzzle.leetcode.p800;

import org.junit.Test;
import org.misspuzzle.datastructure.MyHashMap;

import static org.junit.Assert.assertEquals;

public class Q706_Test {
    @Test
    public void testcase() {
        MyHashMap hashMap = new Q706_MyHashMap().myHashMap;

        hashMap.put(1, 1);
        hashMap.put(2, 2);
        assertEquals(1, hashMap.get(1));
        assertEquals(-1, hashMap.get(3));
        hashMap.put(2, 1);
        assertEquals(1, hashMap.get(2));
        hashMap.remove(2);
        assertEquals(-1, hashMap.get(2));
    }
}
