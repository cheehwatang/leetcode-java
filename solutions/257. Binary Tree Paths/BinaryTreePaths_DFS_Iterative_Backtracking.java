package com.cheehwatang.leetcode;

import java.util.ArrayList;
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
// We traverse every node in the binary tree to find all the root-to-leaf paths.
//
// Space Complexity : O(m + k),
// where 'm' is the breadth of the tree, and 'k' is the depth of the tree.
// The maximum size of the 'stack' and the 'path' is the depth of the tree.
// The maximum size of the 'result' is the breadth of the tree.

public class BinaryTreePaths_DFS_Iterative_Backtracking {

    // Approach:
    // Using depth-first search to find every root-to-leaf paths.
    // Here, the depth-first search is implemented iteratively, and backtracking approach is used.
    // For backtracking, we first travel from root-to-leaf.
    // Once reached, we record the path, then we backtrack the path by a node, and check the next branch if any.
    // Continue to backtrack and check the next branch, if any, until all the root-to-leaf paths are found.

    public List<String> binaryTreePaths(TreeNode root) {
        // If the tree is empty, return an empty result.
        if (root == null) return new ArrayList<>();

        List<String> result = new ArrayList<>();

        // For iterative depth-first search, we use 'stack' for the TreeNodes.
        // As we also need to keep track of the path that we are on,
        // we use another stack to keep track of the value of the nodes in the 'path'.
        // For backtracking of the path,
        // any data structure that allows LIFO (Last-In First-Out) implementation can be used.
        // We are only removing the latest node value that is added.
        Stack<String> path = new Stack<>();
        Stack<TreeNode> stack = new Stack<>();

        // For iterative backtracking, we need to keep track of the previous node visited,
        // so that we do not get into an infinite loop.
        TreeNode current = root;
        TreeNode previous = null;

        while (current != null || !stack.isEmpty()) {
            // Keep traversing the left node until we reach null, while adding the nodes into the 'stack'.
            // In the process, keep track of the 'path'.
            while (current != null) {
                stack.push(current);
                path.push(String.valueOf(current.val));
                current = current.left;
            }
            current = stack.peek();
            // If there is right child node and not previously visited,
            // go to the right child node, and continue to traverse down the left nodes until null.
            if (current.right != null && current.right != previous) {
                current = current.right;
                continue;
            }

            // If we arrive at a leaf node, join the 'path' as string with the "->" as delimited and
            // add the path string to the result.
            if (current.left == null && current.right == null)
                result.add(String.join("->", path));

            // Backtrack to the previous node (next node in the 'stack') while removing it from the 'path'.
            path.pop();
            stack.pop();

            // Set 'previous' as 'current' so we do not revisit and get into an infinite loop.
            // Remember to set 'current' to null, so we can visit the next node in the 'stack',
            // rather than traversing the left branch again.
            previous = current;
            current = null;
        }
        // Once all the root-to-leaf paths are found, return the result.
        return result;
    }
}
