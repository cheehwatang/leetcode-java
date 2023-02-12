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
// We traverse the binary tree in-order, comparing each value with the previous value to check if the nodes
// are arranged in-order.
//
// Space Complexity : O(1),
// as the auxiliary space used for the variables are constant.

public class ValidateBinarySearchTree_DFS_Recursive {

    // Approach:
    // Using recursion to perform in-order traversal, comparing the value of the nodes to the previous node.
    // If the current node value is lesser or equal to the previous node value, then it is not a valid
    // binary search tree.
    // For in-order traversal, to nodes are visited in the following order:
    // 1. Left node.
    // 2. Root node to get the difference with the previous node.
    // 3. Right node.

    // For the first node, we need the 'previous' value to be a default false value.
    // As the range of the node values are from Integer.MIN_VALUE to Integer.MAX_VALUE,
    // we use one lower in the long type to indicate default false value.
    long previous = (long) Integer.MIN_VALUE - 1;

    public boolean isValidBST(TreeNode root) {
        // Visit the left node.
        if (root.left != null && !isValidBST(root.left)) return false;

        // Compare the current node value with the previous value.
        // If the current node value is lesser or equal to the previous node value, then it is not a valid
        // binary search tree.
        if (previous != (long) Integer.MIN_VALUE - 1) {
            if (root.val <= previous) return false;
        }
        previous = root.val;

        // Visit the right node.
        if (root.right != null && !isValidBST(root.right)) return false;

        // Return the minimum difference between any two nodes once all the nodes are traversed.
        return true;
    }
}
