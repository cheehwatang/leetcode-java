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
// We traverse every node in the binary tree to invert each branch.
//
// Space Complexity : O(m),
// where 'm' is the depth of the tree.
// The maximum size of the recursive stack is the depth of the tree.

public class InvertBinaryTree_DFS_Recursive {

    // Approach:
    // Using depth-first search to traverse and visit every node in the binary tree.
    // For each node, we invert the two branches by swapping the left and right child node.
    // Here, the depth-first search is implemented recursively.

    public TreeNode invertTree(TreeNode root) {
        // Continue to the next node if the current node is null.
        if (root == null) return null;

        // Swap the left and right child node using a temporary variable.
        TreeNode leftChild = invertTree(root.left);
        root.left = invertTree(root.right);
        root.right = leftChild;

        // Return the current node once the child is swapped.
        return root;
    }
}
