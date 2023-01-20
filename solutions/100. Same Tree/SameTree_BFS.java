package com.cheehwatang.leetcode;

import java.util.LinkedList;
import java.util.Queue;

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
// The worst-case is when all the nodes are recorded in the queue during the traversal.

public class SameTree_BFS {

    // Approach:
    // Using Breadth-First Search (queue) to traverse the two tree, 'p' and 'q' one node at a time in-sync.
    // If the node is different, return false.
    // If we successfully traverse the both trees, then both are the same tree.

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // For breadth-first search, we use queue, each for their respective trees.
        Queue<TreeNode> queueForP = new LinkedList<>();
        Queue<TreeNode> queueForQ = new LinkedList<>();
        // Put the nodes in their respective queues.
        queueForP.offer(p);
        queueForQ.offer(q);

        // Continue to traverse the tree until no more nodes is in the 'queue', in which case both trees are the same,
        // or until we found two nodes that are different, which we return false.
        while (!queueForP.isEmpty() && !queueForQ.isEmpty()) {
            p = queueForP.poll();
            q = queueForQ.poll();
            // If both nodes are null, move to the next node, as there is no node and no children to add to the queues.
            if (p == null && q == null) continue;
            // If either nodes are null, or their values are different, then return false.
            if (p == null || q == null || p.val != q.val) return false;

            // Add the left and right child to the 'queue'.
            // Note that we leave the node checking to the next round.
            // We add the children regardless, even if the children are null.
            queueForP.offer(p.left);
            queueForQ.offer(q.left);
            queueForP.offer(p.right);
            queueForQ.offer(q.right);
        }
        // If we successfully traverse both trees, then return true.
        return true;
    }
}