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

// Time Complexity  : O(n^2),
// where 'n' is the number of nodes in the tree.
// We traverse every node in the binary tree to find all the paths with path sum equal to the 'targetSum',
// and treating every node in the tree as the root for the subtree.
//
// Space Complexity : O(m),
// where 'm' is the depth of the binary tree.
// The maximum size of the recursive call stack is the depth of the binary tree,
// as we only check one path at a time.

public class PathSumIII_DFS_Recursive {

    // Approach:
    // Perform recursive depth-first search for every node
    // to check if any path sums along the path is equal to 'targetSum'.

    // Main method that is recursively called to check every subtree.
    public int pathSum(TreeNode root, int targetSum) {
        // If the tree is empty, no path is available to get 'targetSum'.
        if (root == null) return 0;
        return pathSum(root, targetSum, 0L) + pathSum(root.left, targetSum) + pathSum(root.right, targetSum);
    }

    // Recursive method to traverse the subtree and check if any path sum is equal to the 'targetSum'.
    private int pathSum(TreeNode root, int targetSum, long pathSum) {
        if (root == null) return 0;
        pathSum += root.val;
        // If the 'pathSum' is equal to the 'targetSum', start the count at 1.
        int count = pathSum == targetSum ? 1 : 0;
        // Rather than checking if the left or the right child node is null,
        // we pass it to the next recursive call to check.
        // Get the count of the left and right branch and return the count total.
        return count + pathSum(root.left, targetSum, pathSum) + pathSum(root.right, targetSum, pathSum);
    }
}
