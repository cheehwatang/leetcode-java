package com.cheehwatang.leetcode;

import java.util.Stack;

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
// The maximum size of the 'nodeStack' and 'levelStack' is the depth of the tree.

public class MaximumDepthOfNAryTree_DFS_Iterative {

    // Approach:
    // Using depth-first search to find and determine the depth of every root-to-leaf paths.
    // Then, compare and find the maximum depth whenever we arrived at a leaf node.
    // Here, the depth-first search is implemented iteratively.

    public int maxDepth(Node root) {
        // If the tree is empty, there is zero depth.
        if (root == null) return 0;

        // Both the depth and level of a tree describe the same thing.
        // Here, we use 'maxLevel' as a variable name to make it differ from the 'maxDepth()' method.
        int maxLevel = 0;

        // For iterative depth-first search,
        // we use 'nodeStack' for the nodes and 'levelStack' to for the level of the node.
        Stack<Node> nodeStack = new Stack<>();
        Stack<Integer> levelStack = new Stack<>();

        // Each time pushing a node into the 'nodeStack', push the level of the node to the 'levelStack'.
        nodeStack.push(root);
        levelStack.push(1);

        while (!nodeStack.isEmpty()) {
            // Get the current node and level of the node.
            Node currentNode = nodeStack.pop();
            int currentLevel = levelStack.pop();

            // Once we reach a leaf node, compare and update the 'maxLevel'.
            if (currentNode.children.isEmpty()) {
                maxLevel = Math.max(maxLevel, currentLevel);
                continue;
            }

            // If there are child nodes,
            // add them to the 'nodeStack' as well as their level ('currentLevel' + 1) to 'levelStack'.
            for (Node child : currentNode.children) {
                nodeStack.push(child);
                levelStack.push(currentLevel + 1);
            }
        }
        // Once all the nodes are visited, return the maximum depth of the tree.
        return maxLevel;
    }
}
