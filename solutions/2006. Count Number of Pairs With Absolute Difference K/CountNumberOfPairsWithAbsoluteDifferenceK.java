package com.cheehwatang.leetcode;

// Time Complexity  : O(n^2),
// where 'n' is the length of 'nums'.
// We traverse 'nums' in a nested for-loop to count the pair with 'k' differences.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input.

public class CountNumberOfPairsWithAbsoluteDifferenceK {

    // Approach:
    // Intuitive and brute force approach to check every combination and count the ones with 'k' difference.

    public int countKDifference(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (Math.abs(nums[i] - nums[j]) == k) count++;
            }
        }
        return count;
    }
}
