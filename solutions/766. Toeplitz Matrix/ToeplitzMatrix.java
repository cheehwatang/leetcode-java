package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given an m x n matrix, return true if the matrix is Toeplitz, return false otherwise.
 * A Toeplitz matrix is which every diagonal elements from top=left to bottom-right has the same elements.
 *
 *
 * Example 1:
 * Input    : matrix = [[0,1,2,3,4],
 *                      [9,0,1,2,3],
 *                      [8,9,0,1,2],
 *                      [7,8,9,0,1],
 *                      [6,7,8,9,0]]
 * Output   : true
 * Explanation : Each diagonal (top-left to bottom-right direction) has the identical elements.
 *
 *
 * Example 2:
 * Input    : matrix = [[0,1,2],
 *                      [1,2,3]]
 * Output   : false
 * Explanation : The diagonals with identical elements are not in the top-left to bottom-right direction.
 *
 *
 * @author Chee Hwa Tang
 */

public class ToeplitzMatrix {

    // Approach:
    // Traverse through the array to check the next element matrix[i + 1][j + 1] if it is different.
    // If all is the same, then return through.

    public boolean isToeplitzMatrix(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Make sure to check if i + 1 and j + 1 is within the matrix.
                // If not, there will be IndexOutOfBound error.
                if (i + 1 < m && j + 1 < n && matrix[i][j] != matrix[i + 1][j + 1]) {
                    return false;
                }
            }
        }
        // If successfully traverse the whole array, return true.
        return true;
    }
}
