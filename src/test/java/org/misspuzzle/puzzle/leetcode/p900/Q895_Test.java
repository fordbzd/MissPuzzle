package org.misspuzzle.puzzle.leetcode.p900;

import org.junit.Test;
import org.misspuzzle.datastructure.FreqStack;

import static org.junit.Assert.assertEquals;

public class Q895_Test {
    @Test
    public void testcase() {

        FreqStack freqStack = new Q895_FreqStack().freqStack;

        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(7);
        freqStack.push(5);
        freqStack.push(4);

        assertEquals(5, freqStack.pop());
        assertEquals(7, freqStack.pop());
        assertEquals(5, freqStack.pop());
        assertEquals(4, freqStack.pop());
        assertEquals(7, freqStack.pop());
        assertEquals(5, freqStack.pop());
    }
}
