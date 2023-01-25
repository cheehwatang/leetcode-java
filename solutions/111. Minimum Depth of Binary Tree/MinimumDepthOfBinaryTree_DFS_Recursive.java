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
// We traverse every node in the binary tree to find the minimum depth of the tree.
//
// Space Complexity : O(m),
// where 'm' is the depth of the tree.
// The maximum size of the 'nodeStack' and 'levelStack' is the depth of the tree.

public class MinimumDepthOfBinaryTree_DFS_Recursive {

    // Approach:
    // Using depth-first search to find the depth of every node.
    // Then, compare and find the minimum depth.
    // Here, the depth-first search is implemented recursively.

    // Main method to check for empty tree and to initialize the recursive method.
    public int minDepth(TreeNode root) {
        // If the tree is empty, there is zero depth.
        if (root == null) return 0;

        // Call the recursive method to perform depth-first search of the tree, with the level of the root is 1.
        return minDepth(root, 1);
    }

    // Recursive method to traverse the tree to find the minimum depth of the tree.
    private int minDepth(TreeNode root, int level) {
        // When we reach a leaf node, return the level of the leaf node.
        if (root.left == null && root.right == null) return level;

        // Traverse the left and right branch to find the minimum depth of each branch.
        // If either branch is null, use Integer.MAX_VALUE, as we will use Math.min() to find the minimum depth.
        int leftMinLevel = root.left == null ? Integer.MAX_VALUE : minDepth(root.left, level + 1);
        int rightMinLevel = root.right == null ? Integer.MAX_VALUE : minDepth(root.right, level + 1);

        // Return the minimum depth of the two branches.
        return Math.min(leftMinLevel, rightMinLevel);
    }
}
