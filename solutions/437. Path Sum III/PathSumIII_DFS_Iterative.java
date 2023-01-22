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

// Time Complexity  : O(n^2),
// where 'n' is the number of nodes in the tree.
// We traverse every node in the binary tree to find all the paths with path sum equal to the 'targetSum',
// and treating every node in the tree as the root for the subtree.
//
// Time Complexity  : O(m^2),
// where 'm' is the depth of the binary tree.
// The 'nodeStack' used to perform the iterative depth-first search has the maximum size of the depth of the tree.
// The 'pathStack' used to keep track of the path sum for every node in the path
// has a maximum size of 'm', with every path sum List in the stack has a maximum size of 'm',
// thus resulted in time complexity of O(m^2).

public class PathSumIII_DFS_Iterative {

    // Approach:
    // Perform the usual iterative depth-first search using stack,
    // while using an additional stack to keep track of the path sum for each node in the path.
    // Each time we visit a new node, add the value of the node to all the path sums in the path.
    // If any path sum is equal to the 'targetSum', we increase the count.

    public int pathSum(TreeNode root, int targetSum) {
        // If the tree is empty, no path is available to get 'targetSum'.
        if (root == null) return 0;
        int count = 0;

        // 'nodeStack' is the usual stack use for iterative depth-first search.
        // 'pathStack' records the list of the path sums in the path.
        // Note that we are using Long here to prevent integer overflow, as we are adding the path sum
        // with the node value ranges from -10^9 to 10^9.
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<List<Long>> pathStack = new Stack<>();
        // Add the 'root' to the stack, and use a new empty list for the path sum stack.
        nodeStack.push(root);
        pathStack.push(new ArrayList<>());

        while (!nodeStack.isEmpty()) {
            TreeNode currentNode = nodeStack.pop();
            List<Long> currentPath = pathStack.pop();
            // As we are adding the node value to the path sums,
            // add a zero value to the path for the current node.
            currentPath.add(0L);

            // Add the node value to all the path sums in the path.
            for (int i = 0; i < currentPath.size(); i++) {
                currentPath.set(i, currentPath.get(i) + currentNode.val);
                // If the path sum is equal to the 'targetSum', increase the count.
                if (currentPath.get(i) == targetSum) count++;
            }

            // Check the left and right child nodes, if any.
            // Remember to create a new ArrayList for the path sum list.
            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
                pathStack.push(new ArrayList<>(currentPath));
            }
            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
                pathStack.push(new ArrayList<>(currentPath));
            }
        }
        // Once all the paths are checked, return the count.
        return count;
    }
}
