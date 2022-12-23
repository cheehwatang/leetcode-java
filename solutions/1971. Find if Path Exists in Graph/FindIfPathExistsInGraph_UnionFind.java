package com.cheehwatang.leetcode;

// Time Complexity  : O(m logn),
// where 'm' is the total number of find() and union() functions called, and 'n' is the number of vertices.
// The naive approach of the union-find, with both the find() and union() having the time complexity of O(logn).
// With Union by Rank and Path Compression, the time complexity is amortized to almost linear complexity.
//
// Space Complexity : O(n),
// where 'n' is the number of vertices.
// We used an array to keep track of the set representative (parent) for each vertex.
// As we used Union by Rank, we have an additional array of size 'n'.

public class FindIfPathExistsInGraph_UnionFind {

    // Approach:
    // Using the Disjoint Set Data Structure (Union-Find Data Structure) to
    // connect all the connected vertices into disjoint sets.
    // If the 'source' and 'destination' are in the same disjoint set, then they have a valid path.

    // Main function to check if valid path exist from 'source' to 'destination'.
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // The 'parent' array keeps track of the set representative (parent) of each vertex.
        int[] parent = new int[n];
        // The 'rank' array keeps track of the rank of each vertex, starting at rank 0.
        int[] rank = new int[n];
        // Initialize the parent[], by setting all the set representatives (parents) to itself.
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        // For all the edges, merge (union) the disjoint set of the two connected vertices.
        for (int[] edge : edges) {
            union(edge[0], edge[1], parent, rank);
        }

        // If the 'source' and 'destination' are in the same disjoint set, then they have a valid path.
        return find(source, parent) == find(destination, parent);
    }

    // Function to find the set representative.
    private int find(int vertex, int[] parent) {
        // We have found the set representative when the vertex points back to itself.
        if (parent[vertex] == vertex) return vertex;
        // As part of the Path Compression, we set the vertices along the path to the set representative.
        return parent[vertex] = find(parent[vertex], parent);
    }

    // Function to merge the two disjoint set.
    private void union(int vertex1, int vertex2, int[] parent, int[] rank) {
        // Get the set representative of the two vertices.
        int find1 = find(vertex1, parent);
        int find2 = find(vertex2, parent);

        // If the two vertices is in the same disjoint set, skip.
        if (find1 == find2) return;

        // Here we use Union by Rank.
        // So, join the parent with the lower rank to the one with higher rank.
        if (rank[find1] > rank[find2]) {
            parent[find2] = find1;
        } else {
            parent[find1] = find2;
            // If both are of the same rank, increase the rank of the set representative by 1.
            if (rank[find1] == rank[find2]) rank[find2]++;
        }
    }
}
