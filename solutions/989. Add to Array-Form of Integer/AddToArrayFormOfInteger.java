package com.cheehwatang.leetcode;

import java.util.LinkedList;
import java.util.List;

// Time Complexity  : O(n | m),
// where 'n' is the length of 'num', and 'm' is the number of digits in 'k'.
// We traverse 'num' once to sum each digit with 'k' to determine the sum.
//
// Space Complexity : O(n | m),
// where 'n' is the length of 'num', and 'm' is the number of digits in 'k'.
// The result list has a length of 'n' or 'm', depending on which number has more digits.

public class AddToArrayFormOfInteger {

    // Approach:
    // We traverse 'num' to add each digit to 'k', starting from the least significant value.
    // For example, num = [1,3,2,6], k = 35.
    // Starting from the right of 'num', we add to k. For each position, we divide 'k' by 10 to shift to the left.
    // - Position 1, k = 35 + 6 = 41. Add 1 to the list, and divide 'k' by 10 to get 4.
    //   Result = [1].
    // - Position 2, k = 4 + 2 = 6. Add 6 to the list, and divide 'k' by 10 to get 0.
    //   Result = [6,1].
    // - Position 3, k = 0 + 3 = 3. Add 3 to the list, and divide 'k' by 10 to get 0.
    //   Result = [3,6,1].
    // - Position 4, k = 0 + 1 = 1. Add 1 to the list, and divide 'k' by 10 to get 0.
    //   Result = [1,3,6,1].

    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new LinkedList<>();
        // Traverse 'num', and add all values to the list including any leftover values from 'k'.
        // Note that we only escape the loop when 'i' reach negative value, or 'k' reaches 0.
        for (int i = num.length - 1; i >= 0 || k > 0; i--) {
            // If we have yet to fully traverse 'num', add the digit to 'k'.
            if (i >= 0) k += num[i];
            // Add the rightmost digit of 'k' to the list.
            result.add(0,k % 10);
            // Shift 'k' by 1 digit.
            k /= 10;
        }
        return result;
    }
}
