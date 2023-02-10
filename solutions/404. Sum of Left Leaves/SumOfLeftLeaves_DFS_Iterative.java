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
// We traverse every node in the binary tree to find the all the left leaf nodes.
//
// Space Complexity : O(m),
// where 'm' is the depth of the tree.
// The maximum size of the 'stack' is the depth of the tree.

public class SumOfLeftLeaves_DFS_Iterative {

    // Approach:
    // Using depth-first search to traverse and visit every node in the binary tree.
    // When we found a left child node that is a leaf node, add to the sum.
    // Return the sum once we have fully traversed the tree.
    // Here, the depth-first search is implemented iteratively.

    public int sumOfLeftLeaves(TreeNode root) {
        // If the tree is empty, there is no left leaf nodes to add to the sum.
        // This check here is important to prevent any NullPointerException.
        if (root == null) return 0;

        int sum = 0;

        // Iterative depth-first search is implemented using 'stack'.
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        // If there are nodes in the 'stack', continue to traverse the tree until all nodes are visited.
        while (!stack.isEmpty()) {
            TreeNode current = stack.pop();

            // If there is left child node,
            if (current.left != null) {
                // add the left child node value to the sum if it is a leaf node,
                if (current.left.left == null && current.left.right == null)
                    sum += current.left.val;
                // or add to the 'queue' if it is not a leaf node.
                else
                    stack.push(current.left);
            }
            // If there is right child node, add to the 'queue' for the next level.
            if (current.right != null)
                stack.push(current.right);
        }
        // Return the sum once all the nodes are visited.
        return sum;
    }
}
