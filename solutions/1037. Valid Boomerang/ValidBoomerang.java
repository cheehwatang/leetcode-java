package com.cheehwatang.leetcode;

// Time Complexity  : O(1),
// as it is only an arithmetic calculation.
//
// Space Complexity : O(1),
// as no additional space is used.

public class ValidBoomerang {

    // Approach:
    // The three points forms a boomerang when the points form different slopes.
    // The points are linear if they have the same slopes.
    // Thus,
    // Slope_AB = (yB - yA) / (xB - xA) == (p[1][1] - p[0][1]) / (p[1][0] - p[0][0])
    // Slope_BC = (yC - yB) / (xC - xB) == (p[2][1] - p[1][1]) / (p[2][0] - p[1][0])
    // Boomerang when Slope_AB != Slope_BC.
    // Rather than calculating the fractions, which could be problematic with floating points,
    // rearrange the equation by multiplying the equation by its denominators.
    // (Slope_AB != Slope_BC) == ((yB - yA) * (xC - xB) != (yC - yB) * (xB - xA)).
    //
    // Note: Another method is to calculate the area of the triangle to check if the area is > 0,
    //       with area = Math.abs((xA * (yB - yC)) + (xB * (yC - yA)) + (xC * (yA - yB)) / 2.

    public boolean isBoomerang(int[][] points) {
        // If the index of the array is confusing, we can use additional memory to
        // assign the coordinates to variables before calculating the slopes.
        // For Example: xA = points[0][0], xB = points[1][0], etc.
        return (points[1][1] - points[0][1]) * (points[2][0] - points[1][0])
                != (points[2][1] - points[1][1]) * (points[1][0] - points[0][0]);
    }
}
