package com.cheehwatang.leetcode;

// Time Complexity  : O(m * n),
// where 'm' is the number of rows, and 'n' is the number of columns of the 'board'.
// We traverse the 'board' in multiple occasions,
// 1. Set the set representative (parent) for every position in the 'board' to itself.
// 2. Traverse the 'board' to find lands, and union the land adjacent to another land.
// 3. Traverse the 'board' again to capture the 'O' to 'X' if the land is surrounded.
//
// Space Complexity : O(m * n),
// where 'm' is the number of rows, and 'n' is the number of columns of the 'board'.
// We used an array to keep track of the set representative (parent) for each position in the 'board'.

public class SurroundedRegions_UnionFind {

    // Approach:
    // Using Union-Find data structure, we first make all the positions on the 'board' as separate disjoint sets.
    // Then we visit every border positions to check for land 'O', since it is the non-surrounded region.
    // Once found, we assign the parent of the position to a 'dummyID'.
    // In this case, we use the size of the 'board' (m * n), since the 'board' matrix is 0-indexed.
    // Then, we traverse the 'board' to union all the connected land 'O' to its disjoint set,
    // while giving priority to the 'dummyID' as the parent.
    // Once all the lands are union to its respective disjoint sets,
    // we traverse the 'board' to capture the land 'O' that is surround, the land without 'dummyID' as the parent.

    public void solve(char[][] board) {
        int rows = board.length;
        int columns = board[0].length;

        // 'parent' array to record the set representatives for each position.
        // Note that we are hashing the position with 'row' and 'column' into 'nodeID' "row * column + column".
        int[] parent = new int[rows * columns + 1];

        // Set up the disjoint set data structure by referencing all the nodes (positions) to itself.
        for (int i = 0; i <= rows * columns; i++) {
            parent[i] = i;
        }

        int dummyID = rows * columns;
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                // Check the border positions,
                if (row == 0 || row == rows - 1 || column == 0 || column == columns - 1) {
                    // and mark any non-surrounded regions with the parent as 'dummyID'.
                    if (board[row][column] == 'O') {
                        parent[row * columns + column] = dummyID;
                    }
                }
            }
        }

        // This 'directions' array is to simplify the checks on all four directions.
        int[][] directions = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};

        // Traverse the 'board' to union all the connected land 'O' to its disjoint set,
        // while giving priority to the 'dummyID' as the parent.
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                // Skip if the position is water.
                if (board[row][column] == 'X') continue;
                int nodeID1 = row * columns + column;
                // If the position is land, check the four directions.
                for (int j = 0; j < directions.length; j++) {
                    int x = row + directions[j][0];
                    int y = column + directions[j][1];
                    // Skip if the direction position is out of bound.
                    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) continue;
                    // Skip if the direction position is water.
                    if (board[x][y] == 'X') continue;

                    // If the direction position is land, union the two lands.
                    int nodeID2 = x * columns + y;
                    union(nodeID1, nodeID2, parent, dummyID);
                }
            }
        }

        // Once all the lands are in their respective disjoint sets,
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                if (board[row][column] == 'X') continue;
                int nodeID = row * columns + column;
                // Capture the land that is surrounded, the land without 'dummyID' as the parent.
                if (find(nodeID, parent) != dummyID) board[row][column] = 'X';
            }
        }
    }

    // The find() method, with path compression implemented to reduce time complexity.
    private int find(int nodeID, int[] parent) {
        // Once the node has itself as the parent,
        // then we have found the set representative (parent) of this disjoint set.
        if (parent[nodeID] == nodeID) {
            return nodeID;
        }

        // If not, then we continue to find.
        // Once the parent is found, the node is referenced to the parent,
        // compressing the path from the node to the set representative (parent).
        return parent[nodeID] = find(parent[nodeID], parent);
    }

    // The union() method.
    // Note that union by rank is not implemented,
    // as we need to prioritize the land connected to 'dummyID' to be the parent.
    private void union(int nodeID1, int nodeID2, int[] parent, int dummyID) {
        // Find the parent for both nodes.
        int find1 = find(nodeID1, parent);
        int find2 = find(nodeID2, parent);

        // If the parents are the same, then both nodes are already in the same disjoint set.
        if (find1 == find2) return;

        // If 'find1' is part of the non-surrounded region (with 'dummyID'), make 'find1' the parent of 'find2'.
        if (find1 == dummyID) {
            parent[find2] = find1;
        }
        // If 'find2' is part of the non-surrounded region (with 'dummyID'), make 'find2' the parent of 'find1'.
        // Note that if either nodes are with 'dummyID', then we just defaults to 'find2' as parent, or vice versa.
        else {
            parent[find1] = find2;
        }
    }
}
