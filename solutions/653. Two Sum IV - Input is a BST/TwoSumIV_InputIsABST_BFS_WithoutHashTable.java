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

// Time Complexity  : O(n logn),
// where 'n' is the number of nodes in the binary search tree.
// For each node O(n), we need to perform binary search O(logn) to find the corresponding pair to sum to 'k'.
//
// Space Complexity : O(m),
// where 'm' is the maximum breadth of the binary search tree.
// The Queue used in the breadth-first search has a maximum size corresponding to the maximum breadth of the BST, O(m).
// The auxiliary space used in the binary search method is independent of the size of the binary search tree.

public class TwoSumIV_InputIsABST_BFS_WithoutHashTable {

    // Approach:
    // Use breadth-first search (BFS) to traverse the binary search tree (BST),
    // and use binary search to find the two sum pair.
    // For each node, we check if the difference (k - value) is found in the BST using binary search.
    // If the difference is found in the BST, return true.
    //
    // Using Binary Search on BST does not consume additional space as compared to using HashSet,
    // but it takes up more time as each search we need to traverse down a path in the BST, O(logn).

    public boolean findTarget(TreeNode root, int k) {
        // Breadth-first search (BFS) is performed using Queue.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Continue to traverse the binary search tree until the Queue is empty.
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int value = current.val;
            // If the difference (k - 'value') is found in the BST, then we have found the two sum.
            // As we perform the binary search on the BST, we need to make sure the value is not paired to itself,
            // thus check 'value * 2 != k'.
            if (value * 2 != k && binarySearch(root, k - value)) return true;

            // Offer the child nodes to the Queue.
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
        // If no two sum is found after the traversal, return false.
        return false;
    }

    // With binary search tree, we can be sure that each node has unique value,
    // and the left node has value lesser, and the right node has value greater.
    private boolean binarySearch(TreeNode current, int difference) {
        while (current != null) {
            if (difference == current.val) return true;
            // Traverse left if the difference is lesser,
            if (difference < current.val)
                current = current.left;
            // and traverse right if the difference is greater.
            else
                current = current.right;
        }
        return false;
    }
}
