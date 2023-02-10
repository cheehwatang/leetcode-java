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
// We traverse every node in the binary tree to find the all the left leaf nodes.
//
// Space Complexity : O(m),
// where 'm' is the depth of the tree.
// The maximum size of the recursive stack is the depth of the tree.

public class SumOfLeftLeaves_DFS_Recursive {

    // Approach:
    // Using depth-first search to traverse and visit every node in the binary tree.
    // When we found a left child node that is a leaf node, add to the sum.
    // Return the sum once we have fully traversed the tree.
    // Here, the depth-first search is implemented recursively.

    public int sumOfLeftLeaves(TreeNode root) {
        // If the tree is empty, there is no left leaf nodes to add to the sum.
        // This check here is important to prevent any NullPointerException.
        if (root == null) return 0;

        int sum = 0;

        // If the left node is not null,
        if (root.left != null) {
            // add the left child node value to the sum if it is a leaf node,
            if (root.left.left == null && root.left.right == null)
                sum += root.left.val;
            // or traverse the left branch if it is not a leaf node.
            else
                sum += sumOfLeftLeaves(root.left);
        }
        // Traverse the right branch to find any left leaf nodes.
        // It is optional to check if the right node is null, as it will return 0 if null, which does not affect the sum.
        sum += sumOfLeftLeaves(root.right);

        // Return the sum once all the nodes are visited.
        return sum;
    }
}
