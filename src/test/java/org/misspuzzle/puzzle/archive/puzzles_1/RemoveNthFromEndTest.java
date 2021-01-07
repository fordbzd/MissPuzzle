package org.misspuzzle.puzzle.archive.puzzles_1;

import org.junit.Test;
import org.misspuzzle.datastructure.ListNode;

import static org.junit.Assert.assertNull;

public class RemoveNthFromEndTest {
    @Test
    public void testcase() {
        ListNode root = new ListNode(1);
        root.next = new ListNode(2);
        root.next.next = new ListNode(3);

        final ListNode result = new RemoveNthFromEnd().removeNthFromEnd(root, 2);

        assertNull(result.next.next);
    }
}
