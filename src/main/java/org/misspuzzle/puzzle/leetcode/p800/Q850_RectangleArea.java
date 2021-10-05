package org.misspuzzle.puzzle.leetcode.p800;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Q850_RectangleArea {
    public int rectangleArea(int[][] rectangles) {

        long M = 1000000007L;
        List<Range> list = new ArrayList<>();
        Set<Integer> xSet = new TreeSet<>();

        for (int[] rec : rectangles) {
            xSet.add(rec[0]);
            xSet.add(rec[2]);

            list.add(new Range(rec[1], rec[0], rec[2], 1));
            list.add(new Range(rec[3], rec[0], rec[2], -1));
        }

        list.sort(Comparator.comparingInt(a -> a.y));
        List<Integer> uniqueX = new ArrayList<>(xSet);
        int[] count = new int[uniqueX.size()];
        Map<Integer, Integer> xMap = IntStream.range(0, uniqueX.size()).boxed().collect(Collectors.toMap(uniqueX::get, i -> i));

        long sum = 0;
        long xRange = 0;
        int preY = 0;

        for (Range range : list) {
            int currY = range.y;
            int x1 = range.x1;
            int x2 = range.x2;
            int isAdd = range.isAdd;

            sum += (currY - preY) * xRange % M;

            for (int i = xMap.get(x1); i < xMap.get(x2); i++) {
                count[i] += isAdd;
            }

            xRange = 0;
            for (int i = 0; i < count.length; i++) {
                if (count[i] > 0) {
                    xRange += uniqueX.get(i + 1) - uniqueX.get(i);
                }
            }

            preY = currY;
        }

        return (int) sum;
    }

    static class Range {
        int y;
        int x1;
        int x2;
        int isAdd;

        Range(int y, int x1, int x2, int isAdd) {
            this.y = y;
            this.x1 = x1;
            this.x2 = x2;
            this.isAdd = isAdd;
        }
    }
}
