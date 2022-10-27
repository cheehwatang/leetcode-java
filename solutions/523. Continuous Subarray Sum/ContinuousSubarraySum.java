package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem:
 * Given an array of integers 'nums' and an integer 'k',
 * return true if nums has a subarray of size at least two whose elements sum up to a multiple of 'k', or false otherwise.
 * Note that 0 is a multiple of 'k'.
 *
 *
 * Example 1:
 * Input    : nums = [1,2,3,4,5], k = 4
 * Output   : true
 * Explanation: [3,4,5] is a subarray of size more than 2 whose elements sum up to 12, which is a multiple of 4.
 *
 *
 * Example 2:
 * Input    : nums = [1,2,3,4,5], k = 8
 * Output   : false
 * Explanation: No subarray sum is a multiple of 8.
 *
 *
 * @author Chee Hwa Tang
 */

public class ContinuousSubarraySum {

    // Approach:
    // Using Prefix Sum and Hash Table.
    // This problem is similar to Problem 560. Subarray Sum Equals K, which a few adjustment.
    // First:
    // Prefix Sum is the sum of the current integer with the previous integer in the array (Prefix).
    // Example: nums = [1,2,3,4,5] has the prefix sum array of prefixSum = [1,3,6,10,15],
    //          where the nums[0] + 1 = 1, nums[1] + nums[0] = 2 + 1 = 3, nums[2] + nums[1] = 3 + 3 = 6, and so on.
    // Using the example above, we can determine the subarray sum of any subarray using prefix sum.
    // To get the subarray sum of nums[2] to nums[4] == 3 + 4 + 5 == 12,
    // we can get from prefixSum[5] - prefixSum[1] == 15 - 3 == 12.
    //
    // Second:
    // By using modulus of k for each prefix, we can check if the prefix sum is a multiple of k, when "number % k == 0".
    // If two prefix sums modulus k is the same, it means that prefixSum1 - prefixSum2 == n * k, without any remainder.
    //
    // For the size of at least 2, we can use a temporary variable to keep the previous prefix sum,
    // before adding into the Hashtable after an iteration.

    public boolean checkSubarraySum(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int currentSum = 0;
        int previousSum = 0;
        for (int integer : nums) {
            // Prefix sum with modulus k.
            currentSum = (currentSum + integer) % k;

            // When the prefix sum if found in the Hash Set, we have found the subarray with sum with multiple of k.
            if (set.contains(currentSum)) return true;

            // Previous sum ensures the size found is at least 2.
            set.add(previousSum);

            previousSum = currentSum;
        }
        return false;
    }
}
