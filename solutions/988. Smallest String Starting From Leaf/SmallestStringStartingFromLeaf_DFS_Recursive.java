package com.cheehwatang.leetcode;

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
// where 'n' is the number of nodes in the tree.
// We traverse every node in the binary tree
// to find all the root-to-leaf paths and compare to find the smallest string.
//
// Space Complexity : O(m),
// where 'm' is the depth of the tree.
// The maximum size of the recursive call stack is the depth of the tree.

public class SmallestStringStartingFromLeaf_DFS_Recursive {

    // Approach:
    // Using depth-first search to find every root-to-leaf paths and
    // compare to find the smallest string lexicographically.
    // Here, the depth-first search is implemented recursively.
    // We only compare the strings when we have arrived at the leaf node.

    // Main method to initialize and find the smallest string.
    public String smallestFromLeaf(TreeNode root) {
        return smallestFromLeaf(root, "");
    }

    // Recursive method to traverse the binary tree, and compare and return the smallest string.
    private String smallestFromLeaf(TreeNode root, String pathString) {
        // As we design the recursion to visit the left and right child regardless if it is null,
        // we perform the check here if the root is null.
        if (root == null) return "";

        // Insert the letter at the first position of the 'pathString'.
        pathString = (char)(root.val + 'a') + pathString;

        // Traverse the left and the right child nodes, and get the string.
        String leftPath = smallestFromLeaf(root.left, pathString);
        String rightPath = smallestFromLeaf(root.right, pathString);

        // If both left and right child nodes returned non-empty strings,
        // we return the string that is smaller lexicographically.
        if (leftPath.length() > 0 && rightPath.length() > 0)
            return (leftPath.compareTo(rightPath) < 0) ? leftPath : rightPath;
        // If only either left or right is a non-empty string, return that string.
        else if (leftPath.length() > 0)
            return leftPath;
        else if (rightPath.length() > 0)
            return rightPath;
        // If both left and right child nodes are null, we have arrived at the leaf node and return the 'pathString'.
        else
            return pathString;
    }
}
