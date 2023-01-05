package com.cheehwatang.leetcode;

// Time Complexity  : O(m * n),
// where 'm' is the number of rows, and 'n' is the number of columns of the 'grid'.
// We traverse the 'grid' in two occasions,
// 1. Set the set representative (parent) for land '1' in the 'grid' to itself.
// 2. Traverse the 'grid' to find lands, and union the land adjacent to another land.
//
// Space Complexity : O(m * n),
// where 'm' is the number of rows, and 'n' is the number of columns of the 'grid'.
// We used an array to keep track of the set representative (parent) for each position in the 'grid'.

public class NumberOfIslands_UnionFind {

    // Approach:
    // Using Union-Find data structure, we first make all the land '1' on the 'grid' as separate disjoint sets,
    // or separate islands.
    // Imagine we start with many islands of only one land '1'.
    // As we traverse 'grid' and check if two lands '1' are adjacent to one another,
    // we merge (union) the two lands '1' as a single island, reducing the number of islands by one.
    // Once we have traversed the whole 'grid',
    // we have merged all the lands '1' to their respective islands (disjoint sets).
    // Here, we implemented path compression and union by rank to lower time complexity.

    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int columns = grid[0].length;

        // 'parent' array to record the set representatives for each position.
        // Note that we are hashing the position with 'row' and 'column' into 'landID' "row * column + column".
        int[] parent = new int[rows * columns];

        // The 'rank' array is used as part of the union by rank implementation,
        // with the ranks when merging (union),
        // and the node with higher rank to be the parent of the node with lower rank.
        int[] rank = new int[rows * columns];

        int islands = 0;
        // Set up the disjoint set data structure by referencing all the nodes (positions) to itself.
        // Additionally, count the number of land '1' as the number of 'islands' at the start.
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                // If the position is water, move to the next position.
                if (grid[row][column] == '0') continue;
                // Hash the position as 'landID'.
                int landID = row * columns + column;
                islands++;
                parent[landID] = landID;
            }
        }

        // Creating an array for the directions (up, down, left, right) for simpler execution later.
        int[][] directions = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for (int row = 0; row < rows; row++) {
            for (int column = 0; column < columns; column++) {
                // If the position is water, move to the next position.
                if (grid[row][column] == '0') continue;
                int landID1 = row * columns + column;
                // Check all the positions adjacent for land '1'.
                for (int[] direction : directions) {
                    int x = row + direction[0];
                    int y = column + direction[1];
                    // If the position is out of bound or is water '0', continue to the next position.
                    if (x < 0 || x >= rows || y < 0 || y >= columns || grid[x][y] == '0') continue;
                    // If found a land '1', union the two position and decrease the 'islands' by 1.
                    int landID2 = x * columns + y;
                    if (union(landID1, landID2, parent, rank)) islands--;
                }
            }
        }
        // Once all the land '1' is in their respective disjoint set, we have the number of 'islands'.
        return islands;
    }

    // Method to find the set representative (parent) of the node, with path compression implemented.
    private int find(int landID, int[] parent) {
        // Continue to find the parent until the node references itself,
        // that the self-referencing node is the set representative.
        if (parent[landID] == landID) return landID;
        // Compress that path by referencing all the children node along the path directly to the parent node.
        return parent[landID] = find(parent[landID], parent);
    }

    // Method to merge (union) two nodes, with union by rank implemented.
    private boolean union(int landID1, int landID2, int[] parent, int[] rank) {
        int find1 = find(landID1, parent);
        int find2 = find(landID2, parent);
        // If the two nodes are already in the same disjoint set (island),
        // return false, indicating that the union is not successful.
        if (find1 == find2) return false;

        // If node 2 'find2' has a higher rank, make node 2 'find2' the parent of node 1 'find1'.
        if (rank[find2] > rank[find1]) {
            parent[find1] = find2;
        }
        // If node 1 'find1' has a higher rank, make node 1 'find1' the parent of node 2 'find2'.
        else {
            parent[find2] = find1;
            // If both node has the same rank, increase the rank of the parent (node 1 'find1') by 1.
            if (rank[find1] == rank[find2]) rank[find1]++;
        }
        return true;
    }
}
