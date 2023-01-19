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
// In the worst-case, we traverse every node in the binary tree to find a path with path sum equal to the 'targetSum'.
//
// Space Complexity : O(m),
// where 'm' is the depth of the binary tree.
// This is because the maximum number of nodes in the stack is the depth of the binary tree.

public class PathSum_DFS_Iterative {

    // Approach:
    // Traverse every root-to-leaf path using depth-first search and
    // return true if found path sum equal to 'targetSum'.
    // As we traverse the binary tree, we add the value of the parent to the child nodes' value,
    // thus getting the path sum at every point along the root-to-leaf path.
    // Here, we use stack to implement depth-first search iteratively.

    public boolean hasPathSum(TreeNode root, int targetSum) {
        // If there are no nodes in the binary tree, then it is impossible to get any 'targetSum'.
        if (root == null) return false;

        // Use stack to implement the depth-first search.
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            // Remove the node from the 'stack'.
            TreeNode currentNode = stack.pop();

            // If the path sum of the leaf node is equal to the 'targetSum', return true.
            if (currentNode.left == null && currentNode.right == null && currentNode.val == targetSum)
                return true;

            // Add the value of the 'currentNode' to the left and right child, if not null.
            // Push the children to the 'stack'.
            if (currentNode.left != null) {
                currentNode.left.val += currentNode.val;
                stack.push(currentNode.left);
            }
            if (currentNode.right != null) {
                currentNode.right.val += currentNode.val;
                stack.push(currentNode.right);
            }
        }
        // If traverse the whole binary tree yet not found the path sum, return false.
        return false;
    }
}
