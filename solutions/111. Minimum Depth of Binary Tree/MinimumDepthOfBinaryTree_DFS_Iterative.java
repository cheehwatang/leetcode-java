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
// We traverse every node in the binary tree to find the minimum depth of the tree.
//
// Space Complexity : O(m),
// where 'm' is the depth of the tree.
// The maximum size of the 'nodeStack' and 'levelStack' is the depth of the tree.

public class MinimumDepthOfBinaryTree_DFS_Iterative {

    // Approach:
    // Using depth-first search to find and determine the depth of every root-to-leaf paths.
    // Then, compare and find the minimum depth whenever we arrived at a leaf node.
    // Here, the depth-first search is implemented iteratively.

    public int minDepth(TreeNode root) {
        // If the tree is empty, there is zero depth.
        if (root == null) return 0;

        // Both the depth and level of a tree describe the same thing.
        // Here, we use 'minLevel' as a variable name to make it differ from the 'minDepth()' method.
        int minLevel = Integer.MAX_VALUE;

        // For iterative depth-first search,
        // we use 'nodeStack' for the nodes and 'levelStack' to for the level of the node.
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> levelStack = new Stack<>();

        // Each time pushing a node into the 'nodeStack', push the level of the node to the 'levelStack'.
        nodeStack.push(root);
        levelStack.push(1);

        while (!nodeStack.isEmpty()) {
            // Get the current node and level of the node.
            TreeNode currentNode = nodeStack.pop();
            int currentLevel = levelStack.pop();

            // Once we reach a leaf node, compare and update the 'maxLevel'.
            if (currentNode.left == null && currentNode.right == null) {
                minLevel = Math.min(minLevel, currentLevel);
                continue;
            }

            // If there are left or right child nodes,
            // add them to the 'nodeStack' as well as their level ('currentLevel' + 1) to 'levelStack'.
            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
                levelStack.push(currentLevel + 1);
            }
            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
                levelStack.push(currentLevel + 1);
            }
        }
        // Once all the nodes are visited, return the minimum depth of the tree.
        return minLevel;
    }
}
