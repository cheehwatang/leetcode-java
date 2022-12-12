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

public class MiddleOfTheLinkedList {

    // Approach:
    // Using Two Pointers to traverse the Singly Linked List to find the middle node:
    // - 'fast' pointer move two nodes at a time,
    // - 'slow' pointer move one node at a time.

    public ListNode middleNode(ListNode head) {

        // Traverse 'fast' two node at a time, and 'slow' one node at a time,
        // until the 'fast' pointer reaches the end of the list.
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // Once 'fast' reaches the end of the list, the 'slow' pointer is at the middle node.
        return slow;
    }
}
