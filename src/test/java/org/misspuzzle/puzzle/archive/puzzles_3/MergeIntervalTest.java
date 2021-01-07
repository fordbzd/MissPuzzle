package org.misspuzzle.puzzle.archive.puzzles_3;

import org.junit.Test;
import org.misspuzzle.datastructure.Interval;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class MergeIntervalTest {
	@Test
	public void testcase() {
		List<Interval> list = new ArrayList<Interval>();

		list.add(new Interval(1, 3));
		list.add(new Interval(2, 6));
		list.add(new Interval(8, 10));
		list.add(new Interval(15, 30));

		List<Interval> result = new MergeInterval().merge(list);

		assertEquals(3, result.size());
	}
}
