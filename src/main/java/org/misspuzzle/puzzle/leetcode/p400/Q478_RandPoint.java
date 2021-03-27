package org.misspuzzle.puzzle.leetcode.p400;

public class Q478_RandPoint {
    private final double radius;
    private final double x_center;
    private final double y_center;


    public Q478_RandPoint(double radius, double x_center, double y_center) {
        this.radius = radius;
        this.x_center = x_center;
        this.y_center = y_center;
    }

    public double[] randPoint() {
        double len = Math.sqrt(Math.random())*radius;
        double angle = Math.random() * 360.0;
        double radians = Math.toRadians(angle);

        double x = x_center + len * Math.sin(radians);
        double y = y_center + len * Math.cos(radians);

        return new double[]{x, y};
    }
}
