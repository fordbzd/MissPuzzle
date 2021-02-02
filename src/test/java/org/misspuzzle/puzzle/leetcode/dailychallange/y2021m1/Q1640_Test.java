package org.misspuzzle.puzzle.leetcode.dailychallange.y2021m1;

import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class Q1640_Test {

    @Test
    public void testcase1() {

        int[] arr = {85};
        int[][] pieces = {{85}};

        final boolean result = new Q1640_CanFormArray().canFormArray(arr, pieces);

        assertTrue(result);
    }

    @Test
    public void testcase2() {

        int[] arr = {15, 88};
        int[][] pieces = {{88}, {15}};

        final boolean result = new Q1640_CanFormArray().canFormArray(arr, pieces);

        assertTrue(result);
    }

    @Test
    public void testcase3() {

        int[] arr = {15, 88};
        int[][] pieces = {{88, 15}};

        final boolean result = new Q1640_CanFormArray().canFormArray(arr, pieces);

        assertFalse(result);
    }

    @Test
    public void testcase4() {

        int[] arr = {91, 4, 64, 78};
        int[][] pieces = {{78}, {4, 64}, {91}};

        final boolean result = new Q1640_CanFormArray().canFormArray(arr, pieces);

        assertTrue(result);
    }

    @Test
    public void testcase5() {

        int[] arr = {1, 3, 5, 7};
        int[][] pieces = {{2, 4, 6, 8}};

        final boolean result = new Q1640_CanFormArray().canFormArray(arr, pieces);

        assertFalse(result);
    }
}
