package com.cheehwatang.leetcode;

// Time Complexity  : O(n^2),
// where 'n' is the length and width of the 'matrix'.
// For each row or column, we have to iterate from 0 to "n - 1" position.
// To be more precise, it would be O(2 * n * n).
//
// Space Complexity : O(n),
// where 'n' is the length and width of the 'matrix'.
// We use a counting array which grows linearly with 'n'.

public class CheckIfEveryRowAndColumnContainsAllNumbers {

    // Approach:
    // Using a counting array to keep track of the frequency for each number from 1 to 'n'.
    // We use a variable, 'count', to keep track of the frequency that is correct in a valid matrix.
    // For each time we iterate through the rows and columns, increase the 'count'.
    // If the frequency of the number in 'matrix' is different from the 'count', then the matrix is not valid.

    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;

        // Counting array need to record 'n', so we build the array as int[n + 1].
        int[] counting = new int[n + 1];
        int count = 0;
        // Here, the 'i' represents either the number of the row or the column,
        // depending on whether we are iterating through the row or the column.
        for (int i = 0; i < n; i++) {
            // We know that for each iteration of row or column, the count for all the numbers only increases by 1,
            // so we can be sure that if any number is greater or less than 'count' at the current iteration,
            // then 'matrix' is invalid.
            count++;
            for (int row = 0; row < n; row++) {
                // Here we are iterating through the column, checking the numbers at each 'row' position in the column.
                if (++counting[matrix[row][i]] != count) return false;
            }
            count++;
            for (int column = 0; column < n; column++) {
                // Here we are iterating through the row, checking the numbers at each 'column' position in the row.
                if (++counting[matrix[i][column]] != count) return false;
            }
        }
        // If we successfully checked every number in 'matrix', meaning the matrix is valid.
        return true;
    }
}
