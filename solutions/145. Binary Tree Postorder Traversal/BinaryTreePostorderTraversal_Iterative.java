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
// Note: Remember to set up a TreeNode class as the same folder as your postorder traversal algorithms.

// Time Complexity  : O(n),
// where 'n' is the number of nodes in the tree, as we are traversing every single node.
//
// Space Complexity : O(n),
// where 'n' is the number of nodes in the tree,
// as we are recording the data of every node into the List.
// The stack only takes up the maximum space of tree height, which is smaller than 'n'.

public class BinaryTreePostorderTraversal_Iterative {

    // Approach:
    // For postorder traversal, we visit the node in the following order:
    // 1. Left node.
    // 2. Right node.
    // 3. Visit the root node, and add the value to the list.
    // Using a LinkedList and adding the 'root' node value at the front of the LinkedList,
    // the first added value is the last visited node in the result.
    //
    // Note: Other than slight variation in the algorithm,
    //       both preorder and postorder traversal also use Stack when implemented iteratively.

    public List<Integer> postorderTraversal(TreeNode root) {

        // As we are adding the value at the front of the list,
        // the use of LinkedList is more efficient than ArrayList,
        // as the addition of node at first position in LinkedList is O(1) time complexity,
        // while addition of node at first position in ArrayList is O(n) time complexity
        // due to the shifting of values in the backing array.
        List<Integer> integerList = new LinkedList<>();

        // If the 'root' is null, we return an empty list.
        if (root == null) return integerList;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()) {
            root = stack.pop();
            // Since we are adding the value of the 'root' after visiting the 'left' and 'right' nodes,
            // we can insert the 'root' values in the first position, with the first added being the last visited.
            integerList.add(0, root.val);

            // If either 'left' or 'right' nodes are not null, visit that node.
            if (root.left != null) stack.push(root.left);
            if (root.right != null) stack.push(root.right);
        }

        // Once the tree is fully traversed, return the result.
        return integerList;
    }
}
