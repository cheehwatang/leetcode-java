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
// The maximum size of the recursive call stack and the 'path' is the depth of the tree.
// The maximum size of the 'result' is the breadth of the tree.

public class BinaryTreePaths_DFS_Recursive_Backtracking {

    // Approach:
    // Using depth-first search to find every root-to-leaf paths.
    // Here, the depth-first search is implemented recursively, and backtracking approach is used.
    // For backtracking, we first travel from root-to-leaf.
    // Once reached, we record the path, then we backtrack the path by a node, and check the next branch if any.
    // Continue to backtrack and check the next branch, if any, until all the root-to-leaf paths are found.

    // Main method to get all the root-to-leaf paths.
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        // We use 'path' to keep track of the value of the nodes in the path.
        // For backtracking of the path,
        // any data structure that allows LIFO (Last-In First-Out) implementation can be used.
        // We are only removing the latest node value that is added.
        // Here, we use Stack for simplicity.
        Stack<String> path = new Stack<>();
        binaryTreePaths(root, path, result);
        return result;
    }

    // Recursive method to perform depth-first search and backtracking.
    private void binaryTreePaths(TreeNode root, Stack<String> path, List<String> result) {
        // If the 'root' is null, escape the function.
        if (root == null) return;

        // Convert the node value to string and add to the 'path'.
        path.push(String.valueOf(root.val));

        // If we arrive at a leaf node, join the 'path' as string with the "->" as delimited and
        // add the path string to the result.
        if (root.left == null && root.right == null)
            result.add(String.join("->", path));

        // Traverse the left and right child nodes.
        binaryTreePaths(root.left, path, result);
        binaryTreePaths(root.right, path, result);

        // Remember to remove the current node from the 'path' for backtracking.
        path.pop();
    }
}
