package com.cheehwatang.leetcode;

// Time Complexity  : O(n^m),
// where 'm' is the number of rows (length of matrix), and 'n' is the number of columns (length of matrix[i]).
// We traverse every column in every row. Actually it is more like O(2 * n^m), since we traverse the matrix twice,
// First to find the zeros, and second update the correct integers to zero.
//
// Space Complexity : O(1),
// as we are using the top and left of the matrix to record the rows and columns with zeros.

public class SetMatrixZeroes_InPlace {

    // Approach:
    // Using the top row to record the position of zero for each row,
    // and the leftmost column (matrix[i][0]) to record the position of zero for each column.
    // For Example, if position matrix[2][3] contains a zero,
    // matrix = [[1,1,1,1,1]
    //           [1,1,1,0,1]
    //           [1,1,1,1,1]
    //           [1,1,1,1,1]]
    // we know that all the elements in row 2 and column 3 needs to be changed to zero.
    // Thus, we modify the top row and the leftmost column to indicate that row and column is zero.
    // matrix = [[1,1,1,0,1]
    //           [0,1,1,0,1]
    //           [1,1,1,1,1]
    //           [1,1,1,1,1]]
    // Note that this does not affect the end results, since we traverse the matrix from left to right, from top to bottom.
    // The top row and leftmost column is already checked.
    // Then as we traverse the matrix the second time,
    // we just need to check if the top row (matrix[0][i]) or leftmost column (matrix[i][0]) is zero.
    // matrix = [[1,1,1,0,1]
    //           [0,0,0,0,0]
    //           [1,1,1,0,1]
    //           [1,1,1,0,1]]
    //
    // Note that this method has an edge case that affects the outcome,
    // which is when either the first row or leftmost column have a zero.
    // If we use the same method, we will be modifying the first element (matrix[0][0]) to zero,
    // which affect both the row and column, even though we might only need to change either row or column but not both.
    // For Example:
    // matrix = [[1,1,1,0,1]     ->   [[0,1,1,0,1]    ->   [[0,0,0,0,0]
    //           [1,1,1,1,1]           [1,1,1,1,1]          [0,1,1,1,1]
    //           [1,1,1,1,1]           [1,1,1,1,1]          [0,1,1,1,1]
    //           [1,1,1,1,1]]          [1,1,1,1,1]]         [0,1,1,1,1]]
    // While the end result should only be,
    // matrix = [[0,0,0,0,0]
    //           [1,1,1,0,1]
    //           [1,1,1,0,1]
    //           [1,1,1,0,1]]
    // As such, we use this method for all rows and columns except the first.
    // Rather, we use a variable to indicate if the first row or column need to be modified to zero.

    public void setZeroes(int[][] matrix) {
        // 'm' is the number of row, and 'n' is the number of column.
        int m = matrix.length, n = matrix[0].length;
        // Although we can use two variables, one for row and another for column,
        // here we only use 'firstColumnHasZero' to indicate if the first column need to be modified later.
        boolean firstColumnHasZero = false;

        // Traverse the matrix the first time to find and record the rows and columns with zero.
        for (int row = 0; row < m; row++) {
            // Check the first column if it contains any zero.
            if (matrix[row][0] == 0) firstColumnHasZero = true;

            // Since we recorded the first column, we start checking from the second column (index 1) onwards.
            for (int column = 1; column < n; column++) {
                if (matrix[row][column] == 0) {
                    matrix[0][column] = 0;
                    matrix[row][0] = 0;
                }
            }
        }

        // Since we use the top row and the leftmost column to indicate, we traverse the array in reverse,
        // from right to left, from bottom to top,
        // to prevent the zeros in the top row and leftmost column from affecting the result.
        for (int row = m - 1; row >= 0; row--) {
            // Note that we skip the first column here,
            // because we use 'firstColumnHasZero' to check rather than the 0 is the top row.
            for (int column = n - 1; column >= 1; column--) {
                if (matrix[0][column] == 0 || matrix[row][0] == 0) {
                    matrix[row][column] = 0;
                }
            }
            if (firstColumnHasZero) matrix[row][0] = 0;
        }
        // As it is an in-place modification of the matrix, no return statement is needed.
    }
}
