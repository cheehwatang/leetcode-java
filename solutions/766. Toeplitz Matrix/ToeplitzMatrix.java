package com.cheehwatang.leetcode;

// Time Complexity  : O(n * m),
// where 'n' is the number of rows, and 'm' is the number of columns in the matrix.
// We traverse the matrix once to check if the matrix is Toeplitz.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent on the size of the input 'matrix'.

public class ToeplitzMatrix {

    // Approach:
    // Traverse through the array to check the next element matrix[i + 1][j + 1] if it is different.
    // If all is the same, then return true.

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Note: Check if i + 1 and j + 1 is within the matrix, to ensure there is no IndexOutOfBound error.
                if (i + 1 < m && j + 1 < n && matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        // If successfully traverse the whole array, return true.
        return true;
    }
}
