package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time Complexity  : O(k),
// where 'k' is the total number of edges between the vertices.
// This is because we use breadth-first search to traverse every edge until we find 'destination'.
//
// Space Complexity : O(k),
// where 'k' is the total number of edges between the vertices.
// The maximum size of the 'adjacencyList' (and its nested lists) and the 'queue' during breadth-first search
// is the number of edges in 'edges'.

public class FindIfPathExistsInGraph_BFS {

    // Approach:
    // First map the 'edges' onto an adjacency list, which is the list of every node and its adjacent nodes or vertices.
    // Once done, we can use breadth-first search to start searching from the 'source' vertex,
    // and check every adjacent vertex at every level until we found the 'destination' vertex or visited every vertex.
    // As this is an undirected graph, we need an additional boolean table to keep track of the visited nodes,
    // to prevent infinite loops.

    public boolean validPath(int n, int[][] edges, int source, int destination) {

        // Using the 'edges' to build an adjacency list of all vertices.
        // As the vertex numbers are from 0 to 'n', we use an ArrayList here.
        // However, if we are not certain of the vertices, we use HashMap with the vertex as key,
        // and ArrayList or HashSet as value.
        List<List<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            // Note to create new instances of ArrayList for each vertex.
            // Using Arrays.fill() result in all vertices pointing to the same ArrayList.
            adjacencyList.add(new ArrayList<>());
        }
        // Build the adjacency list. Take note to add both directions, as it is an undirected graph.
        for (int[] edge : edges) {
            adjacencyList.get(edge[0]).add(edge[1]);
            adjacencyList.get(edge[1]).add(edge[0]);
        }

        // Breadth-first search from the 'source' until we found 'destination' or when the 'queue' is empty.
        boolean[] visitedVertices = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        // Each time after adding the vertex to the 'queue', mark the vertex as visited.
        queue.offer(source);
        visitedVertices[source] = true;
        while (!queue.isEmpty()) {
            // Remember to set the queue.size as a variable,
            // as the 'queue' is constantly changing during the push and pop,
            // which may lead to early termination or infinite loops.
            for (int i = 0, size = queue.size(); i < size; i++) {
                Integer current = queue.poll();
                // If we found the 'destination', a valid path exists and return true.
                if (current == destination) return true;
                // Add the vertices connected to the current vertex to check at the next level.
                for (Integer node : adjacencyList.get(current)) {
                    // Skip to the next vertex if the vertex is already visited.
                    if (visitedVertices[node]) continue;
                    queue.offer(node);
                    visitedVertices[node] = true;
                }
            }
        }
        // We searched all vertices from 'source', but 'destination' not found.
        // Thus, not valid path exists between 'source' and 'destination'.
        return false;
    }
}
