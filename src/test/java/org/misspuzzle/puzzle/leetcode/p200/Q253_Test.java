package org.misspuzzle.puzzle.leetcode.p200;

import org.junit.Test;
import org.misspuzzle.datastructure.Interval;

import static org.junit.Assert.assertEquals;

public class Q253_Test {
	@Test
	public void testcase() {
		Interval[] intervals = {
				new Interval(0, 30),
				new Interval(5, 10),
				new Interval(15, 20)
		};

		final int result = new Q253_MinMeetingRooms().minMeetingRooms(intervals);

		assertEquals(2, result);
	}
}
