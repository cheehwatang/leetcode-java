package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Time Complexity  : O(k),
// where 'k' is the total number of edges between the vertices.
// This is because we use depth-first search to traverse every edge until we find 'destination'.
//
// Space Complexity : O(k),
// where 'k' is the total number of edges between the vertices.
// The maximum size of the 'adjacencyList' (and its nested lists) and the 'queue' during depth-first search
// is the number of edges in 'edges'.

public class FindIfPathExistsInGraph_DFS_Iterative {

    // Approach:
    // First map the 'edges' onto an adjacency list, which is the list of every node and its adjacent nodes or vertices.
    // Once done, we can use depth-first search to start searching from the 'source' vertex,
    // and check every connected vertices paths for 'destination'.
    // Here, we use the iterative implementation of the depth-first search.

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

        // Depth-first search from the 'source' until we found 'destination' or when the 'stack' is empty.
        boolean[] visitedVertices = new boolean[n];
        Stack<Integer> stack = new Stack<>();
        // Each time after pushing the vertex to the 'stack', mark the vertex as visited.
        stack.push(source);
        visitedVertices[source] = true;
        while (!stack.isEmpty()) {
            Integer current = stack.pop();
            // If we found the 'destination', a valid path exists and return true.
            if (current == destination) return true;
            // Add the vertices connected to the current vertex, if it is not visited.
            for (Integer node : nodeEdges.get(current)) {
                // Skip to the next vertex if the vertex is already visited.
                if (visitedVertices[node]) continue;
                stack.push(node);
                visitedVertices[node] = true;
            }
        }
        // We searched all vertices from 'source', but 'destination' not found.
        // Thus, not valid path exists between 'source' and 'destination'.
        return false;
    }
}
