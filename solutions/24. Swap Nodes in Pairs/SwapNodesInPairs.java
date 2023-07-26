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
// Note: Remember to set up a ListNode class as the same folder as the swapPairs() function.

// Time Complexity  : O(n),
// where 'n' is the number of nodes in the linked list.
// We traverse the linked list once to swap the node pairs.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent on the length of the linked list.

public class SwapNodesInPairs {

    // Approach:
    // Traverse the linked list, using a 'current' ListNode to keep track of the first node of the pair, and
    // a 'parent' ListNode to keep track of the parent node of the pair.
    // For each pair, perform the swap using a 'temp' ListNode to store the second node of the pair.
    // Then, link the 'parent' ListNode to the first node ('temp') of the swapped pair.
    //
    // Note: We need to handle the edge case, for the first pair when the 'parent' ListNode is null,
    //       and set the new head.

    public ListNode swapPairs(ListNode head) {
        // If there is no pair, return head.
        if (head == null || head.next == null) return head;

        // 'current' pointer to traverse the linked list.
        ListNode current = head;
        // Start with the 'parent' ListNode as null.
        ListNode parent = null;
        // Continue to traverse and swap nodes if there are pairs.
        while(current != null && current.next != null) {
            // Using the 'temp' variable to swap nodes.
            // Note: After swapping, 'temp' becomes the first node of the pair,
            //       and 'current' becomes the second node of the pair.
            ListNode temp = current.next;
            current.next = temp.next;
            temp.next = current;

            // Handle the first pair, when the 'parent' is null, set the 'temp' as the new head of the linked list.
            if (parent == null) {
                head = temp;
            } else {
                // Else, link the 'parent' ListNode with the new first node after swapping.
                parent.next = temp;
            }

            // Shift the pointers accordingly, and continue to traverse and swap the elements.
            parent = current;
            current = current.next;
        }
        return head;
    }
}
