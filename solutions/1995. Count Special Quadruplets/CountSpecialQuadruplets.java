package com.cheehwatang.leetcode;

// Time Complexity  : O(n^4),
// where 'n' is the length of 'nums'.
// We traverse 'nums' with 4 nested for-loops to count the special quadruplets.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input size.

public class CountSpecialQuadruplets {

    // Approach:
    // As the length of 'nums' is only 50, we can use Brute Force approach
    // by nesting 4 for-loops to check every possible combination for i < j < k < l,
    // whether it fulfills nums[i] + nums[j] + nums[k] == nums[l].
    // This results in time complexity of O(n^4).

    public int countQuadruplets(int[] nums) {
        int count = 0;
        // Using nested for-loops to check every combination,
        // and count if nums[i] + nums[j] + nums[k] == nums[l].
        for (int l = nums.length - 1; l >= 3; l--)
            for (int k = l - 1; k >= 2; k--)
                for (int j = k - 1; j >= 1; j--)
                    for (int i = j - 1; i >= 0; i--)
                        if (nums[i] + nums[j] + nums[k] == nums[l]) count++;
        return count;
    }
}
