package org.misspuzzle.puzzle.leetcode.p200;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Q138_Test {
    @Test
    public void testcase() {

        Q138_CopyRandomList.Node node = new Q138_CopyRandomList.Node(1);
        node.random = node;

        Q138_CopyRandomList.Node result = new Q138_CopyRandomList().copyRandomList(node);

        assertEquals(1, result.random.val);
    }
}
