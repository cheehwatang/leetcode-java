package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

// Time Complexity  : O(n^m),
// where 'm' is the number of rows (length of matrix), and 'n' is the number of columns (length of matrix[i]).
// We traverse every column in every row. Actually it is more like O(2 * n^m), since we traverse the matrix twice,
// First to find the zeros, and second update the correct integers to zero.
//
// Space Complexity : O(m + n),
// where 'm' is the number of rows (length of matrix), and 'n' is the number of columns (length of matrix[i]),
// as we use HashSet to record the row and column number with the zero,
// with worst case being the whole matrix started with all zeros.

public class SetMatrixZeroes_HashTable {

    // Approach:
    // Using two HashSets to record the position of the rows and columns with zeros in it.
    // For Example, if position matrix[2][3] contains a zero,
    // we know that all the elements in row 2 and column 3 needs to be changed to zero.
    // If another position, matrix[2][5] contains a zero,
    // then row 2 remains, while now we need to change the elements in column 5 to zero.
    //
    // We traverse the matrix once to record the positions of the zeros, if any, without modifying matrix.
    // Depend on how we modify the matrix, modifying the matrix now can result in accidental change to elements.
    // As such, we only change the elements to zero once we have mapped out the rows and columns that need to be modified.

    public void setZeroes(int[][] matrix) {
        // 'm' is the number of row, and 'n' is the number of column.
        int m = matrix.length, n = matrix[0].length;

        // We store the row index or column index with zero.
        Set<Integer> rowSet = new HashSet<>();
        Set<Integer> columnSet = new HashSet<>();

        // Traverse the matrix the first time to find and record the rows and columns with zero.
        for (int row = 0; row < m; row++)
            for (int column = 0; column < n; column++)
                if (matrix[row][column] == 0) {
                    rowSet.add(row);
                    columnSet.add(column);
                }

        // Traversing the matrix the second time, if that row or column number is in the respective HashSet,
        // modify the element to zero.
        for (int row = 0; row < m; row++)
            for (int column = 0; column < n; column++)
                if (rowSet.contains(row) || columnSet.contains(column))
                    matrix[row][column] = 0;

        // As it is an in-place modification of the matrix, no return statement is needed.
    }
}
