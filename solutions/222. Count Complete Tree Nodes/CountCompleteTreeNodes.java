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

// Time Complexity  : O(logn * logn),
// where 'n' is the number of nodes in the tree.
// For both left and right child nodes, we traverse the left and the right branch to check if it is a full tree.
// The worst-case is when we need to fully traverse the depth of the left and right branch
// for each node in the left and right branch.
// A full traversal of the depth has a time complexity of O(logn), resulting in time complexity of O(logn * logn).
//
// Space Complexity : O(logn),
// where 'n' is the number of nodes in the tree, and 'logn' is the depth of the tree in a balanced tree.
// A complete tree is also a balanced tree.
// The maximum size of the recursive stack is the depth of the tree.

public class CountCompleteTreeNodes {

    // Approach:
    // The main property of a complete tree is that the child nodes of each subtree are also a complete tree.
    // For a full tree, the left and right branches have the same depth.
    // The number of nodes in a full tree is (2 ^ depth) - 1.
    // As such, we traverse the left and right branch to find the full trees and
    // sum the number of nodes of the full tree found.

    public int countNodes(TreeNode root) {
        // If the root is empty, there is zero node.
        if (root == null) return 0;

        // Find the height of the left branch.
        TreeNode leftNode = root.left;
        int leftHeight = 1;
        while (leftNode != null) {
            leftHeight++;
            leftNode = leftNode.left;
        }

        // Find the height of the right branch.
        TreeNode rightNode = root.right;
        int rightHeight = 1;
        while (rightNode != null) {
            rightHeight++;
            rightNode = rightNode.right;
        }

        // Once we found a full tree, return the number of nodes in the full tree.
        // There is no need to further traverse the left and right branches, since we already know the number of nodes.
        if (leftHeight == rightHeight)
            return (int) Math.pow(2, leftHeight) - 1;

        // If it is not a full tree, traverse the left and right branches and sum the number of nodes.
        // Note on the + 1, as we need to add the number of nodes in the left and right branch,
        // as well as the current node.
        return countNodes(root.left) + countNodes(root.right) + 1;
    }
}
