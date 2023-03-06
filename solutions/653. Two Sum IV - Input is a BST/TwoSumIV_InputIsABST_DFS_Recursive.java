package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

// Time Complexity  : O(n),
// where 'n' is the number of nodes in the binary search tree.
// The worst-case is when we fully traverse the binary tree and not found the two sum.
//
// Space Complexity : O(n + m),
// where 'n' is the number of nodes in the binary search tree, and 'm' is the maximum depth of the binary search tree.
// The worst-case is when no two sum is found, with the HashSet having all the node values in the binary search tree, O(n).
// The recursive call stack has a maximum size corresponding to the maximum breadth of the BST, O(m).

public class TwoSumIV_InputIsABST_DFS_Recursive {

    // Approach:
    // Use depth-first search (DFS) to traverse the binary search tree (BST),
    // and use a HashSet to record the values of the visited nodes.
    // Here, the DFS is performed recursively.
    // For each node, we check if the difference (k - value) is found in the HashSet.
    // If the difference is found in the HashSet, return true.
    //
    // For example, HashSet = { 1, 2, 3 }, k = 6.
    // If the node value is 5, the 'k - value' (6 - 5) = 1, which is found in the HashSet,
    // then we have found the two sum, 1 and 5, to sum up to k.
    //
    // Using HashSet has greater space complexity as we need to store the node value,
    // but faster than using Binary Search as the retrieval of value from the HashSet is O(1).

    // Use HashSet to store the values of the visited nodes.
    // The HashSet is set outside for the recursive call stacks to have access.
    Set<Integer> set = new HashSet<>();

    public boolean findTarget(TreeNode root, int k) {
        // Skip this recursion if the node is null.
        if (root == null) return false;

        int value = root.val;
        // If the difference (k - 'value') is found in the HashSet, then we have found the two sum.
        if (set.contains(k - value)) return true;

        // If not found, then add the node value to the HashSet.
        set.add(value);

        // Traverse the left and right child nodes.
        // Return true if the two sum is found.
        if (findTarget(root.left, k)) return true;
        if (findTarget(root.right, k)) return true;

        // If no two sum is found after the traversal, return false.
        return false;
    }
}
