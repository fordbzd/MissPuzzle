package org.misspuzzle.utils;

public final class Printer {

    public static void printIntArray(int[] arr) {
        StringBuilder sb = new StringBuilder();

        for(int v : arr) {
            sb.append(v);
            sb.append(" ");
        }

        System.out.println(sb);
    }

    public static void printIntMatrix(int[][] matrix) {
        for(int[] arr : matrix) {
            printIntArray(arr);
        }
    }

}
