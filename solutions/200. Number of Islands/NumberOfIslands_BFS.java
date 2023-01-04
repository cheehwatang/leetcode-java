package com.cheehwatang.leetcode;

import java.util.LinkedList;
import java.util.Queue;

// Time Complexity  : O(m * n),
// where 'm' is the number of rows, and 'n' is the number of columns of the 'grid'.
// We check every position in the 'grid' for land '1',
// and worst case if the whole 'grid' is an island, we perform a full breadth first search which is O(m * n),
// resulting in the worst case of O(2 * m * n).
//
// Space Complexity : O(m + n),
// where 'm' is the number of rows, and 'n' is the number of columns of the 'grid'.
// This is due to the Queue used in the breadth first search when we found 'i'.
// As we are adding and removing positions (nodes) at each level, the Queue can only grow to a maximum of 'm' + 'n' size.

public class NumberOfIslands_BFS {

    // Approach:
    // Search the whole 'grid' for land '1'.
    // Whenever we found a land '1', we use breadth-first search to "sink" the land, changing the '1' to '0'.
    // Then we use a variable to keep track of the number of islands we encounter.
    // Remember, each breadth-first search started only accounts for one island.

    public static int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        // Creating an array for the directions (up, down, left, right) for simpler execution later.
        int[][] directions = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};

        // Variable to keep track of island count.
        int islands = 0;

        // Search through every position in the 'grid' for land '1'.
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                // If not land, continue.
                if (grid[row][column] == '0') continue;

                // Increase the island count accordingly,
                // before starting the breadth first search to "sink" the island.
                islands++;

                // Breadth first search implementation.
                Queue<int[]> queue = new LinkedList<>();
                // Note to always set the '1' to '0' first before adding the position to the queue,
                // to prevent accidental repeated search of the same position.
                grid[row][column] = '0';
                queue.offer(new int[] {row, column});
                while (!queue.isEmpty()) {
                    // Remember to set a variable for the queue size for each level,
                    // as we are constantly changing the queue size,
                    // which may lead to infinite loop or accidentally ending of loop if the variable is not set.
                    for (int i = 0, n = queue.size(); i < n; i++) {
                        int[] current = queue.poll();
                        // Iterate through all four directions (up, down, left, right).
                        for (int[] direction : directions) {
                            int x = current[0] + direction[0];
                            int y = current[1] + direction[1];
                            // Skip the direction if it leads to out of bound.
                            if (x < 0 || x >= rows || y < 0 || y >= columns) continue;
                            // "sink" the land and continue the BFS.
                            if (grid[x][y] == '1') {
                                grid[x][y] = '0';
                                queue.offer(new int[]{x, y});
                            }
                        }
                    }
                }
            }
        }
        // When we finish checking every position in 'grid', return the number of islands.
        return islands;
    }
}
