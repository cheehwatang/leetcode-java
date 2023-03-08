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
// We traverse every node in the binary tree to get the maximum difference in the nodes values in a path.
//
// Space Complexity : O(m),
// where 'm' is the depth of the tree.
// The maximum size of the recursive stack is the depth of the tree.

public class MaximumDifferenceBetweenNodeAndAncestor_Recursive {

    // Approach:
    // Using depth-first search to traverse every path (from root to leaf) in the binary tree,
    // and find the maximum difference of the nodes values in the paths.
    // Here, the depth-first search is implemented recursively.

    // Main method to set up and call the recursive dfs method.
    public int maxAncestorDiff(TreeNode root) {
        return dfs(root, root.val, root.val);
    }

    // Recursive dfs method to traverse the binary tree, while finding the maximum differences among the nodes in the paths.
    private int dfs(TreeNode root, int min, int max) {
        // Once we reach the end of a path (null node),
        // return the difference between the minimum and maximum node value in the path.
        if (root == null) return max - min;

        // Get the minimum and maximum node value of the path.
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        // For every path, compare and get the maximum difference between the minimum and maximum node value.
        return Math.max(dfs(root.left, min, max), dfs(root.right, min, max));
    }
}
