package com.cheehwatang.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

// Time Complexity  : O(n),
// where 'n' is the number of nodes in the Linked List.
// We traverse the whole Linked List twice, once to count the number of nodes, once to remove the Nth node.
//
// Space Complexity : O(1),
// as we are only using fixed variable that do not grow with the length of the Linked List.

public class RemoveNthNodeFromEndOfList_TwoPasses {

    // Approach:
    // Traverse the Singly Linked List twice, first to count the number of nodes,
    // second to traverse the pointer until the Nth node and remove the node.

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Count the number of nodes.
        int size = 0;
        ListNode pointer = head;
        while (pointer != null) {
            size++;
            pointer = pointer.next;
        }

        // 'size' - 'n' is the position of the node to remove, counting from the 'head' with 0-indexed.
        // For example, if the 'size' is 5, and 'n' is 5, we remove the node at position 0, which is the first node.
        int nodeToRemove = size - n;

        // The first node is an edge case as it has no parent node.
        // Thus, we check if we need to remove the first node.
        if (nodeToRemove == 0) return head.next;

        // Using a 'current' pointer for the Nth node from end of list,
        // and a 'parent' pointer for node removal as this is a Singly Linked List.
        ListNode current = head;
        ListNode parent = current;
        // Traverse both pointers until we reach the node to remove.
        while (nodeToRemove > 0) {
            parent = current;
            current = current.next;
            nodeToRemove--;
        }
        // Remove the node from the Singly Linked List.
        parent.next = current.next;

        return head;
    }
}
