package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse 'nums' to get the prefix sum and find the number of subarray that sum to 'k'.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// The maximum size of the HashMap grows linearly with the length of 'nums',
// with the worst-case when all prefix sum recorded are unique.

public class SubarraySumEqualsK {

    // Approach:
    // When it comes to Sum of Subarray, the use of Prefix Sum is especially important.
    // Prefix Sum is the sum of the current integer with the previous integer in the array (Prefix).
    // Example: nums = [1,2,3,4,5] has the prefix sum array of prefixSum = [1,3,6,10,15],
    //          where the nums[0] + 1 = 1, nums[1] + nums[0] = 2 + 1 = 3, nums[2] + nums[1] = 3 + 3 = 6, and so on.
    // Using the example above, we can determine the subarray sum of any subarray using prefix sum.
    // To get the subarray sum of nums[2] to nums[4] == 3 + 4 + 5 == 12,
    // we can get from prefixSum[5] - prefixSum[1] == 15 - 3 == 12.
    //
    // With Prefix Sum, we can evaluate if subarray sum is equal to k by prefixSum[j] - prefixSum[i] == k.
    // Shifting the equation around we get prefixSum[j] - k == prefixSum[i], where j > i.
    // Thus, we can store the prefix sum of i-th element in 'nums' in a Hashtable, and check for each j-th element
    // if prefixSum[j] - k is in the Hashtable.

    public int subarraySum(int[] nums, int k) {

        // Store the frequency as there could be multiple subarrays with the same prefix sum.
        Map<Integer, Integer> map = new HashMap<>();
        // The first element for (i - 1) is always 0.
        map.put(0, 1);

        int prefixSum = 0;
        int count = 0;
        for (int num : nums) {
            prefixSum += num;
            // Add to the count if prefixSum - k is found.
            count += map.getOrDefault(prefixSum - k, 0);
            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }
        return count;
    }
}
