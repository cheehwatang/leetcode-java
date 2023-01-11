package com.cheehwatang.leetcode;

import java.util.ArrayList;
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
// Note: Remember to set up a TreeNode class as the same folder as your inorder traversal algorithms.

// Time Complexity  : O(n),
// where 'n' is the number of nodes in the tree, as we are traversing every single node.
// However, this does not take into account the resizing of the array backing the ArrayList,
// depending on the size of nodes in the tree.
//
// Space Complexity : O(n),
// where 'n' is the number of nodes in the tree,
// as we are recording the value of every node into the List.
// The recursive call stack only takes up the maximum space of tree height, which is smaller than 'n'.

public class BinaryTreeInorderTraversal_Recursive {

    // Approach:
    // Using recursive function to traverse the tree, visiting the nodes in the order of:
    // 1. Left node (with another recursive call).
    // 2. Visit the root node, and add the value to the list.
    // 3. Right node (with another recursive call).

    // Wrapper method to set up and initialize the recursive function.
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integerList = new ArrayList<>();
        integerList = inorderTraversal(integerList, root);
        return integerList;
    }

    // Recursive method.
    public static List<Integer> inorderTraversal(List<Integer> integerList, TreeNode root) {
        // The base case, for when the root is null.
        if (root == null) return integerList;

        // For inorder traversal, we first visit the left node,
        integerList = inorderTraversal(integerList, root.left);
        // then we visit the root, and perform a certain operation,
        // in this case, we add the value of the root to the list.
        integerList.add(root.val);
        // Lastly, we visit the right node.
        integerList = inorderTraversal(integerList, root.right);

        // Once done, we return the list.
        return integerList;
    }
}
