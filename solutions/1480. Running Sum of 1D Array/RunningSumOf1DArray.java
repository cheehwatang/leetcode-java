package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse the 'nums' array once to get the running sum.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of 'nums'.

public class RunningSumOf1DArray {

    // Approach:
    // Starting at index 1,
    // continue to add the previous number while replacing the number in 'nums' array in-place.

    public int[] runningSum(int[] nums) {
        // In-place update of the sum of current number nums[i] with the previous number nums[i-1].
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
