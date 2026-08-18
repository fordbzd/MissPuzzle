package org.misspuzzle.puzzle.gpt;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

public class ShardRebalanceTest {

    // Helper to compare results ignoring order
    private void assertShardsEqual(List<String> expected, List<String> actual) {
        List<String> e = new ArrayList<>(expected);
        List<String> a = new ArrayList<>(actual);
        Collections.sort(e);
        Collections.sort(a);
        assertEquals(e, a);
    }

    // ------------------------------------------------------------------
    // Example 1 – Basic limit = 1
    // ------------------------------------------------------------------
    @Test
    public void testBasicLimit1() {
        List<String> input = List.of(
            "A:0:100",
            "B:80:180"
        );

        List<String> result = new ShardRebalance().rebalance(1, input);

        assertShardsEqual(List.of(
            "A:0:100",
            "B:101:180"
        ), result);
    }

    // ------------------------------------------------------------------
    // Example 2 – limit = 2 simple
    // ------------------------------------------------------------------
    @Test
    public void testLimit2Simple() {
        List<String> input = List.of(
            "A:0:100",
            "B:50:150",
            "C:120:200"
        );

        List<String> result = new ShardRebalance().rebalance(2, input);

        assertShardsEqual(List.of(
            "A:0:100",
            "B:50:150",
            "C:120:200"
        ), result);
    }

    // ------------------------------------------------------------------
    // Example 3 – Chained shift
    // ------------------------------------------------------------------
    @Test
    public void testChainedShift() {
        List<String> input = List.of(
            "A:0:30",
            "B:0:31",
            "C:0:32",
            "D:0:100"
        );

        List<String> result = new ShardRebalance().rebalance(2, input);

        assertShardsEqual(List.of(
            "A:0:30",
            "B:0:31",
            "C:31:32",
            "D:32:100"
        ), result);
    }

    // ------------------------------------------------------------------
    // Example 4 – Gap filling
    // ------------------------------------------------------------------
    @Test
    public void testGapFilling() {
        List<String> input = List.of(
            "A:0:100",
            "B:40:110",
            "C:80:200",
            "D:210:300"
        );

        List<String> result = new ShardRebalance().rebalance(2, input);

        assertShardsEqual(List.of(
            "A:0:100",
            "B:40:110",
            "C:101:209",
            "D:210:300"
        ), result);
    }

    // ------------------------------------------------------------------
    // Example 5 – Shard completely dropped
    // ------------------------------------------------------------------
    @Test
    public void testShardDropped() {
        List<String> input = List.of(
            "A:0:50",
            "B:0:40"
        );

        List<String> result = new ShardRebalance().rebalance(1, input);

        assertShardsEqual(List.of(
            "A:0:50"
        ), result);
    }

    // ------------------------------------------------------------------
    // Edge cases
    // ------------------------------------------------------------------
    @Test
    public void testEmptyInput() {
        assertTrue(new ShardRebalance().rebalance(1, List.of()).isEmpty());
        assertTrue(new ShardRebalance().rebalance(5, null).isEmpty());
    }

    @Test
    public void testSingleShard() {
        List<String> result = new ShardRebalance().rebalance(1, List.of("X:10:20"));
        assertShardsEqual(List.of("X:10:20"), result);
    }

    @Test
    public void testNoOverlapShouldFillGaps() {
        List<String> input = List.of(
            "A:0:10",
            "B:20:30",
            "C:40:50"
        );

        List<String> result = new ShardRebalance().rebalance(1, input);

        // Gaps must be filled
        assertShardsEqual(List.of(
            "A:0:19",
            "B:20:39",
            "C:40:50"
        ), result);
    }

    @Test
    public void testLimitLargerThanShards() {
        List<String> input = List.of(
            "A:0:100",
            "B:50:150"
        );

        // limit is high enough – nothing should change
        List<String> result = new ShardRebalance().rebalance(5, input);
        assertShardsEqual(input, result);
    }
}