package com.cheehwatang.leetcode;

// Time Complexity  : O(m * n),
// where 'm' is the length of each string in 'strs' (strs[0].length()),
// and 'n' is the number of strings in 'strs'.
// We iterate through every letter in every string to check if the letters in the column is in non-descending order.
//
// Space Complexity : O(1),
// as we only variable that is independent of the size of the input.

public class DeleteColumnsToMakeSorted {

    // Approach:
    // Iterate through the strings in 'strs' column-wise,
    // check if the current letter is lexicographically smaller than the previous letter in the column.
    // If smaller, increase the count by 1, and move on to the next column.

    public int minDeletionSize(String[] strs) {
        int columnsToDelete = 0;

        // Iterate the 'strs' column-wise.
        for (int column = 0; column < strs[0].length(); column++) {
            // Start the row at 1, as there is no previous string to compare to.
            for (int row = 1; row < strs.length; row++) {
                // If the current letter lexicographically smaller than the previous letter in the column,
                // increase the 'columnsToDelete' by one and move on to the next column.
                if (strs[row].charAt(column) < strs[row - 1].charAt(column)) {
                    columnsToDelete++;
                    break;
                }
            }
        }
        return columnsToDelete;
    }
}
