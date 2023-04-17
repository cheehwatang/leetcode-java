package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse the whole array once to get the maximum product.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// We use an array with two rows and length of 'n' to keep track of the positive and negative product.

public class MaximumProductSubarray_DynamicProgramming {

    // Approach:
    // Using a 2D array to store the product with the previous element, both maximum and minimum,
    // to account for multiplication of negative integer to previous negative product.

    public int maxProduct(int[] nums) {
        int[][] table = new int[nums.length + 1][2];
        // For maximum product.
        table[0][0] = nums[0];
        // For minimum product, to keep track of the most negative number.
        table[0][1] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int currentNumber = nums[i];
            table[i][0] = Math.max(currentNumber, Math.max(currentNumber * table[i - 1][0], currentNumber * table[i - 1][1]));
            table[i][1] = Math.min(currentNumber, Math.min(currentNumber * table[i - 1][0], currentNumber * table[i - 1][1]));
            max = Math.max(max, table[i][0]);
        }
        return max;
    }
}
