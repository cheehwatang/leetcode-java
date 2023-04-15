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
// We traverse every node in the binary tree to invert each branch.
//
// Space Complexity : O(m),
// where 'm' is the depth of the tree.
// The maximum size of the 'stack' is the depth of the tree.

public class InvertBinaryTree_DFS_Iterative {

    // Approach:
    // Using depth-first search to traverse and visit every node in the binary tree.
    // For each node, we invert the two branches by swapping the left and right child node.
    // Here, the depth-first search is implemented iteratively.

    public TreeNode invertTree(TreeNode root) {
        // If the binary tree is empty, return null.
        // This check is required as it is possible to have an empty binary tree,
        // and null value would result in error.
        if (root == null) return null;

        // Iterative depth-first search is implemented using 'stack'.
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        // If there are nodes in the 'stack', continue to traverse the tree until all nodes are visited.
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            // Swap the left and right child node using a temporary variable.
            TreeNode leftChild = current.left;
            current.left = current.right;
            current.right = leftChild;

            // Once the left and right branch is swapped,
            // add the left and right child node to the stack if it is not null.
            if (current.right != null) stack.push(current.right);
            if (current.left != null) stack.push(current.left);
        }
        // Return the root once all the nodes are visited.
        return root;
    }
}
