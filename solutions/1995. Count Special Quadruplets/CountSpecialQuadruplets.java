package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given a 0-indexed array of integers 'nums', return the number of distinct quadruplets (i, j, k, l) such that
 * i < j < k < l and nums[i] + nums[j] + nums[k] == nums[l].
 *
 *
 * Example 1:
 * Input    : nums = [1,2,3,6]
 * Output   : 1
 * Explanation: i = 0 < j = 1 < k = 2 < l = 3, nums[i] + nums[j] + nums[k] = 1 + 2 + 3 == nums[l] = 6.
 *
 *
 * Example 2:
 * Input    : nums = [1,6,2,6,3]
 * Output   : 0
 * Explanation: No quadruplets fulfilling the requirements.
 *
 *
 * Example 3:
 * Input    : nums = [1,1,2,2,4,5]
 * Output   : 4
 * Explanation:
 * - (0,1,2,4): 1 + 1 + 2 == 4
 * - (0,1,3,4): 1 + 1 + 2 == 4
 * - (0,2,3,5): 1 + 2 + 2 == 5
 * - (1,2,3,5): 1 + 2 + 2 == 5
 *
 *
 * @author Chee Hwa Tang
 */

public class CountSpecialQuadruplets {

    // Approach:
    // Brute force, as the length of 'nums' is only 50, with time complexity of O(N^4).
    // Traversing with 4 for-loops, check every possible combination for i < j < k < l,
    // whether it fulfills nums[i] + nums[j] + nums[k] == nums[l].

    public int countQuadruplets(int[] nums) {
        int count = 0;
        for (int l = nums.length - 1; l >= 3; l--)
            for (int k = l - 1; k >= 2; k--)
                for (int j = k - 1; j >= 1; j--)
                    for (int i = j - 1; i >= 0; i--)
                        if (nums[i] + nums[j] + nums[k] == nums[l]) count++;
        return count;
    }
}
