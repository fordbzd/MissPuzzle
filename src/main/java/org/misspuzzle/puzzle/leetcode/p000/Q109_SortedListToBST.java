package org.misspuzzle.puzzle.leetcode.p000;

import org.misspuzzle.datastructure.ListNode;
import org.misspuzzle.datastructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q109_SortedListToBST {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();

        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        return partition(list, 0, list.size() - 1);
    }

    private TreeNode partition(List<Integer> list, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = (start + end) / 2;

        return new TreeNode(
                list.get(mid),
                partition(list, start, mid - 1),
                partition(list, mid + 1, end)
        );
    }
}
