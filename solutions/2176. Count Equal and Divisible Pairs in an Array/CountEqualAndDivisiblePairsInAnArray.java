package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given an array of integers 'nums' and an integer 'k',
 * return the number of pairs where nums[i] == nums[j], and i * j is divisible by k.
 *
 *
 * Example 1:
 * Input    : nums = [1,2,3,3,2,1], k = 2
 * Output   : 3
 * Explanation:
 * The pairs with same value, and i * j is divisible by k.
 * - [1*,2,3,3,2,1*], i * j = 0 * 5 = 0 divisible by 2.
 * - [1,2*,3,3,2*,1], i * j = 1 * 4 = 4 divisible by 2.
 * - [1,2,3*,3*,2,1], i * j = 2 * 3 = 6 divisible by 2.
 *
 *
 * Example 2:
 * Input    : nums = [1,2,3], k = 1
 * Output   : 0
 * Explanation: No repeated numbers.
 *
 *
 * @author Chee Hwa Tang
 */

public class CountEqualAndDivisiblePairsInAnArray {

    public int countPairs(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                // Check if i and j meets the condition.
                if (nums[i] == nums[j] && (i * j) % k == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
