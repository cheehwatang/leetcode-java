package com.cheehwatang.leetcode;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
// Space Complexity : O(n),
// where 'n' is the number of nodes in the tree.
// For this approach, we use a List to keep track of the preorder arrangement of the binary tree.
// The list has the size of 'n', with all the nodes in it.

public class FlattenBinaryTreeToLinkedList_Iterative {

    // Approach:
    // Perform the usual preorder traversal, but use a list to keep track of the ordering of nodes.
    // Once we have the preorder arrangements of the nodes,
    // set the left child node to null and right child node to the next node in order.

    public void flatten(TreeNode root) {
        if (root == null) return;

        // Using the iterative implements of the preorder traversal, and use a List to record the preorder arrangement.
        List<TreeNode> preorderList = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();
            // Preorder traversal first visits the node, then the left node, then the right node.
            // Since we are using stack, we push the right node first, then left,
            // as we are visiting the left node before the right node, with stack being FILO (First-In Last-Out).
            preorderList.add(current);
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }

        // Once we have the list of nodes in the preorder arrangement,
        // we traverse the list to set the left child node to null, and the right child node to the next node.
        TreeNode current = root;
        current.left = null;
        for (int i = 1; i < preorderList.size(); i++) {
            current.right = preorderList.get(i);
            current = current.right;
            current.left = null;
        }
        current.right = null;
    }
}
