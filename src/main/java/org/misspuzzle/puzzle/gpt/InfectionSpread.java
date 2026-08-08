package org.misspuzzle.puzzle.gpt;

import java.util.*;

import org.misspuzzle.utils.Printer;

public class InfectionSpread {

    boolean debug;

    class Cell {
        int x;
        int y;
        int infectedDay;

        public Cell(int x, int y, int infectedDay) {
            this.x = x;
            this.y = y;
            this.infectedDay = infectedDay;
        }

        @Override
        public String toString() {
            return "x:" + x + ";y:" + y + ";day:" + infectedDay;
        }
    }

    final int[][] direct = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public int spread(int[][] grid, int D, int K) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        
        int row = grid.length;
        int col = grid[0].length;

        // Find all infected points to start
        Queue<Cell> active = new ArrayDeque<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    active.offer(new Cell(i, j, 0));
                }
            }
        }

        // BFS to infect
        int day = 0;

        while (active.size() > 0) {
            while (active.size() > 0 && active.peek().infectedDay + D <= day) {
                Cell c = active.poll();
                grid[c.x][c.y] = 2;
            }

            // Balance condition
            if (active.isEmpty()) {
                return day;
            }

            // Find infected
            List<Cell> toInfect = new ArrayList<>();

            for (Cell c : active) {
                List<Cell> candidates = infect(grid, c, day, K);
                toInfect.addAll(candidates);
            }

            // Mark infection
            for (var cell : toInfect) {
                grid[cell.x][cell.y] = 1;
                active.offer(cell);
            }

            day++;

            if (debug) {
                System.out.println("Day = " + day);
                Printer.printIntMatrix(grid);
            }
        }

        return day;
    }

    private List<Cell> infect(int[][] grid, Cell p, int day, int K) {
        int row = grid.length;
        int col = grid[0].length;

        List<Cell> toInfect = new ArrayList<>();

        for (var d : direct) {
            int x = p.x + d[0];
            int y = p.y + d[1];

            if (x >= 0 && x < row && y >= 0 && y < col) {
                if (grid[x][y] == 0 && getInfectedNeighbor(grid, x, y) >= K) {
                    Cell cell = new Cell(x, y, day);
                    grid[x][y] = -1;

                    toInfect.add(cell);
                }
            }
        }

        return toInfect;
    }

    private int getInfectedNeighbor(int[][] grid, int px, int py) {
        int row = grid.length;
        int col = grid[0].length;

        int count = 0;

        for (var d : direct) {
            int x = px + d[0];
            int y = py + d[1];

            if (x >= 0 && x < row && y >= 0 && y < col) {
                if (grid[x][y] == 1) {
                    count++;
                }
            }
        }

        return count;
    }
}
