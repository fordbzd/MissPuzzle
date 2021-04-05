package org.misspuzzle.puzzle.leetcode.p900;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Q936_MovesToStamp {
    public int[] movesToStamp(String stamp, String target) {
        char[] S = stamp.toCharArray();
        char[] T = target.toCharArray();

        List<Integer> result = new ArrayList<>();
        int replaced = 0;

        while (replaced != T.length) {
            boolean isReplaced = false;

            for (int i = 0; i <= T.length - S.length; i++) {
                int count = replace(S, T, i);

                if (count > 0) {
                    isReplaced = true;
                    replaced += count;
                    result.add(i);

                    if (replaced == T.length) {
                        break;
                    }
                }
            }

            if (!isReplaced) {
                return new int[0];
            }
        }

        Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int replace(char[] S, char[] T, int start) {
        for (int i = 0; i < S.length; i++) {
            if (T[start + i] != '?' && T[start + i] != S[i]) {
                return 0;
            }
        }

        int count = 0;
        for (int i = 0; i < S.length; i++) {
            if (T[start + i] != '?') {
                T[start + i] = '?';
                count++;
            }
        }

        return count;
    }
}
