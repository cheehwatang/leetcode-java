package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
// Secondly, the 'stack' used in the DFS resulted in O(m * n),
// due to the maximum size of the 'stack' as the number of edges in the graph,
// when all possible paths are added into the 'stack'.
// For each path in the stack, the maximum size is 'n'.
// This resulted in the space complexity of O(m * n).

public class AllPathsFromSourceToTarget_DFS_Iterative {

    // Approach:
    // Using depth-first search (DFS) to traverse the whole graph,
    // to find all the paths from node '0' and node 'n - 1'.
    // Here, the iterative implementation of DFS is used.
    // Since all the edges connect to node '0' are searched, the difference with breadth-first search (BFS) is mainly
    // the traversal method and implementation. The performance is similar.

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        int n = graph.length;
        List<List<Integer>> result = new ArrayList<>();

        // For iterative DFS, we are using a 'stack' for the traversal.
        // As we are keeping track of the paths from node '0' to node 'n - 1',
        // we store the path in the 'stack'.
        Stack<List<Integer>> stack = new Stack<>();
        // For the first node, create a new list, add the node '0' and put into the 'stack'.
        List<Integer> start = new ArrayList<>();
        start.add(0);
        stack.push(start);

        while (!stack.isEmpty()) {
            List<Integer> currentPath = stack.pop();
            // The last node in the path is the current node.
            int currentNode = currentPath.get(currentPath.size() - 1);

            // If the current node is the target node 'n - 1', add the path to the result.
            if (currentNode == n - 1) {
                result.add(currentPath);
                continue;
            }

            // For the nodes connected to the current node, add the next node to the path and put into the 'stack'.
            for (int node : graph[currentNode]) {
                // Remember to create new copy of the path before adding to the 'stack'.
                List<Integer> nextPath = new ArrayList<>(currentPath);
                nextPath.add(node);
                stack.push(nextPath);
            }
        }

        // Once all the nodes searched, return the 'result'.
        // Note that if no path exists, the 'result' remains empty.
        return result;
    }
}
