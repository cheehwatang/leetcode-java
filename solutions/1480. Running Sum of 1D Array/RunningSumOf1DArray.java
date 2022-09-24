package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given an array 'nums', return the running sum of 'nums'.
 *
 *
 * Example 1:
 * Input : nums = [1,2,3]
 * Output: [1,3,6]
 *
 * Example 2:
 * Input : nums = [1,-2,3,-4,5,-6]
 * Output: [1,-1,2,-2,3,-3]
 *
 *
 * @author Chee Hwa Tang
 */

// Time Complexity = O(N)
// Space Complexity = O(1)
// where N = nums.length
public class RunningSumOf1DArray {

    public int[] runningSum(int[] nums) {

        // In-place update of the sum of current number nums[i] with the previous number nums[i-1].
        for (int i = 1; i < nums.length; i++) {
            nums[i] += nums[i-1];
        }
        return nums;
    }
}
