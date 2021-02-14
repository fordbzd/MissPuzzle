package org.misspuzzle.puzzle.leetcode.p1100;

import java.util.LinkedList;
import java.util.Queue;

public class Q1091_ShortestPathBinaryMatrix {

    public int shortestPathBinaryMatrix(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0 || grid[0][0] != 0) {
            return -1;
        }

        int row = grid.length;
        int col = grid[0].length;

        int k = 1;

        Coordinate[] directions = new Coordinate[] {
            new Coordinate(-1, -1),
            new Coordinate(-1, 0),
            new Coordinate(-1, 1),
            new Coordinate(0, 1),
            new Coordinate(0, -1),
            new Coordinate(1, -1),
            new Coordinate(1, 0),
            new Coordinate(1, 1)
        };

        Queue<Coordinate> queue = new LinkedList<>();
        queue.add(new Coordinate(0, 0));
        grid[0][0] = 1;

        while (queue.size() > 0) {
            Queue<Coordinate> newQueue = new LinkedList<>();

            while (queue.size() > 0) {
                Coordinate coordinate = queue.poll();

                if (coordinate.x == row - 1 && coordinate.y == col - 1) {
                    return k;
                }

                for (Coordinate direction : directions) {
                    int newX = coordinate.x + direction.x;
                    int newY = coordinate.y + direction.y;

                    if (newX >= 0 && newY >= 0 && newX < row && newY < col && grid[newX][newY] == 0) {
                        newQueue.add(new Coordinate(newX, newY));
                        grid[newX][newY] = 1;
                    }
                }
            }

            queue = newQueue;
            k++;
        }

        return -1;
    }

    static class Coordinate {
        int x;
        int y;
        Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
