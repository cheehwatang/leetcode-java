package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given an integer array 'nums', and a 'queries' array where queries[i] = [val, index], return an integer array where
 * result[i] = sum of even numbers in 'nums' after the i-th query.
 *
 * Note:
 * For each query,
 * 1. nums[index] = nums[index] + val
 * 2. Get the sum of the even numbers in 'nums'.
 *
 *
 * Example 1:
 * Input: nums = [1,3,5,7], queries = [[2,0],[1,3],[-5,1],[1,3]]
 * Output: [0,8,6,-2]
 * Explanation:
 * Query Index 0: Add 2 to nums[0], nums = [3,3,5,7], sum of even numbers = 0.
 * Query Index 1: Add 1 to nums[3], nums = [3,3,5,8], sum of even numbers = 8.
 * Query Index 2: Add -5 to nums[1], nums = [3,-2,5,8], sum of even numbers = -2 + 8 = 6.
 * Query Index 3: Add 1 to nums[3], nums = [3,-2,5,9], sum of even numbers = -2.
 *
 *
 * Example 2:
 * Input : nums = [0], queries = [[3,0]]
 * Output: [0]
 * Explanation:
 * Query Index 0: Add 3 to nums[0], nums = [3], sum of even values = 0.
 *
 *
 * @author Chee Hwa Tang
 */

// Time Complexity : O(N + M)
// Space Complexity: O(M)
// where N is nums.length and M is queries.length.

public class SumOfEvenNumbersAfterQueries {



    // The approach is to get the sum of the even numbers in nums array first.
    // Each time we update nums with queries, 2 things will happen:
    // 1. If previously nums[index] is even, we subtract from the sum.
    // 2. If now updated nums[index] is even, we add to the sum.
    // In both cases, no action is needed when the number (previous and updated) is odd.
    // Then record the sum in the result array.

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        // Get the sum of the even numbers in nums.
        int sumEven = 0;
        for (int number : nums) {
            if (number % 2 == 0) {
                sumEven += number;
            }
        }

        // Traverse the queries array, and update the numbers in nums.
        // Also, perform the operations as 1. and 2. described above.
        int[] result = new int[queries.length];
        int numsIndex;
        for (int i = 0; i < queries.length; i++) {
            numsIndex = queries[i][1];

            // 1. If previously nums[index] is even, we subtract from the sum.
            if (nums[numsIndex] % 2 == 0) {
                sumEven -= nums[numsIndex];
            }

            // 2. If now updated nums[index] is even, we add to the sum.
            nums[numsIndex] += queries[i][0];
            if (nums[numsIndex] % 2 == 0) {
                sumEven += nums[numsIndex];
            }

            // Record the sum in the result array.
            result[i] = sumEven;
        }
        return result;
    }
}
