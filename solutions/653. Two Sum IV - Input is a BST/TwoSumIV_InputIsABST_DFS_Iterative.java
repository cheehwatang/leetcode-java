package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

// Time Complexity  : O(n),
// where 'n' is the number of nodes in the binary search tree.
// The worst-case is when we fully traverse the binary tree and not found the two sum.
//
// Space Complexity : O(n + m),
// where 'n' is the number of nodes in the binary search tree, and 'm' is the maximum depth of the binary search tree.
// The worst-case is when no two sum is found, with the HashSet having all the node values in the binary search tree, O(n).
// The Stack used in the depth-first search has a maximum size corresponding to the maximum depth of the BST, O(m).

public class TwoSumIV_InputIsABST_DFS_Iterative {

    // Approach:
    // Use depth-first search (DFS) to traverse the binary search tree (BST),
    // and use a HashSet to record the values of the visited nodes.
    // Here, the DFS is performed iteratively using Stack.
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

        // Depth-first search (DFS) is performed using Stack.
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        // Continue to traverse the binary search tree until the Stack is empty.
        while (!stack.empty()) {
            TreeNode current = stack.pop();
            int value = current.val;
            // If the difference (k - 'value') is found in the HashSet, then we have found the two sum.
            if (set.contains(k - value)) return true;

            // If not found, then add the node value to the HashSet.
            set.add(value);
            // Offer the child nodes to the Stack.
            if (current.left != null) stack.push(current.left);
            if (current.right != null) stack.push(current.right);
        }
        // If no two sum is found after the traversal, return false.
        return false;
    }
}
