package com.cheehwatang.leetcode;

// Time Complexity  : O(n + k),
// where 'n' is the length of 'nums'.
// We traverse 'nums' once and the counting array of size 'k' once.
//
// Space Complexity : O(k),
// as we create a counting array of size 'k'.

public class SubarraySumsDivisibleByK_Counting {

    // Approach:
    // When it comes to Sum of Subarray, the use of Prefix Sum is especially important.
    // Prefix Sum is the sum of the current integer with the previous integer in the array (Prefix).
    // Example: nums = [1,2,3,4,5] has the prefix sum array of prefixSum = [1,3,6,10,15],
    //          where the nums[0] + 1 = 1, nums[1] + nums[0] = 2 + 1 = 3, nums[2] + nums[1] = 3 + 3 = 6, and so on.
    // Using the example above, we can determine the subarray sum of any subarray using prefix sum.
    // To get the subarray sum of nums[2] to nums[4] == 3 + 4 + 5 == 12,
    // we can get from prefixSum[5] - prefixSum[1] == 15 - 3 == 12.
    //
    // With Prefix Sum, we can evaluate if any subarray sum is divisible by 'k',
    // if two prefix sums have the same remainder of 'k'.
    // For Example, nums = [4,2,3], k = 5,
    // with two prefix sum, 4 [4] and 9 [4,2,3].
    // Both remainders are 4, with the subarray between the prefix sum 9 [4,2,3] - 4 [4] == 5 [2,3], which is divisible by 5.

    public int subarraysDivByK(int[] nums, int k) {

        // Use counting array to record the frequency of all the prefix sum remainders.
        int[] counting = new int[k];
        for (int i = 0, remainder = 0; i < nums.length; i++) {
            // Note that the integer in 'nums' can be negative.
            // Thus, we need to adjust the negative remainder to positive remainder.
            // Below accounts for both negative and positive remainders.
            // We can also check if the remainder is negative, then add a 'k' to make the remainder positive.
            // For Example, nums = [-2,3,2], k = 5,
            // remainder for the prefix sum of [-2,1,3] are -2, 1 and 3 respectively.
            // We know that [3,2] sum to 5, which is divisible by 5.
            // After converting -2 to 3, by adding 5, it has the same remainder with prefix sum 3.
            remainder = ((remainder + nums[i]) % k + k) % k;
            counting[remainder]++;
        }

        // The result contains all the prefix sum with remainder 0,
        // as all the prefix sum with remainder of 0 is itself divisible by 'k'.
        // However, do note that the prefix sum with remainder 0 also able to form subarray sums that is divisible by 'k'
        // with one another, which will be calculated next.
        // For Example: nums = [5,5,5,5], k = 5,
        // The prefix sum of [5,10,15,20] are themselves divisible by 5, while also forming subarray sums divisible by 5
        // with 10 [5,5] - 5 [5] == 5, 15 [5,5,5] - 5 [5] == 10, etc.
        int result = counting[0];

        // The prefix sums with the same remainder can form subarray sums that is divisible by 'k' with each other.
        // For each remainder, the number of subarray that is divisible by 'k' is the number of combinations from the frequency.
        // Equation for the number of combinations of n items is n * "(n - 1) / 2".
        for (int frequency : counting)
            result += frequency * (frequency - 1) / 2;

        return result;
    }
}