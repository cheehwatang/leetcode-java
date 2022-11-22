package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n^2),
// where 'n' is the length of 'nums'.
// In the documentation, the sort() function of the Arrays class uses Dual-Pivot Quicksort,
// which offers a O(n logn) performance on average, but the worst case of the quicksort is quadratic O(n^2).
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// Although the Dual-Pivot Quicksort does not use auxiliary space, it uses stack in its recursive calls.

public class SquaresOfASortedArray_Sorting {

    // Approach:
    // Square all the integers in 'nums' in-place, then use the sort() function in the Arrays class to sort.

    public int[] sortedSquares(int[] nums) {
        // Here we use nums[i] * nums[i], but optional to use "(int) Math.pow(nums[i], 2)".
        for (int i = 0; i < nums.length; i++)
            nums[i] = nums[i] * nums[i];
        Arrays.sort(nums);
        return nums;
    }
}
