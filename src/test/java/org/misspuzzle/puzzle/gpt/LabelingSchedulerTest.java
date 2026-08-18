package org.misspuzzle.puzzle.gpt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class LabelingSchedulerTest {

    private final LabelingScheduler scheduler = new LabelingScheduler();

    // ------------------------------------------------------------------
    // Classic example from the problem statement
    // t=3, m=2, h=4, k=2
    // ------------------------------------------------------------------
    @Test
    public void testClassicExample() {
        List<LabelingScheduler.Assignment> result =
                scheduler.buildBalancedSchedule(3, 2, 4, 2);

        assertNotNull(result);
        assertEquals(8, result.size());

        // Exact order produced by the standard construction
        List<LabelingScheduler.Assignment> expected = List.of(
                new LabelingScheduler.Assignment(0, 0, 0),
                new LabelingScheduler.Assignment(1, 0, 1),
                new LabelingScheduler.Assignment(2, 0, 2),
                new LabelingScheduler.Assignment(0, 1, 3),
                new LabelingScheduler.Assignment(1, 1, 0),
                new LabelingScheduler.Assignment(2, 1, 1),
                new LabelingScheduler.Assignment(0, 0, 2),
                new LabelingScheduler.Assignment(1, 0, 3)
        );
        assertEquals(expected, result);

        assertTrue(isValidPart2(result, 3, 2, 4, 2));
    }

    // ------------------------------------------------------------------
    // t > h
    // ------------------------------------------------------------------
    @Test
    public void testTGreaterThanH() {
        List<LabelingScheduler.Assignment> result =
                scheduler.buildBalancedSchedule(5, 2, 3, 2);

        assertNotNull(result);
        assertEquals(6, result.size());
        assertTrue(isValidPart2(result, 5, 2, 3, 2));
    }

    // ------------------------------------------------------------------
    // Extreme: m = 1
    // ------------------------------------------------------------------
    @Test
    public void testMEqualsOne() {
        List<LabelingScheduler.Assignment> result =
                scheduler.buildBalancedSchedule(7, 1, 2, 3);

        assertNotNull(result);
        assertEquals(6, result.size());
        assertTrue(isValidPart2(result, 7, 1, 2, 3));
    }

    // ------------------------------------------------------------------
    // Extreme: t much larger than h
    // ------------------------------------------------------------------
    @Test
    public void testTMuchLargerThanH() {
        List<LabelingScheduler.Assignment> result =
                scheduler.buildBalancedSchedule(100, 3, 4, 5);

        assertNotNull(result);
        assertEquals(20, result.size());
        assertTrue(isValidPart2(result, 100, 3, 4, 5));
    }

    // ------------------------------------------------------------------
    // Edge cases
    // ------------------------------------------------------------------
    @Test
    public void testKEqualsZero() {
        assertEquals(List.of(), scheduler.buildBalancedSchedule(5, 2, 3, 0));
    }

    @Test
    public void testImpossibleKGreaterThanT() {
        assertNull(scheduler.buildBalancedSchedule(3, 2, 4, 4));
    }

    @Test
    public void testInvalidParameters() {
        assertNull(scheduler.buildBalancedSchedule(0, 2, 3, 1));
        assertNull(scheduler.buildBalancedSchedule(5, 0, 3, 1));
        assertNull(scheduler.buildBalancedSchedule(5, 2, 0, 1));
        assertNull(scheduler.buildBalancedSchedule(-1, 2, 3, 1));
    }

    // ------------------------------------------------------------------
    // Helper: full Part-2 validator
    // ------------------------------------------------------------------
    private boolean isValidPart2(List<LabelingScheduler.Assignment> schedule,
                                 int t, int m, int h, int k) {

        if (schedule.size() != h * k) return false;

        int[] humanCount = new int[h];
        Set<String> humanTaskPairs = new HashSet<>();

        // Running counters for prefix checks
        int[][] modelCount = new int[t][m];   // modelCount[task][model]
        int[][] humanCountPerTask = new int[t][h];

        for (LabelingScheduler.Assignment a : schedule) {
            int task = a.task();
            int model = a.model();
            int human = a.human();

            // Basic range checks
            if (task < 0 || task >= t) return false;
            if (model < 0 || model >= m) return false;
            if (human < 0 || human >= h) return false;

            // Uniqueness: (human, task) at most once
            String key = human + "-" + task;
            if (!humanTaskPairs.add(key)) return false;

            humanCount[human]++;

            // Update running counts
            modelCount[task][model]++;
            humanCountPerTask[task][human]++;

            // Prefix balance for models of this task
            if (!isBalanced(modelCount[task])) return false;

            // Prefix balance for humans of this task
            if (!isBalanced(humanCountPerTask[task])) return false;
        }

        // Every human appears at least k times
        for (int c : humanCount) {
            if (c < k) return false;
        }

        return true;
    }

    private boolean isBalanced(int[] counts) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int c : counts) {
            min = Math.min(min, c);
            max = Math.max(max, c);
        }
        return max - min <= 1;
    }
}