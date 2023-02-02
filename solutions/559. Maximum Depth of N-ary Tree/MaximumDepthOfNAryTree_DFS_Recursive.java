package com.cheehwatang.leetcode;

/**
 // Definition for a Node.
 class Node {
 public int val;
 public List<Node> children;

 public Node() {}

 public Node(int _val) {
 val = _val;
 }

 public Node(int _val, List<Node> _children) {
 val = _val;
 children = _children;
 }
 };
 */
// Note: Remember to set up a Node class as the same folder.

// Time Complexity  : O(n),
// where 'n' is the number of nodes in the tree.
// We traverse every node in the tree to find the maximum depth of the tree.
//
// Space Complexity : O(m),
// where 'm' is the depth of the tree.
// The maximum size of the recursive call stack is the depth of the tree.

public class MaximumDepthOfNAryTree_DFS_Recursive {

    // Approach:
    // Using depth-first search to find the depth of every node.
    // Then, compare and find the maximum depth.
    // Here, the depth-first search is implemented recursively.

    // Main method to check for empty tree and to initialize the recursive method.
    public int maxDepth(Node root) {
        // If the tree is empty, there is zero depth.
        if (root == null) return 0;

        // Call the recursive method to perform depth-first search of the tree, with the level of the root is 1.
        return maxDepth(root, 1);
    }

    // Recursive method to traverse the tree to find the maximum depth of the tree.
    private int maxDepth(Node root, int level) {
        // Once we reach a leaf node, return the level of the node.
        if (root.children.isEmpty()) return level;

        // Use a variable 'maxLevel' to compare the maximum depth of all the child nodes.
        int maxLevel = 0;

        // Get the maximum depth of all the child nodes,
        for (Node child : root.children)
            // and compare to get the maximum depth of the branches.
            maxLevel = Math.max(maxLevel, maxDepth(child, level + 1));

        // Return the maximum depth.
        return maxLevel;
    }
}
