package org.misspuzzle.datastructure;

import java.util.LinkedList;
import java.util.List;

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 *
 * Ref: https://leetcode.com/problems/design-hashmap/
 */
public class MyHashMap {

    private final int CAPACITY = 10000;

    private final List<Node>[] map = new List[CAPACITY];

    /**
     * Initialize your data structure here.
     */
    public MyHashMap() {
    }

    /**
     * value will always be non-negative.
     */
    public void put(int key, int value) {
        int i = getHashIndex(key);
        List<Node> list = map[i];

        if (list == null) {
            list = new LinkedList<>();
            map[i] = list;
        }

        for (Node node : list) {
            if (node.key == key) {
                node.value = value;
                return;
            }
        }

        list.add(new Node(key, value));
    }

    /**
     * Returns the value to which the specified key is mapped,
     * or -1 if this map contains no mapping for the key.
     */
    public int get(int key) {
        int i = getHashIndex(key);
        List<Node> list = map[i];

        if (list != null) {
            for (Node node : list) {
                if (node.key == key) {
                    return node.value;
                }
            }
        }

        return -1;
    }

    /**
     * Removes the mapping of the specified value key if this map contains a mapping for the key
     * */
    public void remove(int key) {
        int i = getHashIndex(key);
        List<Node> list = map[i];

        if (list != null) {
            for (Node node : list) {
                if (node.key == key) {
                    list.remove(node);
                    return;
                }
            }
        }
    }

    private int getHashIndex(int key) {
        return key % CAPACITY;
    }

    private static class Node {
        int key;
        int value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
