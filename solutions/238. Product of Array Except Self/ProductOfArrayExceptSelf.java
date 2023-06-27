package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse 'nums' array twice, resulting in time complexity of O(n).
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// The 'result' array has the same size as the input 'nums' array.

public class ProductOfArrayExceptSelf {

    // Approach:
    // To exclude the current number from the product, we can multiply the prefix product and the suffix product.
    // The prefix product is the product of all the integers to the left of the current number, and
    // the suffix product is the product of all the integers to the right of the current number.
    //
    // With that, we need to traverse the 'nums' array twice.
    // Once from left to right to determine the prefix product for each position in 'nums', and
    // once from right to left to determine the suffix product for each position in 'nums'.
    // Note that we have to start the prefix and suffix with 1, not 0, as we are performing multiplication.

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];

        // Option to use a variable 'prefix' to store, but here we use the result array for simplicity.
        result[0] = 1;
        // We start at index 1 as index 0 has no prefix.
        for (int i = 1; i < n; i++) {
            // Note here that we only multiply with nums[i - 1] for each result[i] to skip the i-th element.
            result[i] = result[i - 1] * nums[i - 1];
        }
        int suffix = 1;
        // We start at index 'n - 2' as index 'n - 1' has no suffix.
        for (int i = n - 2; i >= 0; i--) {
            // For suffix, we use nums[i + 1] instead, traversing from right to left.
            suffix *= nums[i + 1];
            result[i] *= suffix;
        }
        return result;
    }
}
