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

// Time Complexity  : O(n^2),
// where 'n' is the number of nodes in the tree.
// For each node, we traverse the left and right child and access all of its children
// to get the height of the left and right branch to compare if the height difference is more than 1.
//
// Space Complexity : O(1),
// as the auxiliary space used does not depend on the size of the tree.

public class BalancedBinaryTree {

    // Approach:
    // Traverse the left and right child of each node
    // to compare if the height of the left and right branch is greater than 1.
    // If any of the branch height difference is greater than 1, return false.

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        // If the height difference of the left and right branch is greater than 1, return false.
        if (Math.abs(getHeight(root.left) - getHeight(root.right)) > 1)
            return false;

        // The recursion returns true if the height difference of all the left and right branches is 1 or less.
        return isBalanced(root.left) && isBalanced(root.right);
    }

    // Method to traverse the left and right node to get the height of the node.
    private int getHeight(TreeNode root) {
        // The height starts at 0 with null value, meaning the leaf node has a height of 1.
        if (root == null) return 0;

        // Traverse the left and right branch to get the height.
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);

        // Return the height of the branch.
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
