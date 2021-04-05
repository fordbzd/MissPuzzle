package org.misspuzzle.puzzle.leetcode.p600;

import org.junit.Test;
import org.misspuzzle.datastructure.MyCircularQueue;

import static org.junit.Assert.*;

public class Q622_Test {
    @Test
    public void testcase() {
        MyCircularQueue myCircularQueue  = new Q622_MyCircularQueue(3).myCircularQueue;

        assertTrue(myCircularQueue.enQueue(1)); // return True
        assertTrue(myCircularQueue.enQueue(2)); // return True
        assertTrue(myCircularQueue.enQueue(3)); // return True
        assertFalse(myCircularQueue.enQueue(4)); // return False
        assertEquals(3, myCircularQueue.Rear());     // return 3
        assertTrue(myCircularQueue.isFull());   // return True
        assertTrue(myCircularQueue.deQueue());  // return True
        assertTrue(myCircularQueue.enQueue(4)); // return True
        assertEquals(4, myCircularQueue.Rear());     // return 4
    }
}
