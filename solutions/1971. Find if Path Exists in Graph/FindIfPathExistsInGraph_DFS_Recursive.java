package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;

// Time Complexity  : O(k),
// where 'k' is the total number of edges between the vertices.
// This is because we use depth-first search to traverse every edge until we find 'destination'.
//
// Space Complexity : O(k),
// where 'k' is the total number of edges between the vertices.
// The maximum size of the 'adjacencyList' (and its nested lists) and the 'queue' during depth-first search
// is the number of edges in 'edges'.

public class FindIfPathExistsInGraph_DFS_Recursive {

    // Approach:
    // First map the 'edges' onto an adjacency list, which is the list of every node and its adjacent nodes or vertices.
    // Once done, we can use depth-first search to start searching from the 'source' vertex,
    // and check every connected vertices paths for 'destination'.
    // Here, we use the recursive implementation of the depth-first search.

    // Wrapper method to set up and initialize the recursive method.
    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // Using the 'edges' to build an adjacency list of all vertices.
        // As the vertex numbers are from 0 to 'n', we use an ArrayList here.
        // However, if we are not certain of the vertices, we use HashMap with the vertex as key,
        // and ArrayList or HashSet as value.
        List<List<Integer>> nodeEdges = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // Note to create new instances of ArrayList for each vertex.
            // Using Arrays.fill() result in all vertices pointing to the same ArrayList.
            nodeEdges.add(new ArrayList<>());
        }
        // Build the adjacency list. Take note to add both directions, as it is an undirected graph.
        for (int[] edge : edges) {
            nodeEdges.get(edge[0]).add(edge[1]);
            nodeEdges.get(edge[1]).add(edge[0]);
        }

        // Call the depth-first search recursive method, with the 'source', 'destination', the adjacency list,
        // and the 'visitedVertices' table.
        return dfs(source, destination, nodeEdges, new boolean[n]);
    }

    // Recursive method for the depth-first search.
    private boolean dfs(int source, int destination, List<List<Integer>> nodeEdges, boolean[] visitedVertices) {
        // If we have found the 'destination', return true.
        if (source == destination) return true;
        // Skip to the next vertex (if any), if this vertex is visited.
        if (visitedVertices[source]) return false;
        visitedVertices[source] = true;
        for (Integer node : nodeEdges.get(source)) {
            // If we have found the 'destination', return true.
            if (dfs(node, destination, nodeEdges, visitedVertices)) return true;
        }
        // If all the connected vertices are checked but path not found to 'destination', return false.
        return false;
    }
}
