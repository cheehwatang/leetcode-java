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
// Note: Remember to set up a TreeNode class as the same folder as your preorder traversal algorithms.

// Time Complexity  : O(n),
// where 'n' is the number of nodes in the tree, as we are traversing every single node.
//
// Space Complexity : O(n),
// where 'n' is the number of nodes in the tree,
// as we are recording the value of every node into the List.
// The recursive call stack only takes up the maximum space of tree height, which is smaller than 'n'.

public class BinaryTreePreorderTraversal_Recursive {

    // Approach:
    // Using recursive function to traverse the tree, visiting the nodes in the order of:
    // 1. Visit the root node, and add the value to the list.
    // 2. Left node (with another recursive call).
    // 3. Right node (with another recursive call).

    // Wrapper method to set up and initialize the recursive function.
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> integerList = new LinkedList<>();
        integerList = preorderTraversal(root, integerList);
        return integerList;
    }

    // Recursive method.
    private List<Integer> preorderTraversal(TreeNode root, List<Integer> integerList) {
        // The base case, for when the root is null.
        if (root == null) return integerList;

        // For preorder traversal, we first visit the root and add the value of the root to the list.
        integerList.add(root.val);
        // Then, we visit the left node.
        preorderTraversal(root.left, integerList);
        // Lastly, we visit the right node.
        preorderTraversal(root.right, integerList);

        // Once done, we return the list.
        return integerList;
    }
}
