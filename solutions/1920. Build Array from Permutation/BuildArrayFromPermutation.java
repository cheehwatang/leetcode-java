package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse 'nums' once to record the permutation array.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// We use a result array with the same length as 'nums'.

public class BuildArrayFromPermutation {

    // Approach:
    // As the problem statement, we use a new integer array with the same length as 'nums'
    // and traverse 'nums' to map to result[i] with nums[nums[i]].

    public int[] buildArray(int[] nums) {
        int n = nums.length;

        // New empty array of same length as 'nums'.
        int[] result = new int[n];
        // For each position in the result, map with nums[nums[i]].
        for (int i = 0; i < n; i++) result[i] = nums[nums[i]];
        
        return result;
    }
}
