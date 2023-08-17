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
// We traverse the linked list once while flipping the direction of the linked list.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent on the length of the linked list.

public class ReverseLinkedList_Iterative {

    // Approach:
    // Traverse the linked list, while using a temporary variable 'next' to flip the direction of the two nodes.

    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }
}
