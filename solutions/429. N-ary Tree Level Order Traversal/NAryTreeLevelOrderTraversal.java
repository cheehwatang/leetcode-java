package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 // Definition for a Node.
 class Node {
 public int val;
 public List<Node> children;

 public Node() {}

 public Node(int _val) {
 val = _val;
 }

 public Node(int _val, List<Node> _children) {
 val = _val;
 children = _children;
 }
 };
 */
// Note: Remember to set up a Node class as the same folder.

// Time Complexity  : O(n),
// where 'n' is the number of nodes in the tree.
// We traverse every node in the tree and record in the list.
//
// Space Complexity : O(m),
// where 'm' is the maximum breadth of the tree.
// The maximum size of the queue is the maximum breadth of the tree.

public class NAryTreeLevelOrderTraversal {

    // Approach:
    // Using breadth-first search to visit every node in the tree.
    // Traverse the tree level by level, each time record the nodes of the level in a list.
    // Each level, store the list of nodes in the level in the final result list.

    public List<List<Integer>> levelOrder(Node root) {
        // As we are to return List<List<Integer>>, we can use either ArrayList or LinkedList.
        // Here, we used ArrayList.
        List<List<Integer>> result = new ArrayList<>();

        // Check if the there are any nodes in the tree.
        if (root == null) return result;

        // Breadth-first search is implemented using 'queue'.
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        // If there are nodes in the 'queue', continue to traverse the tree level by level until all nodes are visited.
        while (!queue.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();

            // Remember to use a variable 'size' to keep track of the size of the queue,
            // as we want to traverse the tree one level at a time.
            for (int i = 0, size = queue.size(); i < size; i++) {
                Node current = queue.poll();
                currentLevel.add(current.val);

                // If there are child nodes, add them to the 'queue' for the next level.
                for (Node childNode : current.children)
                    queue.offer(childNode);
            }
            // Add the list of nodes to the result for each level visited.
            result.add(currentLevel);
        }
        // Return the result once all the nodes are visited.
        return result;
    }
}
