package com.cheehwatang.leetcode;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// Note: Remember to set up a ListNode class as the same folder as the reverseList() function.

// Time Complexity  : O(n),
// where 'n' is the length of the linked list.
// We traverse the linked list once with recursion to flip the direction of the linked list.
//
// Space Complexity : O(n),
// where 'n' is the length of the linked list.
// The recursive method call stack is the length of the linked list.

public class ReverseLinkedList_Recursive {

    // Approach:
    // Using a recursive method to traverse the linked list
    // while using a temporary variable 'next' to flip the direction of the two nodes.

    // Main method.
    public ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    // Recursive method.
    private ListNode reverseList(ListNode head, ListNode newHead) {
        if (head == null) return newHead;

        // Flip the direction of the two nodes.
        ListNode next = head.next;
        head.next = newHead;
        newHead = head;

        // Continue to call the recursive method with the next two nodes.
        return reverseList(next, newHead);
    }
}
