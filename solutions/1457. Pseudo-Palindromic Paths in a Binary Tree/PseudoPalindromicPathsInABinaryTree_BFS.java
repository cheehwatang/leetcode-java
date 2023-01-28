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
// where 'n' is the number of nodes in the tree, as we are traversing all the nodes to check every root-to-leaf path
// for the pseudo-palindromic path.
//
// Space Complexity : O(m),
// where 'm' is the breadth of the tree.
// The maximum size of the 'queue' is the breadth of the tree.

public class PseudoPalindromicPathsInABinaryTree_BFS {

    // Note:
    // For any pseudo-palindromic paths, there can be 0 or 1 odd frequency of integers. Example below:
    // Example 1 : [1,3,1] = true, only digit 3 has odd frequency.
    // Example 2 : [1,2,2,1] = true, none has odd frequency.
    // Example 3 : [1,3,4,1] = false, both 3 and 4 has odd frequency, which is more than 1 odd frequency.
    // This is because in any palindromic arrangement, the odd frequency number can be placed in the middle:
    // e.g. [9], [1,3,1], [3,2,3,2,3]
    // Otherwise, if no odd frequency number, then:
    // e.g. [1,2,2,1], [2,2]
    // Thus, there can only be at most a number of an odd frequency for the path to be pseudo-palindromic.

    // Note:
    // For the recording of the frequency of the digits, we have few methods to use, either HashMap or Counting Array.
    // Alternatively, we can use Bitmasking on an integer to store if the digit has an odd or even frequency.
    // Since we only concerned if there are 0 or 1 odd frequency,
    // we can keep flipping the 0s and 1s as we traverse from root to leaf.
    //
    // For each digit, we can store the frequency in an integer by shifting a 1 to the left by the position of digit.
    // For this, we use the bitwise shift left operator, <<, and the bitwise XOR operator, ^.
    // For example in Binary Numbers: path = [1 -> 4 -> 6 -> 4],
    // 1 << 1 == 10,
    // 1 << 4 == 10000,
    // 1 << 6 == 1000000,
    // (1 << 1) ^ (1 << 4) ^ (1 << 6) ^ (1 << 4) =
    // 10       ^ 10000    ^ 1000000  ^ 10000    = 1000010.
    //
    // To check if the path has only 1 odd frequency, we use a bitwise AND operator, &.
    // Using the above example, 1000010 & (1000010 - 1) == 1000010 & 1000001 == 1000000, which is more than 0.
    // If path = [1 -> 4 -> 1], then 10000 & (10000 - 1) == 10000 & 1111 == 0.
    // The path is pseudo-palindromic if n & (n - 1) == 0.

    // Approach:
    // Using breadth-first search to traverse the binary tree and
    // check every root-to-leaf path if it is pseudo-palindromic.
    // When we found a child node, check if the path is pseudo-palindromic.

    public int pseudoPalindromicPaths (TreeNode root) {
        if (root == null) return 0;

        // Breadth-first search is implemented using 'queue',
        // for the nodes in 'nodeQueue' and the frequency in 'pathQueue'.
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        Queue<Integer> pathQueue = new LinkedList<>();

        // Each time pushing a node into the 'nodeQueue',
        // push the frequency of digits in the path of the node to the 'pathQueue'.
        nodeQueue.offer(root);
        pathQueue.offer(1 << root.val);

        int result = 0;

        // Continue to traverse the tree until all the nodes are visited (queue is empty).
        while (!nodeQueue.isEmpty()) {
            // Get the current node and path of the node.
            TreeNode currentNode = nodeQueue.poll();
            int currentPath = pathQueue.poll();

            // Once we reach a leaf node, increase the result count by 1 if it is a pseudo-palindromic path.
            if (currentNode.left == null && currentNode.right == null)
                if ((currentPath & (currentPath - 1)) == 0) result++;

            // If there are left or right child nodes,
            // add them to the 'nodeQueue' as well as their path to 'pathQueue'.
            if (currentNode.left != null) {
                nodeQueue.offer(currentNode.left);
                pathQueue.offer(currentPath ^ (1 << currentNode.left.val));
            }
            if (currentNode.right != null) {
                nodeQueue.offer(currentNode.right);
                pathQueue.offer(currentPath ^ (1 << currentNode.right.val));
            }
        }
        // Once we fully traverse the tree and checked every root-to-leaf path, return the result.
        return result;
    }
}
