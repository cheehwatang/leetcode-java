package com.cheehwatang.leetcode;

import java.util.Arrays;
import java.util.Stack;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse 'nums' once,
// as well as the Arrays.fill() function which traverses the result array once to change all the elements to -1.
// Additionally, there are a maximum of O(3 * n), where we are pushing and pop through the elements in the 3 stack.
// Thus, in actual it is O(5 * n), which simplifies to O(n).
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// This is due to the result array of length 'n', and the maximum size of the stack of size 'n'.

public class NextGreaterElementIV_MonotonicStack {

    // Approach:
    // Use two monotonic stacks to get the second greater number,
    // with the first stack checking for the first greater number,
    // followed by the second stack checking for the second greater number.
    // As we need to keep the sequence of the elements in the first stack
    // before transferring the elements to the second stack, we need a temporary stack to help maintain the ordering.
    // If not, then we are reversing the order by popping from the first stack and pushing into the second stack.

    public int[] secondGreaterElement(int[] nums) {
        int n = nums.length;

        // Set up the result array with -1, as the numbers without the second greater number will be not updated,
        // and need to remain as -1.
        int[] result = new int[n];
        Arrays.fill(result, -1);

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        Stack<Integer> temp = new Stack<>();

        // Traverse through every element in 'nums'.
        // Note that for all the elements in the stack, we are storing the index rather than the number itself.
        for (int i = 0; i < n; i++) {
            // Firstly, check the second stack (stack2).
            // As the numbers already have one greater number, this check will get the second greater number.
            while (!stack2.isEmpty() && nums[i] > nums[stack2.peek()])
                result[stack2.pop()] = nums[i];
            // Secondly, check the first stack (stack1) if nums[i] is the first greater number of any elements.
            // As we are popping the elements, the order is reversed.
            // So, first push to the 'temp' stack, then pop from 'temp' and push to 'stack2'.
            while (!stack1.isEmpty() && nums[i] > nums[stack1.peek()])
                temp.push(stack1.pop());
            while (!temp.isEmpty())
                stack2.push(temp.pop());
            // Once all checks are made, push the current index 'i' to 'stack1'.
            stack1.push(i);
        }
        // Once completely checked all elements, return the result.
        return result;
    }
}
