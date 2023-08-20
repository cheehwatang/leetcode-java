package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n logn),
// where 'n' is the length of 'nums'.
// We use Arrays.sort() to sort the 'nums' array,
// which implements the Dual-Pivot Quicksort with O(n logn) time complexity.
// Then, we traverse the sorted 'nums' array to find the third maximum number.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent on the input.

public class ThirdMaximumNumber_Sorting {

    // Approach:
    // We first sort 'nums'.
    // This allows use to traverse the array in descending order,
    // checking for the second and third maximum number.
    // Here, we are sure that the third distinct number found in the sorted array is the thid maximum number.

    public int thirdMax(int[] nums) {
        int n = nums.length;

        // As Arrays.sort() method's comparator do not allow comparison with int primitive type,
        // we sort in ascending order, but traverse from the last index.
        Arrays.sort(nums);

        // We know for sure the last element in the sorted 'nums' is the first maximum number.
        Integer first = nums[n - 1];
        // We use Integer type instead of int primitive type, so that we can use null as placeholder,
        // for better readability.
        // Options to use long type or Integer.MIN_VALUE.
        Integer second = null;

        // Traverse the sorted 'nums' in descending order (from right to left).
        for (int i = n - 2; i >= 0; i--) {
            // If the number is less than the first and second maximum, return the number.
            if (nums[i] < first) {
                // If the second number is null, replace with the number.
                if (second == null)
                    second = nums[i];
                else if (nums[i] < second) {
                    return nums[i];
                }
            }
        }
        // If we successfully traverse the array, it means the third maximum number is not found.
        return first;
    }
}
