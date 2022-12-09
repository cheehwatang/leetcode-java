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
//
// Space Complexity : O(1),
// as we are only using fixed variable that do not grow with the length of the Linked List.

public class RemoveNthNodeFromEndOfList_OnePass {

    // Approach:
    // Using Two Pointers, with the gap in between the 'fast' and 'slow' pointer of 'n' number of nodes,
    // we traverse the 'fast' pointer until the end of the Linked List and remove the node at the 'slow' pointer.

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // To prevent the edge of case removing the first node without a parent, we introduce a parent for the 'head'.
        ListNode start = new ListNode(0);
        start.next = head;

        // With a 'slow' and a 'fast' pointer,
        // we first traverse the 'fast' pointer until the gap of 'n' from the 'slow' pointer.
        ListNode slow = start, fast = start;
        for (int i = 1; i <= n; i++) fast = fast.next;

        // Once we have the gap, we traverse both pointers until 'fast' pointer reaches the end of the list.
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // Remove the node.
        // Note that we started at the 0-th node, the 'slow' pointer is at the parent of the node the be removed.
        slow.next = slow.next.next;

        // Return the head of the Linked List.
        // If the first node is removed, the start.next points to the second node,
        // else, it still points to the 'head'.
        return start.next;
    }
}
