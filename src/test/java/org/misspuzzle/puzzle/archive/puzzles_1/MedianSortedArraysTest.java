package org.misspuzzle.puzzle.archive.puzzles_1;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedianSortedArraysTest {
	@Test
	public void testcase() {
		int[] nums1 = {1, 3, 5, 7, 9};
		int[] nums2 = {0, 2, 4, 6, 8};

		final double result = new MedianSortedArrays().findMedianSortedArrays(nums1, nums2);

		assertEquals(4.5, result, 0);
	}
}
