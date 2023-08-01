package com.cheehwatang.leetcode;

import java.util.Stack;

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
// We traverse the linked list to get the max sum of the twin.
//
// Space Complexity : O(n),
// where 'n' is the length of the linked list.
// The Stack used to record the values of the linked list nodes has a maximum size of 'n / 2'.

public class MaximumTwinSumOfALinkedList_TwoPointers_Stack {

    // Approach:
    // Using a 'slow' and 'fast' pointer, we traverse the linked list with 'slow' moving one node at a time,
    // and 'fast' moving two nodes at a time, we can determine the midpoint of the linked list.
    // For the first half, while the 'fast' pointer not reach the end of the linked list,
    // we record the values of the 'slow' pointer in a Stack.
    // Once the 'fast' pointer reaches the end, we continue to traverse with the 'slow' pointer,
    // but now we are popping the value from the stack and sum with the 'slow' pointer value.
    // Continue to determine the maximum twin nodes value sum.

    public int pairSum(ListNode head) {
        int max = 0;
        Stack<Integer> stack = new Stack<>();
        // Both the 'slow' and 'fast' pointers start at the first node.
        ListNode slow = head;
        ListNode fast = head;
        // Traverse the linked list with the 'slow' and 'fast' pointer.
        while (slow != null) {
            // If 'fast' is not at the end of the linked list,
            if (fast != null) {
                // add the 'slow' pointer value to the stack.
                stack.push(slow.val);
                // As we know that 'n' is even, we can skip checking if fast.next is null.
                // The constraint ensures that fast.next.next does not throw NullPointerException.
                fast = fast.next.next;
            }
            // If 'fast' reaches the end of the linked list,
            else {
                // Pop the value from the stack and sum with the value at the 'slow' pointer.
                max = Math.max(max, stack.pop() + slow.val);
            }
            // Move the 'slow' pointer forward.
            slow = slow.next;
        }
        return max;
    }
}
