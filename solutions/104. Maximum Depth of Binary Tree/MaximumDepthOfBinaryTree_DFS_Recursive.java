package com.cheehwatang.leetcode;

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
// We traverse every node in the binary tree to find the maximum depth of the tree.
//
// Space Complexity : O(m),
// where 'm' is the depth of the tree.
// The maximum size of the recursive call stack is the depth of the tree.

public class MaximumDepthOfBinaryTree_DFS_Recursive {

    // Approach:
    // Using depth-first search to find the depth of every node.
    // Then, compare and find the maximum depth.
    // Here, the depth-first search is implemented recursively.

    public int maxDepth(TreeNode root) {
        // If the tree is empty, there is zero depth.
        if (root == null) return 0;

        // Traverse the left and right nodes.
        // The level of the 'root' is one level greater than the level of the left or the right node,
        // whichever is greater.
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }
}
