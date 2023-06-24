package com.cheehwatang.leetcode;

// Time Complexity  : O(n^2),
// where 'n' is the length of 'nums'.
// We traverse 'nums' with two nested for-loops.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the inputs.

public class CountEqualAndDivisiblePairsInAnArray {

    // Approach:
    // The intuitive and the brute force approach is to traverse 'nums' with two nested for-loops,
    // checking each combination and count if the requirements are met:
    // 1. nums[i] == nums[j],
    // 2. i * j is divisible by k.

    public int countPairs(int[] nums, int k) {
        int n = nums.length;

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                // Check if i and j meet the condition.
                if (nums[i] == nums[j] && (i * j) % k == 0) count++;
            }
        }
        return count;
    }
}
