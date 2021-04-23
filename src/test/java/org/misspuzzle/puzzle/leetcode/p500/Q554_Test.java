package org.misspuzzle.puzzle.leetcode.p500;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q554_Test {
    @Test
    public void testcase() {
        List<List<Integer>> rows = new ArrayList<>();

        List<Integer> row1 = new ArrayList<>();
        row1.add(1);
        row1.add(2);
        row1.add(2);
        row1.add(1);
        rows.add(row1);

        List<Integer> row2 = new ArrayList<>();
        row2.add(3);
        row2.add(1);
        row2.add(2);
        rows.add(row2);

        List<Integer> row3 = new ArrayList<>();
        row3.add(1);
        row3.add(3);
        row3.add(2);
        rows.add(row3);

        int result = new Q554_LeastBricks().leastBricks(rows);

        assertEquals(1, result);
    }
}
