package org.misspuzzle.puzzle.leetcode.p1100;

import org.junit.Test;
import org.misspuzzle.puzzle.leetcode.p1200.Q1209_RemoveDuplicates;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Q1192_Test {
    @Test
    public void testcase() {
        List<List<Integer>> connections = new ArrayList<>();

        List<Integer> edge1 = new ArrayList<>();
        edge1.add(0);
        edge1.add(1);
        connections.add(edge1);

        List<Integer> edge2 = new ArrayList<>();
        edge2.add(1);
        edge2.add(2);
        connections.add(edge2);

        List<Integer> edge3 = new ArrayList<>();
        edge3.add(2);
        edge3.add(0);
        connections.add(edge3);

        List<Integer> edge4 = new ArrayList<>();
        edge4.add(1);
        edge4.add(3);
        connections.add(edge4);

        List<List<Integer>> result = new Q1192_CriticalConnections().criticalConnections(4, connections);

        assertEquals(1, result.get(0).get(0).intValue());
        assertEquals(3, result.get(0).get(1).intValue());
    }
}
