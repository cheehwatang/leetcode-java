package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n^2),
// where 'n' is the length of 'nums'.
// We traverse 'nums' with 2 separate pairs of double nested for-loops,
// first to count the frequency of "nums[l] - nums[k]", and second to check if "nums[i] + nums[j]" is in the HashMap.
//
// Space Complexity : O(n^2),
// where 'n' is the length of 'nums'.
// We use HashMap to count the frequency of "nums[l] - nums[k]", with quadratic time complexity O(n^2).

public class CountSpecialQuadruplets_HashTable {

    // Approach:
    // Using a HashMap, we can split the brute force O(n^4) time complexity into two separate O(n^2) algorithms.
    // By adjusting nums[i] + nums[j] + nums[k] == nums[l] into nums[i] + nums[j] == nums[l] - nums[k],
    // we can use the HashMap to store the nums[l] - nums[k],
    // and then check each nums[i] + nums[j] if it is in the HashMap.

    public int countQuadruplets(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> map = new HashMap<>();

        // From right to left, first make k == n - 2, l == n - 1.
        map.put(nums[n - 1] - nums[n - 2], 1);
        int count = 0;
        // Starting with j = n - 3, traverse left to check if nums[i] + nums[j] is in the HashMap.
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
