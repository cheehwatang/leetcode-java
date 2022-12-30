package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time Complexity  : O(m),
// where 'm' is the number of edges in the graph.
// We use breadth-first search (BFS) to traverse all the edges to find the path from node '0' to node 'n - 1'.
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
// Secondly, the maximum size of the 'queue' in the BFS is size 'n',
// and each path in the 'queue' has a maximum size of 'n', resulted in space complexity of O(n^2).
// This resulted in the space complexity of O(m * n).

public class AllPathsFromSourceToTarget_BFS {

    // Approach:
    // Using breadth-first search (BFS) to traverse the whole graph,
    // to find all the paths from node '0' and node 'n - 1'.
    // Since all the edges connect to node '0' are searched, the difference with depth-first search (DFS) is mainly
    // the traversal method and implementation. The performance is similar.

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        int n = graph.length;
        List<List<Integer>> result = new ArrayList<>();

        // For BFS, we are using a 'queue' for the level-order traversal.
        // As we are keeping track of the paths from node '0' to node 'n - 1',
        // we store the path in the 'queue'.
        Queue<List<Integer>> queue = new LinkedList<>();
        // For the first node, create a new list, add the node '0' and put into the 'queue'.
        List<Integer> start = new ArrayList<>();
        start.add(0);
        queue.offer(start);

        while (!queue.isEmpty()) {
            // For the paths currently in the 'queue',
            for (int i = 0, size = queue.size(); i < size; i++) {
                List<Integer> currentPath = queue.poll();
                // The last node in the path is the current node.
                int currentNode = currentPath.get(currentPath.size() - 1);

                // If the current node is the target node 'n - 1', add the path to the result.
                if (currentNode == n - 1) {
                    result.add(currentPath);
                    continue;
                }

                // For the nodes connected to the current node, add the next node to the path and put into the 'queue'.
                for (int node : graph[currentNode]) {
                    // Remember to create new copy of the path before adding to the 'queue'.
                    List<Integer> nextPath = new ArrayList<>(currentPath);
                    nextPath.add(node);
                    queue.offer(nextPath);
                }
            }
        }
        // Once all the nodes searched, return the 'result'.
        // Note that if no path exists, the 'result' remains empty.
        return result;
    }
}
