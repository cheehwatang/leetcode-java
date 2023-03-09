package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 i * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
// Note: Remember to set up a ListNode class as the same folder.

// Time Complexity  : O(n),
// where 'n' is the number of nodes in the singly linked list.
// We traverse every node in the singly linked list when we first record the node values into the ArrayList.
// Then, we traverse the ArrayList of 'n' elements while performing monotonic stack.
//
// Space Complexity : O(n),
// where 'n' is the number of nodes in the singly linked list.
// The maximum size of the stack is all the nodes in the singly linked list.
// The size of the ArrayList and the result integer array is of size 'n'.

public class NextGreaterNodeInLinkedList {

    // Approach:
    // First, we traverse the singly linked list to record the node values into an ArrayList
    // for easy retrieval of values and to get the size of the linked list.
    // Since the result is in integer array, we need the size before we can make the empty result array.
    //
    // Then, we use a descending monotonic stack to record the next greater node value for each node.
    // For any decreasing sequence in a stack followed by a greater number (e.g. bottom->[4,3,2,1,5]<-top),
    // the element 5 is the greater number for all its previous elements.
    // Likewise, if we have numbers greater than 5 in the stack (e.g. bottom->[7,6,4,3,2,1,5]<-top),
    // then element 5 is the greater number for the elements up to the element that is greater than 5.
    // As such, when we are popping the elements 1, 2, 3 and 4 from the stack,
    // we record the next greater number for each of the elements popped to be 5,
    // resulting in the stack = bottom->[7,6,5]<-top.
    // We continue this descending monotonic stack algorithm for all the elements in the ArrayList,
    // recording the next greater element for each element popped.
    // The remaining numbers in the monotonic stack remains as the default 0 value in the result integer array.

    public int[] nextLargerNodes(ListNode head) {
        List<Integer> list = new ArrayList<>();
        // Record the node values of the singly linked list into an ArrayList.
        for (ListNode current = head; current != null; current = current.next) {
            list.add(current.val);
        }
        // With the ArrayList, we can easily form the result integer array using the size of the ArrayList.
        int[] result = new int[list.size()];

        // Strictly decreasing monotonic stack.
        // Do note that we are storing the index in the stack, but not the element value,
        // as we need the index to update the 'result' integer array with the greater number.
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < list.size(); i++){
            // While the element is greater than the top of the stack, pop and record the greater element in the result.
            while (!stack.isEmpty() && list.get(stack.peek()) < list.get(i)) {
                // As stack.pop() function returns the index and remove it from the stack,
                // we can use it straight into the 'result' array, rather than an additional variable for the index.
                result[stack.pop()] = list.get(i);
            }
            // Push the index of the greater element into the stack and continue.
            stack.push(i);
        }
        // Once all the elements checked, return the result.
        // The elements without next greater element remains as the default 0 in the integer array.
        return result;
    }
}
