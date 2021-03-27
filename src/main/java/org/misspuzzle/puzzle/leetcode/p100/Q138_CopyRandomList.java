package org.misspuzzle.puzzle.leetcode.p100;

import java.util.HashMap;
import java.util.Map;

public class Q138_CopyRandomList {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Map<Node, Node> map = new HashMap<>();

        Node newHead = new Node(head.val);
        newHead.random = head.random;
        map.put(head, newHead);

        Node result = newHead;

        while (head.next != null) {
            Node newNext = new Node(head.next.val);
            newNext.random = head.next.random;
            map.put(head.next, newNext);

            newHead.next = newNext;

            newHead = newNext;
            head = head.next;
        }

        newHead = result;
        while (newHead != null) {
            newHead.random = map.get(newHead.random);

            newHead = newHead.next;
        }

        return result;
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
