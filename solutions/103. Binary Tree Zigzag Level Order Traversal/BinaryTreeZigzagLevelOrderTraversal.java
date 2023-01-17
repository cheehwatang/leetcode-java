package com.cheehwatang.leetcode;

import java.util.LinkedList;
import java.util.List;

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
// Note: Remember to set up a TreeNode class as the same folder as your level-order traversal algorithms.

// Time Complexity  : O(n),
// where 'n' is the number of nodes in the tree, as we are traversing every single node.
//
// Space Complexity : O(n),
// where 'n' is the number of nodes in the tree,
// as we are recording the data of every node into the List.
// The queue only takes up the maximum space of tree breadth, which is smaller than 'n'.

public class BinaryTreeZigzagLevelOrderTraversal {

    // Approach:
    // Similar to 102. Binary Tree Level Order Traversal, but add the values in the alternating levels in reverse.
    // Using a Queue, we traverse the tree one level at a time,
    // each time checking for the children of the current node and adding to the queue.
    // We use a flag to keep track of the direction of addition of node values in the level.
    // As we need to add the levels into the result, we use a new list for each level we traverse.

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        // The usage of either LinkedList or ArrayList are possible with both offering similar performance.
        List<List<Integer>> integerList = new LinkedList<>();

        // If the 'root' is null, we return an empty list.
        if (root == null) return integerList;

        // Once we know the 'root' is not null, we can add the 'root' to the 'queue'.
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // Flag to keep track of the direction of addition of node values in the level.
        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            // New list to record the node values of the current level.
            LinkedList<Integer> level = new LinkedList<>();

            // Remember to record the size of the 'queue', which is the size of the current level, using a variable.
            // If we use "i < queue.size()" as the condition to break out of the loop,
            // it might result in the inaccurate recording of the node values for each level,
            // as the queue.size() is changing as we offer() or poll() nodes.
            for (int i = 0, size = queue.size(); i < size; i++) {
                // Remove the node from the 'queue'.
                TreeNode currentNode = queue.poll();

                // If either the left or right child is not null, add to the 'queue' for next level.
                if (currentNode.left != null) queue.offer(currentNode.left);
                if (currentNode.right != null) queue.offer(currentNode.right);

                // Add the node value to the 'level' list according to the direction of addition.
                if (leftToRight)
                    level.addLast(currentNode.val);
                else
                    level.addFirst(currentNode.val);
            }
            // Once we finish traversing the level, flip the flag,
            // and add the 'level' at the first position of the result.
            leftToRight = !leftToRight;
            integerList.add(level);
        }

        // Once the tree is fully traversed, return the result.
        return integerList;
    }
}
