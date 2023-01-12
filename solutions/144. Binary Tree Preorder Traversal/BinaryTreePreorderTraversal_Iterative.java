package com.cheehwatang.leetcode;

import java.util.LinkedList;
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
// Note: Remember to set up a TreeNode class as the same folder as your preorder traversal algorithms.

// Time Complexity  : O(n),
// where 'n' is the number of nodes in the tree, as we are traversing every single node.
//
// Space Complexity : O(n),
// where 'n' is the number of nodes in the tree,
// as we are recording the data of every node into the List.
// The stack only takes up the maximum space of tree height, which is smaller than 'n'.

public class BinaryTreePreorderTraversal_Iterative {

    // Approach:
    // For depth first search, we use stack to record the nodes to be visited, visiting the nodes in the order of:
    // 1. Visit the root node, and add the value to the list.
    // 2. Left node (until we hit null, while storing the nodes in the stack).
    // 3. Right node (if any, then restart step 1 and step 2).
    //
    // Note: Other than slight variation in the algorithm,
    //       both preorder and postorder traversal also use Stack when implemented iteratively.

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> integerList = new LinkedList<>();
        Stack<TreeNode> rightNodes = new Stack<>();

        while (root != null) {
            // First, we record the root.
            integerList.add(root.val);

            // If right node is available, push the right node into the Stack first.
            // We will pop it later we are done with the left nodes.
            if (root.right != null) {
                rightNodes.push(root.right);
            }

            // Continue to traverse to the left, while recording each subtree root nodes,
            // and pushing the subtree right nodes into the stack.
            // Once reaches a leaf node, pop the right nodes and continue.
            root = root.left;
            if (root == null && !rightNodes.isEmpty()) {
                root = rightNodes.pop();
            }
        }
        // Fully traversed the tree.
        return integerList;
    }
}


