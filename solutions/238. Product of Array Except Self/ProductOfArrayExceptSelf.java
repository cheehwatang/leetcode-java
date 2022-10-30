package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given an array of integers 'nums', return an array 'answer' such that 'answer[i]' is equal to the product of
 * all the elements of 'nums' except for 'nums[i]'.
 * Note: Write an algorithm with O(n) time complexity without using the division operation.
 *
 *
 * Example 1:
 * Input    : nums = [1,2,3,4]
 * Output   : [24,12,8,6]
 * Explanation : 2 * 3 * 4 = 24, 1 * 3 * 4 = 12, 1 * 2 * 4 = 8, 1 * 2 * 3 = 6.
 *
 *
 * Example 2:
 * Input    : nums = [0,1,2,3]
 * Output   : [6,0,0,0]
 * Explanation : 1 * 2 * 3 = 6, 0 * 2 * 3 = 0, 0 * 1 * 3 = 0, 0 * 1 * 2 = 0.
 *
 *
 * @author Chee Hwa Tang
 */

public class ProductOfArrayExceptSelf {

    // Approach:
    // To exclude the current number from the product, we can multiply the prefix product and the suffix product.
    // With Example 1 above, to check for nums[1], we can multiply the prefix of 1, with suffix of 3 * 4 = 12.

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        // Option to use a variable 'prefix' to store, but here we use the result array for simplicity.
        result[0] = 1;
        // Note that index 0 has no prefix (or 1 as we are multiplying).
        for (int i = 1; i < n; i++) {
            // Note here that we only multiply with nums[i - 1] for each result[i] to skip the i-th element.
            result[i] = result[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        // Note that index n - 1 has no suffix.
        for (int i = n - 2; i >= 0; i--) {
            // For suffix, we use nums[i + 1] instead, traversing from right to left.
            suffix *= nums[i + 1];
            result[i] *= suffix;
        }
        return result;
    }
}
