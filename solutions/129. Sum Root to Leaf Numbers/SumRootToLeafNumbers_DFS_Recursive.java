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
// We traverse every node in the binary tree to find all the root-to-leaf paths.
//
// Space Complexity : O(m),
// where 'm' is the depth of the tree.
// The maximum size of the recursive call stack is the depth of the tree.

public class SumRootToLeafNumbers_DFS_Recursive {

    // Approach:
    // Using depth-first search to find every root-to-leaf paths.
    // Here, the depth-first search is implemented recursively.

    // Main method to get all the root-to-leaf paths.
    public int sumNumbers(TreeNode root) {
        return sumNumbers(root, 0);
    }

    // Recursive method to perform depth-first search and sum all the path numbers.
    private int sumNumbers(TreeNode root, int pathNumber) {
        // Return 0 if the root is null.
        if (root == null) return 0;

        // Shift the 'pathNumber' left by 1 position and add the node value.
        pathNumber = pathNumber * 10 + root.val;

        // If we arrive at a leaf node, return the 'pathNumber'.
        if (root.left == null && root.right == null)
            return pathNumber;

        // Get the sum of the 'pathNumber' of the left and the right branch.
        // Any leaf node found will return the 'pathNumber' up the recursive call stack and sum together.
        return sumNumbers(root.left, pathNumber) + sumNumbers(root.right, pathNumber);
    }
}
