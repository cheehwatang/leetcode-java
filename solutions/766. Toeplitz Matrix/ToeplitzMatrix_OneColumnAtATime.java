package com.cheehwatang.leetcode;

import java.util.LinkedList;
import java.util.List;

// Time Complexity  : O(n * m),
// where 'n' is the number of rows, and 'm' is the number of columns in the matrix.
// We traverse the matrix once to check if the matrix is Toeplitz.
//
// Space Complexity : O(n),
// where 'n' is the number of rows.
// We use a Linked List to store the elements of a column, with 'n' number of elements.

public class ToeplitzMatrix_OneColumnAtATime {

    // One column at a time.
    // For this, we use a Linked List to shift the column down,
    // by adding the new element into index 0 and remove the last element,
    // and check if it is the same as the previous row.
    // For Example:
    // [[0,1,2,3,4]      ->     [0],[1],[2],[3],[4]    ->           [0,9,8,7,6]
    //  [9,0,1,2,3]             [9],[0],[1],[2],[3]               [1,0,9,8,7]
    //  [8,9,0,1,2]             [8],[9],[0],[1],[2]             [2,1,0,9,8]
    //  [7,8,9,0,1]             [7],[8],[9],[0],[1]           [3,2,1,0,9]
    //  [6,7,8,9,0]]            [6],[7],[8],[9],[0]         [4,3,2,1,0]
    //
    // We compare [0,9,8,7,6] with
    //          [1,0,9,8,7], if the 0, 9, 8 and 7 is identical, proceed the next line.
    // Here, we shift the elements down.
    // For each iteration, update by removing the last element from the list and add new integer at index 0.

    public boolean isToeplitzMatrix(int[][] matrix) {
        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;

        // Initiate the linked list and add the first column to the linked list.
        List<Integer> list = new LinkedList<>();
        for (int[] row : matrix) list.add(row[0]);

        for (int column = 1; column < totalColumns; column++) {
            // Check the column to see if any is not identical to the linked list elements.
            for (int row = 1; row < totalRows; row++)
                if (matrix[row][column] != list.get(row - 1)) return false;

            // Update the linked list for the next line.
            list.remove(list.size() - 1);
            list.add(0, matrix[0][column]);
        }
        return true;
    }
}
