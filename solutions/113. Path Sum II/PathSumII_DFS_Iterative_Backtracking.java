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

public class PathSumII_DFS_Iterative_Backtracking {

    // Approach:
    // Using depth-first search to check every root-to-leaf paths to see if the path sum is equal to the 'targetSum'.
    // Here, the depth-first search is implemented iteratively, and backtracking approach is used.
    // For backtracking, we travel from root-to-leaf and check.
    // Once checked, we backtrack the path by a node, and check the next branch if any.
    // Continue to backtrack and check the next branch, if any, until all the paths are checked.

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // If the tree is empty, return an empty result.
        if (root == null) return new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        // For iterative depth-first search, we use 'stack' for the TreeNodes.
        // As we also need to keep track of the path that we are on,
        // we use another stack to keep track of the value of the nodes in the 'path'.
        // Additionally, we also use a variable to keep track of the 'pathSum'.
        // For backtracking of the path,
        // any data structure that allows LIFO (Last-In First-Out) implementation can be used.
        // We are only removing the latest node value that is added.
        // Here, we use Stack for simplicity.
        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> path = new Stack<>();
        int pathSum = 0;

        // For iterative backtracking, we need to keep track of the previous node visited,
        // so that we do not get into an infinite loop.
        TreeNode current = root;
        TreeNode previous = null;

        while (current != null || !stack.isEmpty()) {
            // Keep traversing the left node until we reach null, while adding the nodes into the 'stack'.
            // In the process, keep track of the 'path' and the 'pathSum'.
            while (current != null) {
                stack.push(current);
                path.push(current.val);
                pathSum += current.val;
                current = current.left;
            }
            current = stack.peek();
            // If there is right child node and not previously visited,
            // go to the right child node, and continue to traverse down the left nodes until null.
            if (current.right != null && current.right != previous) {
                current = current.right;
                continue;
            }
            // If we arrive at a leaf node and the 'pathSum' is equal to the 'targetSum', add the 'path' to the result.
            // Note: Remember to create a new ArrayList for each path added,
            //       rather than adding the variable reference ('path') to result.
            if (current.left == null && current.right == null && pathSum == targetSum)
                result.add(new ArrayList<>(path));

            // Once the root-to-leaf path is checked, backtrack to the previous node (next node in the 'stack'),
            // while removing it from the 'path', and subtracting from the 'pathSum'.
            stack.pop();
            path.pop();
            pathSum -= current.val;

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
