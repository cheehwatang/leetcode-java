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
// We traverse every node in the binary tree to get the maximum difference of the nodes values in the paths.
//
// Space Complexity : O(m),
// where 'm' is the depth of the tree.
// The maximum size of the stacks ('nodeStack', 'minStack' and 'maxStack') is the depth of the tree.

public class MaximumDifferenceBetweenNodeAndAncestor_Iterative {

    // Approach:
    // Using depth-first search to traverse every path (from root to leaf) in the binary tree,
    // and find the maximum difference of the nodes values in the paths.
    // Here, the depth-first search is implemented iteratively.

    public int maxAncestorDiff(TreeNode root) {
        // The maximum difference starts at the minimum value of 0.
        int maxDiff = 0;

        // Iterative depth-first search is implemented using 'stack'.
        // Here, we use three stacks for the iterative depth-first search,
        // for the TreeNode, minimum node value in the path, and maximum node value in the path respectively.
        // Alternatively, we can create another class to encapsulate all three values,
        // improving readability and uses only one stack.
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<Integer> minStack = new Stack<>();
        Stack<Integer> maxStack = new Stack<>();
        // Add the root node and the value into the stacks.
        nodeStack.push(root);
        minStack.push(root.val);
        maxStack.push(root.val);

        // If there are nodes in the 'stack', continue to traverse the tree until all nodes are visited.
        while (!nodeStack.empty()) {
            // Update the minimum and maximum node value in the current path.
            TreeNode current = nodeStack.pop();
            int min = Math.min(minStack.pop(), current.val);
            int max = Math.max(maxStack.pop(), current.val);

            // Update if we found a greater maximum difference result.
            maxDiff = Math.max(maxDiff, max - min);

            // If there are left and/or right node, add the TreeNode, the minimum value and maximum value of the path
            // into the stacks.
            if (current.left != null) {
                nodeStack.push(current.left);
                minStack.push(min);
                maxStack.push(max);
            }
            if (current.right != null) {
                nodeStack.push(current.right);
                minStack.push(min);
                maxStack.push(max);
            }
        }
        // Return the maximum difference found once all the paths are visited.
        return maxDiff;
    }
}
