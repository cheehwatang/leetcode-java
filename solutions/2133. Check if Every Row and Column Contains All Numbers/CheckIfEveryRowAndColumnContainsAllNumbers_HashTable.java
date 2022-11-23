package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

// Time Complexity  : O(n^2),
// where 'n' is the length and width of the 'matrix', as we iterate through every position in the matrix.
//
// Space Complexity : O(n^2),
// where 'n' is the length and width of the 'matrix'.
// We use a new HashSets which grows linearly with 'n', for all 'n' rows and columns.

public class CheckIfEveryRowAndColumnContainsAllNumbers_HashTable {

    // Approach:
    // Using a new HashSet for each row and column to check if any duplicates found in that row or column.

    public boolean checkValid(int[][] matrix) {
        int n = matrix.length;
        // Both the 'i' and 'j' variables are used as both row and column position,
        // depending on whether we are using checking the row or the column.
        for (int i = 0; i < n; i++) {
            Set<Integer> row = new HashSet<>();
            Set<Integer> column = new HashSet<>();
            for (int j = 0; j < n; j++) {
                // When iterating through row 'i', the 'j' represents the column position in the row.
                // When iterating through column 'i', the 'j' represents the row position in the column.
                if (!row.add(matrix[i][j]) || !column.add(matrix[j][i])) return false;
            }
        }
        // If we successfully checked every number in 'matrix', meaning the matrix is valid.
        return true;
    }
}
