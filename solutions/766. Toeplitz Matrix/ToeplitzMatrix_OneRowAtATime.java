package com.cheehwatang.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * Problem:
 * Given an m x n matrix, return true if the matrix is Toeplitz, return false otherwise.
 * A Toeplitz matrix is which every diagonal elements from top=left to bottom-right has the same elements.
 *
 * Extra Constraint:
 * - What if we can only read the matrix one row at a time?
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
        List<Integer> linkedList = new LinkedList<>();
        for (int integer : matrix[0]) linkedList.add(integer);

        for (int row = 1; row < totalRows; row++) {
            // Check the row to see if any is not identical to the linked list elements.
            for (int column = 1; column < totalColumns; column++)
                if (matrix[row][column] != linkedList.get(column - 1))
                    return false;
            // Update the linked list for the next line.
            linkedList.remove(linkedList.size() - 1);
            linkedList.add(0, matrix[row][0]);
        }
        return true;
    }
}
