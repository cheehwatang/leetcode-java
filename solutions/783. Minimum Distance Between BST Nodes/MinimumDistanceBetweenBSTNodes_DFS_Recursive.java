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
// We traverse the binary tree in-order, comparing each value with the previous value to get the minimum difference.
//
// Space Complexity : O(1),
// as the auxiliary space used for the variables are constant.

public class MinimumDistanceBetweenBSTNodes_DFS_Recursive {

    // Approach:
    // Using recursion to perform in-order traversal, comparing the value of the nodes to the previous node.
    // For in-order traversal, to nodes are visited in the following order:
    // 1. Left node.
    // 2. Root node to get the difference with the previous node.
    // 3. Right node.

    int result = Integer.MAX_VALUE, previous = -1;

    public int minDiffInBST(TreeNode root) {
        // Visit the left node.
        if (root.left != null) minDiffInBST(root.left);

        // Get the value difference of the two nodes, and get the minimum difference.
        if (previous != -1) result = Math.min(result, root.val - previous);
        previous = root.val;

        // Visit the right node.
        if (root.right != null) minDiffInBST(root.right);

        // Return the minimum difference between any two nodes once all the nodes are traversed.
        return result;
    }
}
