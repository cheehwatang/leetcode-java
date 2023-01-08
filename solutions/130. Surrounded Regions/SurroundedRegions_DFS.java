package com.cheehwatang.leetcode;

// Time Complexity  : O(m * n),
// where 'm' is the number of rows, and 'n' is the number of columns of the 'board'.
// We perform depth-first search (DFS) of the non-surrounded region, for a maximum of the whole 'board',
// and we check every position in the matrix for 'O'.
//
// Space Complexity : O(m * n),
// where 'm' is the number of rows, and 'n' is the number of columns of the 'board'.
// Even though we modify the 'board' in-place,
// the recursive depth first search (DFS) function has a maximum call stack of every position in the 'board'.

public class SurroundedRegions_DFS {

    // Approach:
    // Visit every border positions to check for land 'O', since it is the non-surrounded region.
    // Once found the first land 'O' of the non-surrounded region,
    // perform depth-first search (DFS) to mark the whole region.
    // With all the non-surrounded regions marked, we traverse through the whole 'board'
    // to capture the remaining land 'O' on the 'board', and convert the marked positions back to 'O'.
    // Note that we are marking the non-surrounded regions in-place, so we need to convert it back.
    // It is optional to use another matrix for marking, which we only capture the land 'O' not marked.

    // Main method to capture the surrounded regions.
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Check the border positions, and perform the DFS to mark any non-surrounded regions.
        // First is to check the left and right border.
        for (int row = 0; row < m; row++) {
            markNonSurroundedRegion(board, row, 0);
            markNonSurroundedRegion(board, row, n - 1);
        }
        // Second is to check the top and bottom border.
        for (int column = 0; column < n; column++) {
            markNonSurroundedRegion(board, 0, column);
            markNonSurroundedRegion(board, m - 1, column);
        }

        // With all the non-surrounded regions marked, we can capture the remaining land 'O' to 'X',
        // and convert the marked land '-' back to 'O'.
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                if (board[row][column] == 'O') board[row][column] = 'X';
                else if (board[row][column] == '-') board[row][column] = 'O';
            }
        }
    }

    // Recursive DFS method to mark the non-surrounded regions.
    private void markNonSurroundedRegion(char[][] board, int row, int column) {
        // If the position is out of bound, return.
        if (row < 0 || row >= board.length || column < 0 || column >= board[0].length) return;
        // If the position is not land or already marked, return.
        if (board[row][column] == 'X' || board[row][column] == '-') return;

        // With the above check passed, this position is a land 'O' in a non-surrounded region, so mark it as '-'.
        board[row][column] = '-';

        // Continue the recursive DFS for all four directions.
        markNonSurroundedRegion(board, row + 1, column);
        markNonSurroundedRegion(board, row - 1, column);
        markNonSurroundedRegion(board, row, column + 1);
        markNonSurroundedRegion(board, row, column - 1);
    }
}
