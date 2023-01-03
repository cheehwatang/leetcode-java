package com.cheehwatang.leetcode;

// Time Complexity  : O(m * n),
// where 'm' is the number of rows, and 'n' is the number of columns of the 'grid'.
// We check every position in the 'grid' for land '1',
// and perform depth-first search (DFS) for a maximum of the whole 'grid'.
//
// Space Complexity : O(m * n),
// where 'm' is the number of rows, and 'n' is the number of columns of the 'grid'.
// Even though we modify the 'grid' in-place,
// the recursive depth first search (DFS) function has a maximum call stack of every position in the 'grid'.

public class NumberOfIslands_DFS {

    // Approach:
    // Search the whole 'grid' for land '1'.
    // Whenever we found a land '1', we use depth-first search to "sink" the land, changing the '1' to '0'.
    // Then we use a variable to keep track of the number of islands we encounter.
    // Remember, each depth-first search started only accounts for one island.

    // Main method to find the land and call the recursive DFS method.
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        // Variable to keep track of island count.
        int islands = 0;

        // Search through every position in the 'grid' for land '1'.
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (grid[row][column] == '1') {
                    // When found, it is an island, and we sink the land '1' connected.
                    islands++;
                    sinkIsland(grid, row, column);
                }
            }
        }
        return islands;
    }

    // Recursive DFS method to change the land '1' to water '0'.
    private void sinkIsland(char[][] grid, int row, int column) {
        // If the position is out of bound, or if the position is water '0', return.
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[row].length || grid[row][column] == '0') return;
        // Change the land '1' to water '0'.
        grid[row][column] = '0';
        // Search all four directions (up, down, left, right).
        sinkIsland(grid, row + 1, column);
        sinkIsland(grid, row - 1, column);
        sinkIsland(grid, row, column + 1);
        sinkIsland(grid, row, column - 1);
    }
}
