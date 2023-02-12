package com.cheehwatang.leetcode;

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
// We traverse the binary tree in-order, comparing each value with the previous value to check if the nodes
// are arranged in-order.
//
// Space Complexity : O(m),
// where 'm' is the depth of the binary tree.
// The size of the stack used in the in-order traversal has a maximum size equivalent to the depth of the tree.

public class ValidateBinarySearchTree_DFS_Iterative {

    // Approach:
    // Perform in-order traversal, comparing the value of the nodes to the previous node.
    // If the current node value is lesser or equal to the previous node value, then it is not a valid
    // binary search tree.
    // For in-order traversal, we use stack to record the nodes to be visited, visiting the nodes in the order of:
    // 1. Left node (until we hit null, while storing the nodes in the stack).
    // 2. Visit the root node, and get the difference with the previous node.
    // 3. Right node (if any, then restart step 1 and step 2).

    public boolean isValidBST(TreeNode root) {
        // For the first node, we need the 'previous' value to be a default false value.
        // As the range of the node values are from Integer.MIN_VALUE to Integer.MAX_VALUE,
        // we use one lower in the long type to indicate default false value.
        long previous = (long) Integer.MIN_VALUE - 1;

        // Iterative depth-first search is performed using a stack to store the nodes.
        Stack<TreeNode> stack = new Stack<>();

        // We use a pointer to keep track of the current node.
        TreeNode current = root;

        // At any point, if the pointer is null and the stack is empty, we have fully traversed the tree.
        while (current != null || !stack.isEmpty()) {
            // For any node, completely traverse the left branch.
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // Get the top node in the stack.
            current = stack.pop();

            // Compare the current node value with the previous value.
            // If the current node value is lesser or equal to the previous node value, then it is not a valid
            // binary search tree.
            if (previous != (long) Integer.MIN_VALUE - 1 && current.val <= previous) return false;
            previous = current.val;

            // Visit the right node (if any).
            // Note that if the right node is null, the pointer is null, which will continue to pop the stack.
            // If ever the right node is not null, then we fully traverse its left branch.
            current = current.right;
        }
        // Return the minimum difference between any two nodes once all the nodes are traversed.
        return true;
    }
}
