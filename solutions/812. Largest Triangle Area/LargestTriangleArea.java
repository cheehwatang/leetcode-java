package com.cheehwatang.leetcode;

// Time Complexity  : O(n^3),
// where 'n' is the length of 'points'.
// We traverse 'points' in 3 for-loops to check every combination.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent on the size of the input 'points'.

public class LargestTriangleArea {

    // Approach:
    // The equation to calculate the triangle area of any 3 points:
    // 1. (1/2) * (x1*y2 + x2*y3 + x3*y1 - x1*y3 - x2*y1 - x3*y2), or simplified to
    // 2. (1/2) * (x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2))
    // We traverse the 'points' in 3 for-loops to check every combination.

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
