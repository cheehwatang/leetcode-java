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
// where 'n' is the number of nodes in the tree, as we are traversing every node in both trees.
//
// Space Complexity : O(n),
// where 'n' is the number of nodes in the tree.
// The worst-case is when all the nodes are recorded in the stack during the traversal.

public class SameTree_DFS {

    // Approach:
    // Using Depth-First Search (stack) to traverse the two tree, 'p' and 'q' one node at a time in-sync.
    // Here, we are traversing the tree iteratively using stack.
    // If the node is different, return false.
    // If we successfully traverse the both trees, then both are the same tree.

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // For iterative depth-first search, we use stack, each for their respective trees.
        Stack<TreeNode> stackForP = new Stack<>();
        Stack<TreeNode> stackForQ = new Stack<>();
        // Put the nodes in their respective stacks.
        stackForP.push(p);
        stackForQ.push(q);

        // Continue to traverse the tree until no more nodes is in the stack, in which case both trees are the same,
        // or until we found two nodes that are different, which we return false.
        while (!stackForP.isEmpty() && !stackForQ.isEmpty()) {
            p = stackForP.pop();
            q = stackForQ.pop();
            // If both nodes are null, move to the next node, as there is no node and no children to add to the stacks.
            if (p == null && q == null) continue;
            // If either nodes are null, or their values are different, then return false.
            if (p == null || q == null || p.val != q.val) return false;

            // Add the left and right child to the stack.
            // Note that we leave the node checking to the next round.
            // We add the children regardless, even if the children are null.
            stackForP.push(p.left);
            stackForQ.push(q.left);
            stackForP.push(p.right);
            stackForQ.push(q.right);
        }
        // If we successfully traverse both trees, then return true.
        return true;
    }
}
