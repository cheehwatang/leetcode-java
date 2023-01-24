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
// We traverse every node in the binary tree to find all the root-to-leaf paths.
//
// Space Complexity : O(m),
// where 'm' is the depth of the tree.
// The maximum size of the 'stack' is the depth of the tree.

public class SumRootToLeafNumbers_DFS_Iterative {

    // Approach:
    // Using depth-first search to find every root-to-leaf paths.
    // Here, the depth-first search is implemented iteratively, and backtracking approach is used.
    // For backtracking, we first travel from root-to-leaf.
    // Once reached, we sum the path number to the result,
    // then we backtrack the path by a node, and check the next branch if any.
    // Continue to backtrack and check the next branch, if any, until all the root-to-leaf paths are visited
    // and the path numbers are added to the result.

    public int sumNumbers(TreeNode root) {
        // Return 0 if the tree is empty.
        if (root == null) return 0;

        int result = 0;

        // For iterative depth-first search, we use 'stack' for the TreeNodes.
        // We also need to use a 'pathNumber' variable to keep track of the path number.
        // For backtracking of the 'pathNumber', we simply divide the 'pathNumber' by 10.
        int pathNumber = 0;
        Stack<TreeNode> stack = new Stack<>();

        // For iterative backtracking, we need to keep track of the previous node visited,
        // so that we do not get into an infinite loop.
        TreeNode current = root;
        TreeNode previous = null;

        while (current != null || !stack.isEmpty()) {
            // Keep traversing the left node until we reach null, while adding the nodes into the 'stack'.
            // In the process, update the 'pathNumber' accordingly
            // by shifting the 'pathNumber' left by 1 position and add the node value.
            while (current != null) {
                stack.push(current);
                pathNumber = pathNumber * 10 + current.val;
                current = current.left;
            }
            current = stack.peek();

            // If there is right child node and not previously visited,
            // go to the right child node, and continue to traverse down the left nodes until null.
            if (current.right != null && current.right != previous) {
                current = current.right;
                continue;
            }

            // If we arrive at a leaf node, add the 'pathNumber' to the result.
            if (current.left == null && current.right == null)
                result += pathNumber;

            // Backtrack to the previous node (next node in the 'stack')
            // while removing the last digit from the 'pathNumber'.
            pathNumber /= 10;
            stack.pop();

            // Set 'previous' as 'current' so we do not revisit and get into an infinite loop.
            // Remember to set 'current' to null, so we can visit the next node in the 'stack',
            // rather than traversing the left branch again.
            previous = current;
            current = null;
        }
        // Once all the root-to-leaf paths are visited, return the result.
        return result;
    }
}
