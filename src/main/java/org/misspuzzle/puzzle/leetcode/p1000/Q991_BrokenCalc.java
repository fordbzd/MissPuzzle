package org.misspuzzle.puzzle.leetcode.p1000;

public class Q991_BrokenCalc {
    public int brokenCalc(int X, int Y) {

        int step = 0;

        while (X < Y) {
            if ((Y & 1) == 1) {
                Y++;
            } else {
                Y = Y >> 1;
            }

            step++;
        }

        return step + X - Y;
    }
}
