package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;
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
// Note: Remember to set up a TreeNode class as the same folder as your inorder traversal algorithms.

// Time Complexity  : O(n),
// where 'n' is the number of nodes in the tree, as we are traversing every single node.
// However, this does not take into account the resizing of the array backing the ArrayList,
// depending on the size of nodes in the tree.
//
// Space Complexity : O(n),
// where 'n' is the number of nodes in the tree,
// as we are recording the data of every node into the List.
// The stack only takes up the maximum space of tree height, which is smaller than 'n'.

public class BinaryTreeInorderTraversal_Iterative {

    // Approach:
    // For depth first search, we use stack to record the nodes to be visited, visiting the nodes in the order of:
    // 1. Left node (until we hit null, while storing the nodes in the stack).
    // 2. Visit the root node, and add the value to the list.
    // 3. Right node (if any, then restart step 1 and step 2).
    //
    // Note: Other than slight variation in the algorithm,
    //       both preorder and postorder traversal also use Stack when implemented iteratively.

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> integerList = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        // We use a pointer to keep track of the current node.
        TreeNode pointer = root;
        // At any point, if the pointer is null and the stack is empty, we have fully traversed the tree.
        while (pointer != null || !stack.isEmpty()) {
            // For any node, completely traverse the left branch.
            while (pointer != null) {
                stack.push(pointer);
                pointer = pointer.left;
            }
            // Once we have reached the end of the left branch (from any node),
            // add the value of the top node into the list.
            integerList.add(stack.peek().val);
            // Visit the right node (if any).
            // Note that if the right node is null, the pointer is null, which will continue to pop the stack.
            // If ever the right node is not null, then we fully traverse its left branch.
            pointer = stack.pop().right;
        }
        // Fully traversed the tree.
        return integerList;
    }
}
