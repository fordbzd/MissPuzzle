package org.misspuzzle.puzzle.leetcode.p0;

import org.junit.Test;
import org.misspuzzle.datastructure.Interval;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q56_Test {
	@Test
	public void testcase() {
		List<Interval> list = new ArrayList<Interval>();

		list.add(new Interval(1, 3));
		list.add(new Interval(2, 6));
		list.add(new Interval(8, 10));
		list.add(new Interval(15, 30));

		List<Interval> result = new Q56_Merge().merge(list);

		assertEquals(3, result.size());
	}
}
