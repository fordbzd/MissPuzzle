package org.misspuzzle.datastructure;

import java.util.Arrays;

public class FenwickTree {

    int[] arr;

    public FenwickTree(int size) {
        arr = new int[size];
    }

    /**
     * Convert an array in place to Fenwick tree form.
     *
     * @param arr array to convert.
     */
    public FenwickTree(int[] arr) {
        this.arr = arr;

        for (int i = 1; i <= arr.length; i++) {
            int j = i + LSBit(i);
            if (j <= arr.length) {
                arr[j - 1] += arr[i - 1];
            }
        }
    }

    public void add(int index, int delta) {
        for (index++; index <= arr.length; index += LSBit(index)) {
            arr[index - 1] += delta;
        }
    }

    public void set(int index, int value) {
        int delta = value - get(index);

        add(index, delta);
    }

    public int get(int index) {
        return (int) rangeSum(index, index + 1);
    }

    public long prefixSum(int index) {
        long sum = 0;

        for (index++; index > 0; index -= LSBit(index)) {
            sum += arr[index - 1];
        }

        return sum;
    }

    /**
     * Returns the sum of elements from start to end-1
     * @param start start index
     * @param end end index
     * @return range sum
     */
    public long rangeSum(int start, int end) {
        return prefixSum(end - 1) - prefixSum(start - 1);
    }

    public int[] getFlatArray() {
        int[] flatArr = Arrays.copyOf(arr, arr.length);

        for (int i = arr.length; i > 0; i--) {
            int j = i + LSBit(i);

            if (j <= arr.length) {
                arr[j - 1] -= arr[i - 1];
            }
        }

        return flatArr;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();

        for (int value : arr) {
            sb.append(value);
            sb.append(" ");
        }

        return sb.toString();
    }

    /**
     * Get least-significant set bit in index
     *
     * @param index index
     * @return least-significant set bit in i
     */
    private static int LSBit(int index) {
        return index & -index;
    }
}
