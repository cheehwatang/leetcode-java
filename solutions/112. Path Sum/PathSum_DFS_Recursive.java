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
// In the worst-case, we traverse every node in the binary tree to find a path with path sum equal to the 'targetSum'.
//
// Space Complexity : O(m),
// where 'm' is the depth of the binary tree.
// This is because the maximum number of nodes in the recursive call stack is the depth binary tree.

public class PathSum_DFS_Recursive {

    // Approach:
    // Traverse every root-to-leaf path using depth-first search and
    // return true if found path sum equal to 'targetSum'.
    // As we traverse the binary tree recursively,
    // we subtract the current node's value from the 'targetSum' value
    // and use that as the new 'targetSum' for the child nodes.
    // Here, we implement depth-first search recursively.

    public boolean hasPathSum(TreeNode root, int targetSum) {
        // If there are no nodes in the binary tree, then it is impossible to get any 'targetSum'.
        if (root == null) return false;

        // Update the 'targetSum' value by subtracting with the root's value.
        targetSum -= root.val;

        // If the 'root' is the leaf node, return if the 'targetSum' is zero.
        // If it is zero, then the true will propagate through the call stack, returning true as the final result.
        if (root.left == null && root.right == null)
            return targetSum == 0;

        // Recursive call the left and right child.
        return (hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum));
    }
}
