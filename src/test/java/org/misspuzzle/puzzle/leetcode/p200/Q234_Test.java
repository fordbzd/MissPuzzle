package org.misspuzzle.puzzle.leetcode.p200;

import org.junit.Test;
import org.misspuzzle.datastructure.ListNode;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class Q234_Test {
    @Test
    public void testcase1() {
        ListNode head = new ListNode(new int[]{1, 2, 2, 1});

        boolean result = new Q234_IsPalindrome().isPalindrome(head);

        assertTrue(result);
    }

    @Test
    public void testcase2() {
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 1});

        boolean result = new Q234_IsPalindrome().isPalindrome(head);

        assertFalse(result);
    }
}
