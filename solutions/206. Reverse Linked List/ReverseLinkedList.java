package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;

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
// We traverse the linked list once to record the values into an ArrayList.
// Then, we traverse the ArrayList to replace the values in the linked list.
//
// Space Complexity : O(n),
// where 'n' is the length of the linked list.
// The ArrayList used has a size equal to the length of the linked list.

public class ReverseLinkedList {

    // Approach:
    // Traverse the linked list once to record the values into an ArrayList.
    // Then, traverse the linked list a second time, while traversing the ArrayList in reverse position,
    // and replace the node values of the linked list.

    public ListNode reverseList(ListNode head) {
        // If the linked list has no node or only has one node, return the head.
        if (head == null || head.next == null) return head;

        // Record the values of the linked list into the ArrayList.
        List<Integer> list = new ArrayList<>();
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        // Traverse the linked list again, while replace the node value from the ArrayList in reverse.
        current = head;
        for (int i = list.size() - 1; i >= 0; i--) {
            current.val = list.get(i);
            current = current.next;
        }

        return head;
    }
}
