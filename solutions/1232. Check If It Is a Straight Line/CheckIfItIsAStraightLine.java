package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'coordinates'.
// We traverse the 'coordinates' array to check if the coordinate with reference point has the same slope.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent on the input size.

public class CheckIfItIsAStraightLine {

    // Approach:
    // For the coordinates to be on the same straight line,
    // all the coordinates need to have the slope to a reference coordinate.
    // A slope, between coordinate A and B, is "(xB - xA) / (yB - yA)".
    // With the third coordinate C, the slope reference to coordinate A is "(xC - xA) / (yC - yA)".
    // Thus, the 3 points form a straight line if (xB - xA) / (yB - yA) == (xC - xA) / (yC - yA).
    // As floats or doubles can be unpredictable, we would rearrange the equation as such:
    // "(xB - xA) * (yC - yA) == (yB - yA) * (xC - xA)"
    // Using point A as the reference point, and slope A and B to be the reference slope,
    // we simplify the equation to "dx * (yC - yA) == dy * (xC - xA)".
    // We iterate through 'coordinates' to compare the slopes, return false if any slope is different.
    // If all points has the same slope, then return true.

    public boolean checkStraightLine(int[][] coordinates) {
        // Assign coordinates to variables for readability.
        int x0 = coordinates[0][0], y0 = coordinates[0][1], x1 = coordinates[1][0], y1 = coordinates[1][1];
        // Using the first and second point as reference slope.
        int dx = x1 - x0, dy = y1 - y0;
        for (int[] coordinate : coordinates) {
            int x = coordinate[0], y = coordinate[1];
            // Using coordinates[0] as reference point.
            // If the slope is different, return false.
            if (dy * (x - x0) != dx * (y - y0)) return false;
        }
        // If all coordinates have the same slope, return true.
        return true;
    }
}
