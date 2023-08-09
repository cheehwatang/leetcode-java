package com.cheehwatang.leetcode;

// Time Complexity  : O(m * n),
// where 'm' is the number of rows in 'grid', and 'n' is the number of columns in 'grid'.
// We traverse the matrix once, 'n' number of position in 'm' number of rows to count the negative numbers.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input size.

public class CountNegativeNumbersInASortedMatrix {

    // Approach:
    // Intuitive approach to traverse the matrix once with 2 for-loops to count the negative numbers.

    public int countNegatives(int[][] grid) {
        int count = 0;
        // For each row in 'grid',
        for (int[] row : grid) {
            // we check each element in the row and count the negative numbers.
            for (int j = 0; j < grid[0].length; j++) {
                if (row[j] < 0) count++;
            }
        }
        return count;
    }
}
