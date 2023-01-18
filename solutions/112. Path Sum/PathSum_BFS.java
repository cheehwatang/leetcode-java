package com.cheehwatang.leetcode;

import java.util.LinkedList;
import java.util.Queue;

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
// where 'm' is the breadth of the binary tree.
// This is because the maximum number of nodes in the queue is the breadth binary tree.

public class PathSum_BFS {

    // Approach:
    // Traverse every root-to-leaf path using breadth-first search and
    // return true if found path sum equal to 'targetSum'.
    // As we traverse the binary tree, we add the value of the parent to the child nodes' value,
    // thus getting the path sum at every point along the root-to-leaf path.
    // Here, we use queue to implement breadth-first search.

    public boolean hasPathSum(TreeNode root, int targetSum) {
        // If there are no nodes in the binary tree, then it is impossible to get any 'targetSum'.
        if (root == null) return false;

        // Use queue to implement the breadth-first search.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            // Remember to record the size of the 'queue', which is the size of the current level, using a variable.
            // If we use "i < queue.size()" as the condition to break out of the loop,
            // it might result in the inaccurate recording of the node values for each level,
            // as the queue.size() is changing as we offer() or poll() nodes.
            for (int i = 0, size = queue.size(); i < size; i++) {
                // Remove the node from the 'queue'.
                TreeNode currentNode = queue.poll();

                // If the path sum of the leaf node is equal to the 'targetSum', return true.
                if (currentNode.left == null && currentNode.right == null && currentNode.val == targetSum)
                    return true;

                // Add the value of the 'currentNode' to the left and right child, if not null.
                // Add the children to the 'queue'.
                if (currentNode.left != null) {
                    currentNode.left.val += currentNode.val;
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    currentNode.right.val += currentNode.val;
                    queue.offer(currentNode.right);
                }
            }
        }
        // If traverse the whole binary tree yet not found the path sum, return false.
        return false;
    }
}
