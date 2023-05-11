package com.cheehwatang.leetcode;

import java.util.LinkedList;
import java.util.List;

// Time Complexity  : O(n * m),
// where 'n' is the number of rows, and 'm' is the number of columns in the matrix.
// We traverse the matrix once to check if the matrix is Toeplitz.
//
// Space Complexity : O(m),
// where 'm' is the number of columns.
// We use a Linked List to store the elements of a row, with 'm' number of elements.

public class ToeplitzMatrix_OneRowAtATime {

    // One row at a time.
    // For this, we use a Linked List to shift the row to left,
    // by adding the new element into index 0 and remove the last element,
    // and check if it is the same as the previous row.
    // For Example:
    // [[0,1,2,3,4]      ->             [0,1,2,3,4]
    //  [9,0,1,2,3]                   [9,0,1,2,3]
    //  [8,9,0,1,2]                 [8,9,0,1,2]
    //  [7,8,9,0,1]               [7,8,9,0,1]
    //  [6,7,8,9,0]]            [6,7,8,9,0]
    //
    // We compare [0,1,2,3,4] with
    //          [9,0,1,2,3], if the 0, 1, 2 and 3 is identical, proceed the next line.
    // Here, we shift the elements to the left.
    // For each iteration, update by removing the last element from the list and add new integer at index 0.

    public boolean isToeplitzMatrix(int[][] matrix) {
        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;

        // Initiate the linked list and add the first row to the linked list.
        List<Integer> list = new LinkedList<>();
        for (int number : matrix[0]) list.add(number);

        for (int row = 1; row < totalRows; row++) {
            // Check the row to see if any is not identical to the linked list elements.
            for (int column = 1; column < totalColumns; column++)
                if (matrix[row][column] != list.get(column - 1))
                    return false;
            // Update the linked list for the next line.
            list.remove(list.size() - 1);
            list.add(0, matrix[row][0]);
        }
        return true;
    }
}
