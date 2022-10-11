package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given an array of points with coordinates [x,y] in a 2D plane,
 * return the area of the largest triangle that be formed using any of the three different points.
 *
 *
 * Example 1:
 * Input    : points = [[0,0],[0,2],[2,0]]
 * Output   : 2.00000
 *
 *
 * Example 2:
 * Input    : points = [[0,0],[0,2],[2,0],[0,3],[3,0]]
 * Output   : 4.50000
 *
 *
 * @author Chee Hwa Tang
 */


public class LargestTriangleArea {

    // Approach:
    // The equation to calculate the triangle area of any 3 points:
    // 1. (1/2) * (x1*y2 + x2*y3 + x3*y1 - x1*y3 - x2*y1 - x3*y2), or simplified to
    // 2. (1/2) * (x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2))
    // Time-Complexity = O(N3) as we need to traverse the 'points' in 3 for-loops.

    public double largestTriangleArea(int[][] points) {

        double maxArea = 0d;
        // Check each combination of 3 points.
        for (int i = 0; i < points.length; i++) {
            for (int j = i + 1; j < points.length; j++) {
                for (int k = j + 1; k < points.length; k++) {

                    // Using the formula mentioned above to calculate the area.
                    double area = Math.abs(points[i][0] * (points[j][1] - points[k][1]) +
                            points[j][0] * (points[k][1] - points[i][1]) +
                            points[k][0] * (points[i][1] - points[j][1])) * 0.5;
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }
}
