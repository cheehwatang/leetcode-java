package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;

// Time Complexity  : O(m),
// where 'm' is the number of edges in the graph.
// We use depth-first search (DFS) to traverse all the edges to find the path from node '0' to node 'n - 1'.
// Alternatively, we could represent the time complexity as O(n^2), where 'n' is the number of nodes in the graph.
// As this graph is a directed acyclic graph (DAG),
// the worst-case is when each node, 'i', is connected to nodes from node 'i + 1' to 'n - 1',
// resulted in the number of edges simplify to 'n^2'.
//
// Space Complexity : O(m * n),
// where 'm' is the number of edges in the graph, and 'n' is the number of nodes in the graph.
// Firstly, the 'result' list, contributing space complexity of O(m * n) in the worst-case,
// when each node, 'i', is connected to nodes from node 'i + 1' to 'n - 1',
// making the number of paths from node '0' to node 'n - 1' is 'm', and each path has a maximum of 'n' nodes.
// Secondly, the recursive call stack has a maximum space complexity of 'n',
// when each node is connected from node '0' to node 'n - 1'.

public class AllPathsFromSourceToTarget_DFS_Recursive {

    // Approach:
    // Using depth-first search (DFS) to traverse the whole graph,
    // to find all the paths from node '0' and node 'n - 1'.
    // Here, the recursive implementation of DFS is used.

    // Wrapper method to set up and initiate the recursive DFS method.
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();

        // For the first node, create a new list, add the node '0'.
        List<Integer> start = new ArrayList<>();
        start.add(0);

        // Start the recursive DFS with the 'start' path.
        dfs(graph, result, start);

        // As the valid paths from node '0' to node 'n - 1' are added into the 'result' in the recursive calls,
        // the 'result' after the dfs() method is updated with all the paths.
        return result;
    }

    // Recursive method for DFS.
    public void dfs(int[][] graph, List<List<Integer>> result, List<Integer> path) {

        // Get the current node from the path.
        int currentNode = path.get(path.size() - 1);

        // If the current node is the target node 'n - 1', add the 'path' to the 'result'.
        if (currentNode == graph.length - 1) {
            result.add(path);
            return;
        }

        // If not, then continue search the nodes connected to the current node.
        for (int node : graph[currentNode]) {

            // Remember to create new copy of the path before calling the recursive method.
            List<Integer> nextPath = new ArrayList<>(path);
            nextPath.add(node);
            dfs(graph, result, nextPath);
        }
    }
}
