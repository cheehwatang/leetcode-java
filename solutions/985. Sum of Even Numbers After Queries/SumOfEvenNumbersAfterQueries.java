package com.cheehwatang.leetcode;

// Time Complexity : O(n + m),
// where 'n' is the length of 'nums', and 'm' is the length of 'queries'.
// We traverse the 'nums' array once to get the even sum,
// and we traverse the 'queries' array once to get the even sum for each query.
//
// Space Complexity: O(m),
// where 'm' is the length of 'queries'.
// The result array has the same length as the 'queries'.

public class SumOfEvenNumbersAfterQueries {

    // Approach:
    // First, we get the sum of the even numbers in 'nums' array first.
    // Each time we update nums with queries, 2 things will happen:
    // 1. If previously nums[index] is even, we subtract from the sum.
    // 2. If now updated nums[index] is even, we add to the sum.
    // In both cases, no action is needed when the number (previous and updated) is odd.
    // Once updated, we record the sum in the result array.

    public int[] sumEvenAfterQueries(int[] nums, int[][] queries) {
        // Get the sum of the even numbers in 'nums'.
        int evenSum = 0;
        for (int number : nums) {
            if (number % 2 == 0) evenSum += number;
        }

        // Traverse the queries array, and update the numbers in 'nums'.
        // Also, perform the operations as situation 1 and situation 2 described above.
        int[] result = new int[queries.length];
        int numsIndex;
        for (int i = 0; i < queries.length; i++) {
            numsIndex = queries[i][1];

            // 1. If previously the 'nums[index]' is even, we subtract from the sum.
            if (nums[numsIndex] % 2 == 0) {
                evenSum -= nums[numsIndex];
            }

            // 2. If the updated 'nums[index]' is even, we add to the sum.
            nums[numsIndex] += queries[i][0];
            if (nums[numsIndex] % 2 == 0) {
                evenSum += nums[numsIndex];
            }

            // Record the sum in the result array.
            result[i] = evenSum;
        }
        return result;
    }
}
