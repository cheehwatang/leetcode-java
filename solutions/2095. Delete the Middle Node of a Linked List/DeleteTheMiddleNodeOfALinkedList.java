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
// We traverse the whole Linked List once.
// In actual case, it would be O(n/2) as we are moving the 'fast' pointers two nodes at a time, but simplify as O(n).
//
// Space Complexity : O(1),
// as we are only using fixed variable that do not grow with the length of the Linked List.

public class DeleteTheMiddleNodeOfALinkedList {

    // Approach:
    // Using Two Pointers to traverse the Singly Linked List to find the middle node:
    // - 'fast' pointer move two nodes at a time,
    // - 'slow' pointer move one node at a time.

    public ListNode deleteMiddle(ListNode head) {
        // If the Linked List has only one node, the node is deleted, thus return null.
        if (head.next == null) return null;

        ListNode fast = head;
        ListNode slow = head;
        // An additional 'parent' pointer to keep track of the parent node of 'slow'.
        // Since this is a Singly Linked List, there is no way to return to the previous node.
        // We need the previous node to delete a node from the Singly Linked List.
        ListNode parent = slow;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            parent = slow;
            slow = slow.next;
        }
        // Remove the middle node from the Singly Linked List.
        parent.next = slow.next;

        return head;
    }
}
