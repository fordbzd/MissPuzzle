package org.misspuzzle.puzzle.leetcode.p800;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertFalse;

public class Q841_Test {
    @Test
    public void testcase() {
        List<List<Integer>> rooms = new ArrayList<>();
        rooms.add(Arrays.stream(new int[]{1, 3}).boxed().collect(Collectors.toList()));
        rooms.add(Arrays.stream(new int[]{3, 0, 1}).boxed().collect(Collectors.toList()));
        rooms.add(Arrays.stream(new int[]{2}).boxed().collect(Collectors.toList()));
        rooms.add(Arrays.stream(new int[]{0}).boxed().collect(Collectors.toList()));

        boolean result = new Q841_CanVisitAllRooms().canVisitAllRooms(rooms);

        assertFalse(result);
    }
}
