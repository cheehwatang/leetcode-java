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
// We traverse the nodes from right to left to flatten the tree to a linked list.
//
// Space Complexity : O(1),
// as we are only changing the left and right pointers in each node to flatten the tree.

public class FlattenBinaryTreeToLinkedList_Recursive {

    // As we are using flatten() as recursive method, we need to store the 'previous' node outside of the method.
    TreeNode previous = null;

    public void flatten(TreeNode root) {
        if (root == null) return;

        // As we are flattening the binary tree in the preorder arrangement, we flatten the right child node first.
        flatten(root.right);
        flatten(root.left);
        // As we flatten, we set the left child node to null and the right to the previous node checked.
        // This ensures we flatten from the rightmost leaf node to the leftmost leaf node.
        root.left = null;
        root.right = previous;
        previous = root;
    }
}
