package org.misspuzzle.puzzle.leetcode.p000;

import org.misspuzzle.datastructure.ListNode;

import java.util.ArrayList;
import java.util.List;

public class Q86_Partition {
    public ListNode partition(ListNode head, int x) {

        if (head == null) {
            return null;
        }

        List<ListNode> list1 = new ArrayList<>();
        List<ListNode> list2 = new ArrayList<>();

        while (head != null) {
            if (head.val < x) {
                list1.add(head);
            } else {
                list2.add(head);
            }

            head = head.next;
        }

        for (int i = 1; i < list1.size(); i++) {
            list1.get(i - 1).next = list1.get(i);
        }
        for (int i = 1; i < list2.size(); i++) {
            list2.get(i - 1).next = list2.get(i);
        }

        if (list1.size() > 0) {
            head = list1.get(0);

            if (list2.size() > 0) {
                list1.get(list1.size() - 1).next = list2.get(0);
                list2.get(list2.size() - 1).next = null;
            } else {
                list1.get(list1.size() - 1).next = null;
            }
        } else {
            head = list2.get(0);
            list2.get(list2.size() - 1).next = null;
        }

        return head;
    }
}
