package com.cheehwatang.leetcode;

// Time Complexity  : O(n^6),
// where 'n' is the width or length of the 'board'.
// First, we need to iterate through every position (n * n).
// Second, for each position, we need to recursively check the other position,
// with worst case being fully backtracking the whole 'board' (n * n).
// Third, for each position and recursive call, we need to test number '1' to '9',
// and check if number placement is valid by checking the row, column and box. (3 * n * n).
// As the grid size is 9, the bad polynomial time complexity is acceptable, with 9 ^ 6 == 531,441.
//
// Space Complexity : O(n^2),
// where 'n' is the width or length of the 'board',
// as the recursive call stack has a maximum height of n^2 (9 * 9 == 81).

public class SudokuSolver {

    // As Sudoku board is a 9 by 9 grid, we can set a constant for readability.
    private final int GRID_SIZE = 9;

    // Wrapper method to call the recursive function.
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    // Recursive method for backtracking.
    private boolean solve(char[][] board) {
        // Check every position in the 'board'.
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                // If the position is already a number, continue to the next position.
                if (board[i][j] != '.') continue;
                // If the position is empty ('.'), test if any number from '1' to '9' is a valid placement in the 'board',
                // meaning no identical number found the row, column or box.
                for (char number = '1'; number <= '9'; number++) {
                    if (isValidPlacement(board, number, i, j)) {
                        // Set the number, and call the recursive method to continue solving the rest of the 'board'.
                        // If successfully placed all valid number, return true.
                        board[i][j] = number;
                        if (solve(board)) return true;
                    }
                }
                // If no number from '1' to '9' is valid placement, then we reset the position to empty ('.'),
                // return false so the call stack can backtrack and try other numbers in the previous positions.
                board[i][j] = '.';
                return false;
            }
        }
        // If we reach the end of the 'board', then we have successfully solved the sudoku.
        return true;
    }

    // Method to check if identical number found in the row.
    private boolean isNumberInRow(char[][] board, char number, int row) {
        for (int column = 0; column < GRID_SIZE; column++) {
            // Check if any identical number in the row and return true if found.
            if (board[row][column] == number) return true;
        }
        // If we did not find any identical number in the row, then return false.
        return false;
    }

    // Method to check if identical number found in the column.
    private boolean isNumberInColumn(char[][] board, char number, int column) {
        for (int row = 0; row < GRID_SIZE; row++) {
            // Check if any identical number in the column and return true if found.
            if (board[row][column] == number) return true;
        }
        // If we did not find any identical number in the column, then return false.
        return false;
    }

    // Method to check if identical number found in the box.
    private boolean isNumberInBox(char[][] board, char number, int row, int column) {
        // Here, we get the top left corner position of the box the 'number' is in,
        // because we are going to scan from top left to bottom right of the box.
        int firstRowOfBox = row - row % 3;
        int firstColumnOfBox = column - column % 3;

        // Checking just the 3 row and 3 column position in the box.
        for (int i = firstRowOfBox; i < firstRowOfBox + 3; i++) {
            for (int j = firstColumnOfBox; j < firstColumnOfBox + 3; j++) {
                // Check if any identical number in the box and return true if found.
                if (board[i][j] == number) return true;
            }
        }
        // If we did not find any identical number in the box, then return false.
        return false;
    }

    // Additional wrapper method for all three checks to make the code more readable.
    private boolean isValidPlacement(char[][] board, char number, int row, int column) {
        // If the number is not found in the row, column and the box, then it is a valid placement and return true.
        return !isNumberInRow(board, number, row) &&
                !isNumberInColumn(board, number, column) &&
                !isNumberInBox(board, number, row, column);
    }
}
