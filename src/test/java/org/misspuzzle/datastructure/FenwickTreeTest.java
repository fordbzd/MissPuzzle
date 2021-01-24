package org.misspuzzle.datastructure;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FenwickTreeTest {

    @Test
    public void testcase() {

        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        FenwickTree tree = new FenwickTree(arr.length);

        for (int i = 0; i < arr.length; i++) {
            tree.add(i, arr[i]);
        }

        assertEquals(1, tree.arr[0]);
        assertEquals(10, tree.arr[3]);

        assertEquals(1L, tree.prefixSum(0));
        assertEquals(15L, tree.prefixSum(4));
        assertEquals(45L, tree.prefixSum(8));

        assertEquals(2L, tree.rangeSum(1, 2));
        assertEquals(35L, tree.rangeSum(4, 9));

        assertEquals(1, tree.get(0));
        assertEquals(3, tree.get(2));
        assertEquals(9, tree.get(8));
    }

    @Test
    public void testcase2() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        FenwickTree tree = new FenwickTree(arr);

        assertEquals(1, tree.get(0));
        assertEquals(3, tree.get(2));
        assertEquals(9, tree.get(8));
    }

    @Test
    public void testcase3() {
        int[] arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

        FenwickTree tree = new FenwickTree(arr);

        tree.set(2, 5);

        assertEquals(5, tree.arr[2]);
        assertEquals(12, tree.arr[3]);
        assertEquals(38, tree.arr[7]);

        tree.set(2, 3);

        assertEquals(3, tree.arr[2]);
        assertEquals(10, tree.arr[3]);
        assertEquals(36, tree.arr[7]);
    }
}
