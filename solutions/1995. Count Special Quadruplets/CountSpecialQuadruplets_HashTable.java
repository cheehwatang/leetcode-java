package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

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

public class CountSpecialQuadruplets_HashTable {

    // Approach:
    // Using a HashTable, we can split the brute force O(N^4) time complexity into two separate O(N^2) algorithms.
    // By adjusting nums[i] + nums[j] + nums[k] == nums[l] into nums[i] + nums[j] == nums[l] - nums[k],
    // use the HashTable to store the nums[l] - nums[k], then check each nums[i] + nums[j] if it is in the Hashtable.
    // The HashTable recorded the nums[l] - nums[k] and its frequency.

    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        // From right to left, first make k == n - 2, l == n - 1.
        map.put(nums[n - 1] - nums[n - 2], 1);
        int count = 0;
        // Starting with j = n - 3, traverse left to check if nums[i] + nums[j] is in the HashTable.
        // If found, add the frequency of the found nums[l] - nums[k] to the count.
        for (int j = n - 3; j >= 0; j--) {
            for (int i = j - 1; i >= 0; i--) {
                count += map.getOrDefault(nums[i] + nums[j], 0);
            }
            // Once done with the i and j search, we record the next sets of nums[l] - nums[k].
            int k = j;
            for (int l = n - 1; l > k; l--) {
                map.put(nums[l] - nums[k], map.getOrDefault(nums[l] - nums[k], 0) + 1);
            }
        }
        return count;
    }
}
