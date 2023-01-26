package com.cheehwatang.leetcode;

import java.util.LinkedList;
import java.util.Queue;

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

// Time Complexity  : O(n),
// where 'n' is the number of nodes in the tree.
// The number of nodes to visit to find the minimum depth grows linearly with the number of nodes in the tree.
//
// Space Complexity : O(m),
// where 'm' is the breadth of the tree.
// The maximum size of the 'queue' is the breadth of the tree.

public class MinimumDepthOfBinaryTree_BFS {

    // Approach:
    // Using breadth-first search to find the minimum depth of the tree.
    // Traverse the tree level by level, while keeping track of the level.
    // When we found the first leaf node, the level of the node is the minimum depth of the tree.

    public int minDepth(TreeNode root) {
        // If the tree is empty, there is zero depth.
        if (root == null) return 0;

        // Start the 'level' at 0, as we have yet to traverse the first level.
        int level = 0;

        // Breadth-first search is implemented using 'queue'.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // If there are nodes in the 'queue' and no leaf node is found yet,
        // continue to traverse the tree level by level until the leaf node is found.
        while (!queue.isEmpty()) {
            // Each new level, we increase 'level' by 1.
            level++;

            // Remember to use a variable 'size' to keep track of the size of the queue,
            // as we want to traverse the tree one level at a time.
            for (int i = 0, size = queue.size(); i < size; i++) {
                TreeNode current = queue.poll();

                // When we reach the first leaf node, return the level.
                if (current.left == null && current.right == null)
                    return level;

                // If there are left or right child nodes, add them to the 'queue' for the next level.
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
        }
        // This return statement is to prevent compile-time error.
        // It is guaranteed to find the first leaf node before all the nodes are visited.
        return level;
    }
}
