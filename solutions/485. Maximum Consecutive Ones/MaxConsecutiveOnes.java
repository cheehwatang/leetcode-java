package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given a binary array 'nums', return the maximum number of consecutive 1's in the array.
 *
 * Note:
 * Use counters to keep track of consecutive ones.
 *
 * Example 1:
 * Input = [1,0,1,0,1,1]
 * Output = 2
 *
 * Example 2:
 * Input = [1,0,1,1,1,1]
 * Output = 4
 *
 * @author Chee Hwa Tang
 */

public class MaxConsecutiveOnes {

    // Time Complexity:  O(N)
    // Space Complexity: O(1)
    // where, N = Length of Array nums.

    public int findMaxConsecutiveOnes(int[] nums) {
        // Catch exception if the input array is null.
        if (nums == null) {
            throw new IllegalArgumentException("Input array is null.");
        }

        // Using 'max' to keep track of maximum consecutive ones, and 'count' to keep track each consecutive ones.

        int max = 0;
        int count = 0;
        for (int n: nums) {
            // Increase count by one, and compare count to max.
            if (n == 1) {
                count++;
                max = Math.max(count, max);
            }
            // Reset count when 0 occurs.
            else {
                count = 0;
            }
        }
        return max;
    }
}
