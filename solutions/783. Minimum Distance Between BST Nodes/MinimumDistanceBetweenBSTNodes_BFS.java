package com.cheehwatang.leetcode;

import java.util.*;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
// Note: Remember to set up a TreeNode class as the same folder.

// Time Complexity  : O(n logn),
// where 'n' is the number of nodes in the tree.
// We traverse the binary tree using a Queue in breadth-first search, with time complexity of O(n).
// However, we then sort the node values before comparing to find the minimum difference.
// The sorting function in the Collections class has a time complexity of O(n logn).
//
// Space Complexity : O(m),
// where 'm' is the breadth of the binary tree.
// The size of the queue in the breadth-first search has a maximum size equivalent to the breadth of the tree.

public class MinimumDistanceBetweenBSTNodes_BFS {

    // Approach:
    // Traverse the binary tree with breadth-first search, while recording the value of each node in a List.
    // Sort the value of the nodes in the list.
    // Compare each pair of consecutive node values and get the minimum difference between the two nodes.

    public int minDiffInBST(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        // Breadth-first search uses a queue in the node traversal.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Traverse all the nodes until the queue is empty.
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            list.add(current.val);
            // If the current node has left or right child, add to the queue.
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }

        // Sort the list of node values in ascending order.
        Collections.sort(list);
        int result = Integer.MAX_VALUE;
        // Get the difference in each consecutive pair and get the minimum difference.
        for (int i = 1; i < list.size(); i++)
            result = Math.min(result, list.get(i) - list.get(i - 1));

        // Return the minimum difference between any two nodes once all the nodes are traversed.
        return result;
    }
}
