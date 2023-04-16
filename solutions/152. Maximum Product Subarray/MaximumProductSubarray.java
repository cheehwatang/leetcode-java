package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// The 'left' and 'right' pointers traverse the whole array to get the maximum product.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input size.

public class MaximumProductSubarray {

    // Approach:
    // There are 3 situation to consider:
    // 1. There are even number of negative integers, which product of all will result in positive product.
    //    Example: [1,-2,3,-4]
    // 2. There are odd number of negative integers, which we need to take the greatest product,
    //    before the last negative integer leftmost or rightmost in the array.
    //    Example: [2,5,-3,-4,4,6,-4], check which subarrays,
    //             [2,5,-3,-4,4,6] or,
    //                    [-4,4,6,-4] is the greatest.
    // 3. There is a 0 in the array, which we take either the 0 or product of the subarrays on either side of the 0.
    //    Example: [2,5,-3,0,4,6,-4], check [2,5,-3] and [4,6,-4] if they have products greater than 0.
    //             Continue the Situation 2 for [2,5,-3] and [4,6,-4], which checks [2,5] and [4,6] respectively.
    //
    // With this understanding,
    // situation 1 requires only 1 traversal to check,
    // situation 2 requires 2 pointers from both sides of the array to check,
    //             since we need to get the product until the leftmost or rightmost negative integer, and
    // situation 3 requires the reset of the product after the 0, to continue checking the subarrays after the 0.
    // As such, using 2 pointers and resetting when product is 0 can solve the problem.

    public int maxProduct(int[] nums) {
        // 'max' can be Integer.MIN_VALUE, using any element in the array is suitable as well.
        int max = nums[0];

        // Rather than using index, we use 'left' and 'right' as the pointer on both sides.
        int left = 1;
        int right = 1;
        for (int i = 0; i < nums.length; i++) {
            // For both left or right, reset the product to 1 when it is 0.
            left = (left == 0 ? 1 : left) * nums[i];
            right = (right == 0 ? 1 : right) * nums[nums.length - i - 1];
            
            max = Math.max(max, Math.max(left, right));
        }
        return max;
    }
}
