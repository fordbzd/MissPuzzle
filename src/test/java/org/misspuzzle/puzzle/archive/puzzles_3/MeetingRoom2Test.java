package org.misspuzzle.puzzle.archive.puzzles_3;

import org.junit.Test;
import org.misspuzzle.datastructure.Interval;

import static org.junit.Assert.assertEquals;

public class MeetingRoom2Test {
	@Test
	public void testcase() {
		Interval[] intervals = {
				new Interval(0, 30),
				new Interval(5, 10),
				new Interval(15, 20)
		};

		final int result = new MeetingRoom2().minMeetingRooms(intervals);

		assertEquals(2, result);
	}
}
