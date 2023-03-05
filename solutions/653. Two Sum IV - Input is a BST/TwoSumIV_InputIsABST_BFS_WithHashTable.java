package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

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
// where 'n' is the number of nodes in the binary search tree.
// The worst-case is when we fully traverse the binary tree and not found the two sum.
//
// Space Complexity : O(n + m),
// where 'n' is the number of nodes in the binary search tree, and 'm' is the maximum breadth of the binary search tree.
// The worst-case is when no two sum is found, with the HashSet having all the node values in the binary search tree, O(n).
// The Queue used in the breadth-first search has a maximum size corresponding to the maximum breadth of the BST, O(m).

public class TwoSumIV_InputIsABST_BFS_WithHashTable {

    // Approach:
    // Use breadth-first search (BFS) to traverse the binary search tree (BST),
    // and use a HashSet to record the values of the visited nodes.
    // For each node, we check if the difference (k - value) is found in the HashSet.
    // If the difference is found in the HashSet, return true.
    //
    // For example, HashSet = { 1, 2, 3 }, k = 6.
    // If the node value is 5, the 'k - value' (6 - 5) = 1, which is found in the HashSet,
    // then we have found the two sum, 1 and 5, to sum up to k.
    //
    // Using HashSet has greater space complexity as we need to store the node value,
    // but faster than using Binary Search as the retrieval of value from the HashSet is O(1).

    public boolean findTarget(TreeNode root, int k) {
        // Use HashSet to store the values of the visited nodes.
        Set<Integer> set = new HashSet<>();

        // Breadth-first search (BFS) is performed using Queue.
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Continue to traverse the binary search tree until the Queue is empty.
        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();
            int value = current.val;
            // If the difference (k - 'value') is found in the HashSet, then we have found the two sum.
            if (set.contains(k - value)) return true;

            // If not found, then add the node value to the HashSet.
            set.add(value);
            // Offer the child nodes to the Queue.
            if (current.left != null) queue.offer(current.left);
            if (current.right != null) queue.offer(current.right);
        }
        // If no two sum is found after the traversal, return false.
        return false;
    }
}
