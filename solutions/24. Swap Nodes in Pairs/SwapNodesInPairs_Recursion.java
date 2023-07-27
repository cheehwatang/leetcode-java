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
// Note: Remember to set up a ListNode class as the same folder as the swapPairs() function.

// Time Complexity  : O(n),
// where 'n' is the number of nodes in the linked list.
// With recursion, the recursive call stack has a height that grows linearly
// with the input linked list.
//
// Space Complexity : O(n),
// where 'n' is the number of nodes in the linked list.
// While the auxiliary space used is independent on the length of the linked list,
// the recursive call stack results in O(n).

public class SwapNodesInPairs_Recursion {

    // Approach:
    // Using recursion, swap the ListNodes in the pair and return the new first ListNode of the pair,
    // and link the second node (head.next) to the next pair by calling the swapPairs() function
    // with the first node of the next pair (head.next.next).

    public ListNode swapPairs(ListNode head) {
        // If there is no pair, return head.
        if (head == null || head.next == null) return head;

        // Swap the ListNodes in the pair.
        ListNode newHead = head.next;
        // Link the second node ('head' ListNode) to the next pair,
        // by recursively calling the swapPairs() function with the head of the next pair.
        head.next = swapPairs(head.next.next);
        newHead.next = head;

        // Return the first node of the pair.
        return newHead;
    }
}
