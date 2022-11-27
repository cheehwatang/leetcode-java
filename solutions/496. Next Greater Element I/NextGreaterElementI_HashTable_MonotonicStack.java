package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums2'.
// Do note that we also traverse 'nums1' once, but it is less than O(n) as 'nums1' is a subset of 'nums2'.
// For the stack, it has a maximum time complexity of O(n) as well, imagine pushing and popping the whole 'nums2'.
// Thus, strictly speaking, it would be O(3 * n), which simplifies to O(n).
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums2'.
// We use a HashMap and a Stack, together of which stores all the elements in 'nums2'.

public class NextGreaterElementI_HashTable_MonotonicStack {

    // Approach:
    // Using a decreasing monotonic stack to get the next greater number,
    // while storing the element in 'nums2' and its next greater number into the HashMap.
    // For any decreasing sequence followed by a greater number (e.g. [4,3,2,1,5]),
    // the element 5 is the greater number for all its previous elements.
    // Likewise, if we have numbers greater than 5 in the array (e.g. [7,6,4,3,2,1,5]),
    // then element 5 is the greater number for the elements up to the element that is greater than 5.
    // As such, when we are popping the elements 1, 2, 3 and 4 from the stack,
    // we record the element, and the greater number (in example, 5) into a HashMap.
    // Once we have done this monotonic stack and hash table process for 'nums2',
    // we can traverse 'nums1' to check if the elements is in the HashMap,
    // take the greater number if found, or -1 if it is not in the HashMap.
    // Note: the elements not found in the HashMap are the elements remained in the monotonic stack,
    // which are the elements that do not have greater number to its right in the array.

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        // Build the decreasing monotonic stack,
        // while putting the elements that are popped from the stack into the HashMap.
        for (int number : nums2) {
            // If we found a greater number, then continue to pop and add to HashMap until the top of stack is greater.
            while (!stack.isEmpty() && number > stack.peek()) {
                map.put(stack.pop(), number);
            }
            // Push the greater number to the stack.
            stack.push(number);
        }
        // Modify 'nums1' in-place, either with the greater number as recorded in the HashMap, or -1 if not found.
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = map.getOrDefault(nums1[i], -1);
        }
        // Return 'nums1' as the answer to the queries.
        return nums1;
    }
}
