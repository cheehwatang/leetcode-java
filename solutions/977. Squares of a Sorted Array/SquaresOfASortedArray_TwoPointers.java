package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// As we only traverse 'nums' once.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums', as we use an additional array to store the result.

public class SquaresOfASortedArray_TwoPointers {

    // Approach:
    // Using two pointers to check the most negative (leftmost) and the most positive (rightmost) integers.
    // Whichever integer in its absolute value is greater, store its square in the rightmost position of the result.
    // For Example, nums = [-7,-4,0,5,8],
    // The absolute value of the leftmost -7 and rightmost 8, with 8 squared being greater,
    // thus store in the result [0,0,0,0,64].
    // Then compare leftmost -7 and rightmost 5, with -7 squared being greater,
    // resulting in [0,0,0,49,64], and so on.

    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int left = 0;
        int right = n - 1;
        for (int i = n - 1; i >= 0; i--) {
            // If Math.abs(nums[left]) is greater,
            // store its square in result[i] and move the pointer to the next integer.
            if (Math.abs(nums[left]) >= Math.abs(nums[right])) {
                // Here we use nums[i] * nums[i], but optional to use "(int) Math.pow(nums[i], 2)".
                result[i] = nums[left] * nums[left];
                left++;
            }
            // If Math.abs(nums[right]) is greater,
            // store its square in result[i] and move the pointer to the next integer.
            else {
                result[i] = nums[right] * nums[right];
                right--;
            }
        }
        return result;
    }
}
