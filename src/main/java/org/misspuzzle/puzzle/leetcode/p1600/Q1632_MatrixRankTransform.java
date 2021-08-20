package org.misspuzzle.puzzle.leetcode.p1600;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class Q1632_MatrixRankTransform {
    public int[][] matrixRankTransform(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        int[][] result = new int[row][col];

        Cell[] cells = new Cell[row * col];

        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                cells[index++] = new Cell(i, j, matrix[i][j]);
            }
        }

        Arrays.sort(cells, Comparator.comparingInt(x -> x.val));

        int[] rowLast = new int[row];
        Arrays.fill(rowLast, -1);
        int[] colLast = new int[col];
        Arrays.fill(colLast, -1);

        for (int i = 0; i < cells.length; i++) {
            Cell cell = cells[i];

            int rowRank = rowLast[cell.x] >= 0
                    ? (cell.val == matrix[cell.x][rowLast[cell.x]] ? result[cell.x][rowLast[cell.x]] : result[cell.x][rowLast[cell.x]] + 1)
                    : 1;
            int colRank = colLast[cell.y] >= 0
                    ? (cell.val == matrix[colLast[cell.y]][cell.y] ? result[colLast[cell.y]][cell.y] : result[colLast[cell.y]][cell.y] + 1)
                    : 1;

            result[cell.x][cell.y] = Math.max(rowRank, colRank);

            rowLast[cell.x] = cell.y;
            colLast[cell.y] = cell.x;

            // Equal with same x/y, find & union and picks the max(last)
            int j = i - 1;
            Cell head = cell;
            Set<Cell> set = new HashSet<>();
            while (j >= 0 && cells[j].val == cells[j + 1].val) {
                if (!set.contains(cells[j]) && (cells[j].x == cell.x || cells[j].y == cell.y)) {
                    Cell node = cells[j];
                    while (node != node.next) {
                        node = node.next;
                    }

                    node.next = head;
                    head.pre = node;
                    set.add(head);

                    while (head.pre != head) {
                        head = head.pre;
                        set.add(head);
                    }
                }

                j--;
            }

            while (head.next != head) {
                result[head.x][head.y] = result[cell.x][cell.y];
                head = head.next;
            }
        }

        return result;

    }

    static class Cell {
        int x;
        int y;
        int val;
        Cell pre;
        Cell next;

        Cell(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
            pre = this;
            next = this;
        }

        public String toString() {
            return x + "\t" + y + "\t" + val;
        }
    }
}
