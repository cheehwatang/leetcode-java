package com.cheehwatang.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// Time Complexity  : O(m * n),
// where 'm' is the number of rows, and 'n' is the number of columns of the 'board'.
// We perform breadth-first search (BFS) of the non-surrounded region, for a maximum of the whole 'board',
// and we check every position in the matrix for 'O'.
//
// Space Complexity : O(m + n),
// where 'm' is the number of rows, and 'n' is the number of columns.
// This is due to the Queue used in the breadth first search when we found 'i'.
// As we are adding and removing positions (nodes) at each level, the Queue can only grow to a maximum of 'm' + 'n' size.

public class SurroundedRegions_BFS {

    // Approach:
    // Visit every border positions to check for land 'O', since it is the non-surrounded region.
    // Once found the first land 'O' of the non-surrounded region,
    // perform breadth-first search (BFS) to mark the whole region.
    // With all the non-surrounded regions marked, we traverse through the whole 'board'
    // to capture the remaining land 'O' on the 'board', and convert the marked positions back to 'O'.
    // Note that we are marking the non-surrounded regions in-place, so we need to convert it back.
    // It is optional to use another matrix for marking, which we only capture the land 'O' not marked.

    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        // Check the border positions, and perform the BFS to mark any non-surrounded regions.
        Queue<int[]> queue = new LinkedList<>();
        for (int row = 0; row < m; row++) {
            for (int column = 0; column < n; column++) {
                // Check the border,
                if (row == 0 || row == m - 1 || column == 0 || column == n - 1) {
                    // if we found the non-surrounded land, add to the queue for BFS.
                    // Note to mark it by changing the 'O' to '-'.
                    if (board[row][column] == 'O') {
                        board[row][column] = '-';
                        queue.offer(new int[]{row, column});
                    }
                }
            }
        }

        // This 'directions' array is to simplify the checks on all four directions.
        // Alternatively, we can individually code the directions when performing BFS.
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        // With the border non-surrounded lands marked,
        // we perform BFS to mark the lands connected to the non-surrounded land at the border.
        while (!queue.isEmpty()) {
            for (int i = 0, size = queue.size(); i < size; i++) {
                int[] current = queue.poll();
                // For every direction,
                for (int j = 0; j < directions.length; j++) {
                    int x = current[0] + directions[j][0];
                    int y = current[1] + directions[j][1];
                    // check if the position is out of bound of the matrix,
                    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) continue;
                    // or is either the water 'X' or visited land '-'.
                    if (board[x][y] == 'X' || board[x][y] == '-') continue;

                    // If not, mark the position and add the position to the queue.
                    board[x][y] = '-';
                    queue.offer(new int[]{x, y});
                }
            }
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
}
