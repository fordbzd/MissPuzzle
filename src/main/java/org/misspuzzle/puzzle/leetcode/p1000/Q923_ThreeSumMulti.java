package org.misspuzzle.puzzle.leetcode.p1000;

public class Q923_ThreeSumMulti {
    public int threeSumMulti(int[] arr, int target) {

        int[] count = new int[101];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        long sum = 0;

        for (int i = 0; i < 101; i++) {
            if (count[i] == 0) {
                continue;
            }

            if (count[i] >= 3 && i * 3 == target) {
                sum += (long) count[i] * (count[i] - 1) * (count[i] - 2) / 6;
            }

            int i2 = target - i * 2;
            if (i2 != i && count[i] >= 2 && i2 >= 0 && i2 <= 100 && count[i2] > 0) {
                sum += (long) count[i] * (count[i] - 1) / 2 * count[target - i * 2];
            }

            if (count[i] >= 1) {
                for (int j = i + 1; j < 101; j++) {
                    if (count[j] > 0) {
                        int i3 = target - i - j;

                        if (i3 > j && i3 <= 100 && count[i3] > 0) {
                            sum += (long) count[i] * count[j] * count[i3];
                        }
                    }
                }
            }
        }

        return (int)(sum % (1e9 + 7));
    }
}
