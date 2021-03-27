package org.misspuzzle.puzzle.leetcode.p0;

public class Q29_Divide {
    public int divide(int dividend, int divisor) {

        if (dividend == -2147483648 && divisor == -1) {
            return 2147483647;
        }

        boolean positive = (dividend > 0) == (divisor > 0);

        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);
        int result = 0;

        while (dividend - divisor >= 0) {
            int factor = 1;

            while (dividend - (divisor << factor) >= 0) {
                factor++;
            }

//            for (factor = 0; dividend - (divisor << factor << 1) >= 0; factor++);

            result += 1 << (factor - 1);
            dividend -= divisor << (factor - 1);
        }

        return positive ? result : -result;

    }
}
