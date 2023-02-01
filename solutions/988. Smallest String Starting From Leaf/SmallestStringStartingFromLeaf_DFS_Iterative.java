package com.cheehwatang.leetcode;

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
// where 'n' is the number of nodes in the tree.
// We traverse every node in the binary tree
// to find all the root-to-leaf paths and compare to find the smallest string.
//
// Space Complexity : O(m),
// where 'm' is the depth of the tree.
// The maximum size of the 'nodeStack' and the 'pathStack' is the depth of the tree.

public class SmallestStringStartingFromLeaf_DFS_Iterative {

    // Approach:
    // Using depth-first search to find every root-to-leaf paths and
    // compare to find the smallest string lexicographically.
    // Here, the depth-first search is implemented iteratively using stack
    // to keep track of the nodes ('nodeStack') and path ('pathStack').
    // We only compare the strings when we have arrived at the leaf node.

    public String smallestFromLeaf(TreeNode root) {

        // Remember to initialize the 'smallestString' by setting to null.
        // This prevents compile-time error.
        // With that, we also need to check for null later before comparing to find the smallest string.
        // Note: An alternative is the use a string greater than "z" as the value for 'smallestString',
        //       strings such as "|" or "~".
        String smallestString = null;

        // Iterative depth-first search uses stack.
        // Here, we need two stacks to keep track of the nodes ('nodeStack') and paths ('pathStack').
        Stack<TreeNode> nodeStack = new Stack<>();
        Stack<String> pathStack = new Stack<>();
        nodeStack.push(root);
        pathStack.push("");

        // Continue to traverse the binary tree until all nodes are visited.
        while (!nodeStack.isEmpty()) {

            // Get the 'currentNode' and 'currentPath'.
            TreeNode currentNode = nodeStack.pop();
            String currentPath = (char)(currentNode.val + 'a') + pathStack.pop();

            // If we reached at leaf node,
            if (currentNode.left == null && currentNode.right == null) {
                // and 'currentPath' is smaller lexicographically, set 'currentPath' as the new 'smallestString'.
                if (smallestString == null || currentPath.compareTo(smallestString) < 0) {
                    smallestString = currentPath;
                    continue;
                }
            }

            // If we have the left or right child node, add them to the 'nodeStack' along with the 'currentPath'.
            if (currentNode.left != null) {
                nodeStack.push(currentNode.left);
                pathStack.push(currentPath);
            }
            if (currentNode.right != null) {
                nodeStack.push(currentNode.right);
                pathStack.push(currentPath);
            }
        }
        // Once we traverse the whole binary tree, return the smallest string.
        return smallestString;
    }
}
