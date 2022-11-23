package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

// Time Complexity  : O(n^2),
// where 'n' is 9, the length and width of the 'board'.
// This is because we iterate through every number in 'board'.
// Do note that the string concatenation take use some additional time,
// but they are constant time and do not scale linearly with 'n'.
//
// Space Complexity : O(n^2),
// where 'n' is 9, the length and width of the 'board'.
// This is due to the HashSet used, which stores the information of the number in the row, column and box.
// Every row with every 9 numbers, likewise for every column and every box,
// thus, to be more precise, it is O (n^2 + n^2 + n^2).

public class ValidSudoku_HashTable {

    // Approach:
    // Using a HashSet to record the number that was already found in the row, column and box.
    // If there are any same number in the row, column or box is already in the HashSet,
    // then we have found the identical number, which resulted in an invalid sudoku board.
    // There are multiple approaches for the HashSet, either use separate HashSet for the rows, columns and boxes,
    // or using String to include all the information into a single HashSet.
    // The latter approach is implemented here.

    public boolean isValidSudoku(char[][] board) {
        Set<String> set = new HashSet<>();
        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                char number = board[row][column];
                // If the position is a number (!= '.'),
                // then we can try adding the number and its information into the HashSet.
                if (number != '.') {
                    // The HashSet.add() function returns a boolean result, true if added successfully and false otherwise.
                    // As such, we can just use this boolean return from add() to check if we successfully added.
                    // If any of the 3 (row, column and box) is not added successfully,
                    // then 'board' is not a valid sudoku board.
                    // 1. Store the number in the row.
                    // 2. Store the number in the column.
                    // 3. Store the number in the box. (Make sure to separate row and column information with a delimiter).
                    if (!set.add(number + " in row " + row) ||
                            !set.add(number + " in column " + column) ||
                            !set.add(number + " in block " + (row / 3) + "," + (column / 3)))
                        return false;
                }
            }
        }
        // If all checks succeed, then the 'board' is a valid sudoku.
        return true;
    }
}
