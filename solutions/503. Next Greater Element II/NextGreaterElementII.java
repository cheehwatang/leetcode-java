package com.cheehwatang.leetcode;

import java.util.Arrays;
import java.util.Stack;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse 'nums' twice to get the greater number for all the elements.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// We use an array of length 'n' to store the result.

public class NextGreaterElementII {

    // Approach:
    // Using monotonic stack and loop through 'nums' twice to get the greater number for all the elements.
    // The second loop is to check if the next greater element is positioned at the earlier part of the array.

    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;

        // Use a 'result' array and make all the elements in it to be -1,
        // for the elements with the greatest value will not be updated when we loop through.
        // Additionally, do note that the elements are not unique integers,
        // so you would need to account for the case where all elements in 'nums' is the same integer.
        int[] result = new int[n];
        Arrays.fill(result, -1);

        // Strictly decreasing monotonic stack, and loop through 'nums' twice with "i % n".
        // Do note that we are storing the index in the stack, but not the integer,
        // as we need the index to update the 'result' array with the greater number.
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            // While the element is greater than the top of the stack, pop and record the greater element in the result.
            while (!stack.isEmpty() && nums[i % n] > nums[stack.peek()]) {
                // As stack.pop() function returns the index and remove it from the stack,
                // we can use it straight into the 'result' array, rather than an additional variable for the index.
                result[stack.pop()] = nums[i % n];
            }
            // Push the greater element into the stack and continue.
            stack.push(i % n);
        }
        // The elements with greater number are updated accordingly, and those greatest number remains as -1 in 'result'.
        return result;
    }
}
