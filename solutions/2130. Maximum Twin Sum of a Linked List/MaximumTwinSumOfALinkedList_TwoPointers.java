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
// Note: Remember to set up a ListNode class as the same folder as the pairSum() function.

// Time Complexity  : O(n),
// where 'n' is the length of the linked list.
// We traverse the linked list once to record the values into an ArrayList,
// and traverse the ArrayList using two pointers to get the max sum of the twin.
//
// Space Complexity : O(n),
// where 'n' is the length of the linked list.
// The ArrayList used to record the values of the linked list nodes are of size 'n'.

public class MaximumTwinSumOfALinkedList_TwoPointers {

    // Approach:
    // Traverse the linked list once to record the values into an ArrayList.
    // Then, we use two pointers 'start' and 'end' to traverse the ArrayList from both directions,
    // and get the sum of the twin nodes value, and determine the max sum.

    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList<>();

        // Use 'current' pointer to traverse the linked list once to record the values.
        ListNode current = head;
        while (current != null) {
            list.add(current.val);
            current = current.next;
        }

        int start = 0;
        int end = list.size() - 1;
        int max = 0;
        // Traverse the ArrayList from both directions.
        while (start < end) {
            // Compare and get the max sum.
            max = Math.max(max, list.get(start) + list.get(end));
            start++;
            end--;
        }
        return max;
    }
}
