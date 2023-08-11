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
// Note: Remember to set up a ListNode class as the same folder as the reverseBetween() function.

// Time Complexity  : O(n),
// where 'n' is the length of the linked list.
// We traverse the linked list once to flip the linked list nodes in the section.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input size.

public class ReverseLinkedListII {

    // Approach:
    // Use 3 main pointers to reverse the list between 'left' and 'right':
    // 1. 'previous' to mark the node before the section to reverse,
    // 2. 'current' to mark the current head of reversing section,
    // 3. 'next' to mark the next node to reverse.
    //
    // For example: head = [1,2,3,4,5], left = 2, right = 4,
    // We first traverse until the start of the reversing section.
    // Then, 'previous' = 1, 'current' = 2, and 'next' = 3.
    // Each iteration,
    // - head = [1,3,2,4,5], 'previous' = 1, 'current' = 2, and 'next' = 4.
    // - head = [1,4,3,2,5], 'previous' = 1, 'current' = 2, and 'next' = 5.
    //
    // Additionally, we use a 'placeholder' node to mark the head.
    // The reason why 'head' is not used, is because the section to reverse includes the 'head' node,
    // and 'previous' will refer to 'placeholder'.
    // The new head would be the next node to the 'placeholder'.

    public ListNode reverseBetween(ListNode head, int left, int right) {
        // If the list is empty or with only one node, return the head.
        if (head == null || head.next == null) return head;

        // Set up the placeholder node.
        ListNode placeholder = new ListNode(0);
        placeholder.next = head;

        // Traverse the section before 'left'.
        ListNode previous = placeholder;
        for (int i = 0; i < left - 1; i++) {
            previous = previous.next;
        }

        // Set up the 'current' and 'next' pointer.
        ListNode current = previous.next;
        ListNode next = current.next;

        // For each iteration,
        for (int i = 0; i < right - left; i++) {
            // moves the 'next' node to the node after 'previous',
            // by first setting the 'current' next to the node after 'next',
            current.next = next.next;
            // point the 'next' next to the tail of the reversing section,
            next.next = previous.next;
            // set the tail to 'next',
            previous.next = next;
            // and reset 'next' to the node after the head, 'current', of the section.
            next = current.next;
        }
        // Return the head of the list.
        return placeholder.next;
    }
}
