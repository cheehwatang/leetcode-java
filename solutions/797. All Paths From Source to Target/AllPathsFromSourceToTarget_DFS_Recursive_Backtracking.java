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
// Secondly, the recursive call stack and the 'path' has a maximum space complexity of 'n',
// when each node is connected from node '0' to node 'n - 1'.

public class AllPathsFromSourceToTarget_DFS_Recursive_Backtracking {

    // Approach:
    // Using depth-first search (DFS) to traverse the whole graph, with an additional backtracking implementation,
    // to find all the paths from node '0' and node 'n - 1'.
    // With backtracking, we are only using a single 'path' variable to keep track of the path,
    // rather than creating copies for all the possible paths when performing DFS.

    // Wrapper method to set up and initiate the recursive DFS method.
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        List<List<Integer>> result = new ArrayList<>();
        // As we are adding and removing the top node, we can use stack here for simplification.
        Stack<Integer> path = new Stack<>();
        // Start the DFS method with node '0'.
        dfs(graph, result, path, 0);

        // As the valid paths from node '0' to node 'n - 1' are added into the 'result' in the recursive calls,
        // the 'result' after the dfs() method is updated with all the paths.
        return result;
    }

    // Recursive method for DFS.
    public void dfs(int[][] graph, List<List<Integer>> result, Stack<Integer> path, int currentNode) {
        // Add the 'currentNode' to the 'path'.
        path.push(currentNode);

        // If we found the path to the target node 'n - 1', add the path to the 'result'.
        if (currentNode == graph.length - 1) {
            result.add(new ArrayList<>(path));
        }
        // If not, continue the search with the nodes connected to the 'currentNode'.
        else {
            for (int node : graph[currentNode]) {
                dfs(graph, result, path, node);
            }
        }
        // After searching all the paths leading from the 'currentNode', remove the node from the path,
        // and continue to search the nodes connected to the previous node.
        path.pop();
    }
}
