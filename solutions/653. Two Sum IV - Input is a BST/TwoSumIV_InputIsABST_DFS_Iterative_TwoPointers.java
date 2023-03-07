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
// Note: Remember to set up a TreeNode class as the same folder.

// Time Complexity  : O(n),
// where 'n' is the number of nodes in the binary search tree.
// Firstly, we traverse the binary search tree once to convert to an integer list, O(n).
// Then, we use two pointers to traverse the 'values' integer list from both ends to find the two sum,
// with the worst-case being that no two sum is found in the list, O(n).
//
// Space Complexity : O(n),
// where 'n' is the number of nodes in the binary search tree.
// We converted the binary search tree to an integer list of size 'n'.
// The auxiliary space used in the two pointers to find the two sum is independent on the size of the binary search tree.

public class TwoSumIV_InputIsABST_DFS_Iterative_TwoPointers {

    // Approach:
    // First, convert the binary search tree to an ordered integer list using inorder traversal.
    // Here, the inorder traversal is performed iteratively.
    // Then, we use two pointers to traverse the 'values' integer list from both ends, 'left' and 'right' pointer.
    // As 'values' is ordered in ascending order, we can traverse the array to check all pairs.
    // If the integer sum is greater than 'k', move the 'right' pointer to the left.
    // If the integer sum is less than 'k', move the 'left' pointer to the right.
    // If the integer sum is the same as 'k', then return true as we have found the two sum.
    //
    // This approach is slower than the other depth-first search or breadth-first search solutions using Hash Table
    // because this requires us to first convert the binary search tree into an integer list,
    // then only we use two pointers to find the two sums.
    // The other approaches directly use the binary search tree to find the two sum.

    public boolean findTarget(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        inorderTraversal(root, values);

        // Two pointers, the 'left' and 'right'.
        int left = 0;
        int right = values.size() - 1;
        while (left < right) {
            int sum = values.get(left) + values.get(right);
            // If the sum is > k, then decrease the 'right' pointer.
            if (sum > k) right--;
            // If sum < k, then increase the 'left' pointer.
            else if (sum < k) left++;
            // If we found the sum == k, we have found the two sum.
            else return true;
        }
        // If the target is not found after checking all the pairs, then return false;
        return false;
    }

    // Iterative inorder traversal to convert the binary search tree to an integer list.
    private void inorderTraversal(TreeNode root, List<Integer> values) {
        // Iterative depth-first search is performed using Stack if performed iteratively.
        Stack<TreeNode> stack = new Stack<>();

        // We use a 'current' pointer to keep track of the current node.
        TreeNode current = root;

        // At any point, if the 'current' node is null and the stack is empty, we have fully traversed the tree.
        while (current != null || !stack.empty()) {
            // For any node, completely traverse the left branch.
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            // Once we have reached the end of the left branch (from any node),
            // add the value of the top node into the 'values' list.
            values.add(stack.peek().val);

            // Visit the right node (if any).
            // Note that if the right node is null, the 'current' node is null, we will continue to pop the stack.
            // If ever the right node is not null, then we fully traverse its left branch.
            current = stack.pop().right;
        }
    }
}
