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
// We traverse every node in the binary tree to find all the paths with path sum equal to the 'targetSum'.
//
// Space Complexity : O(n),
// where 'n' is the number of nodes in the tree.
// The size of the result grows linearly with the number of nodes.

public class PathSumII_DFS_Recursive_Backtracking {

    // Approach:
    // Using depth-first search to check every root-to-leaf paths to see if the path sum is equal to the 'targetSum'.
    // Here, the depth-first search is implemented recursively, and backtracking approach is used.
    // For backtracking, we travel from root-to-leaf and check.
    // Once checked, we backtrack the path by a node, and check the next branch if any.
    // Continue to backtrack and check the next branch, if any, until all the paths are checked.

    // Main method to get the paths that have path sum equal to 'targetSum'.
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        // We use 'path' to keep track of the value of the nodes in the path.
        // For backtracking of the path,
        // any data structure that allows LIFO (Last-In First-Out) implementation can be used.
        // We are only removing the latest node value that is added.
        // Here, we use Stack for simplicity.
        Stack<Integer> path = new Stack<>();
        pathSum(root, targetSum, path, result);
        return result;
    }

    // Recursive method to perform depth-first search and backtracking.
    private void pathSum(TreeNode root, int targetSum, Stack<Integer> path, List<List<Integer>> result) {
        // If the 'root' is null, escape the function.
        if (root == null) return;
        // Rather than using a 'pathSum' variable to keep track,
        // we can simply keep subtracting the node values in the path from 'targetSum'.
        // If the 'targetSum' is zero, then the path sum is equal to 'targetSum'.
        targetSum -= root.val;
        // Add the node value to the 'path'.
        path.push(root.val);

        // If we arrive at a leaf node and the 'pathSum' is equal to the 'targetSum', add the 'path' to the result.
        // Note: Remember to create a new ArrayList for each path added,
        //       rather than adding the variable reference ('path') to result.
        if (root.left == null && root.right == null && targetSum == 0)
            result.add(new ArrayList<>(path));

        // Traverse the left and right child nodes.
        pathSum(root.left, targetSum, path, result);
        pathSum(root.right, targetSum, path, result);

        // Remember to remove the current node from the 'path' for backtracking.
        path.pop();
    }
}
