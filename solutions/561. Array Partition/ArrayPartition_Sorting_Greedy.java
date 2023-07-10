package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n logn),
// where 'n' is the length of 'nums'.
// The Arrays.sort() function implements the Dual-Pivot Quicksort, which has O(n logn) time complexity.
// We traverse the 'nums' array once to sum the even-indexed numbers, which results in O(n) time complexity.
// Thus, the time complexity of the function is O(n logn) due to the sorting function.
//
// Space Complexity : O(1),
// as the auxiliary spaced used is independent of the input size.

public class ArrayPartition_Sorting_Greedy {

    // Approach:
    // From the problem, we know that the best approach is to pair the numbers with the least difference,
    // and sum the lower number of the pair.
    // This is the greedy approach, as we only consider the lower number of the pair,
    // regardless on the value, as we know this would lead to the maximum sum.
    //
    // With that understanding, we can sort the numbers in ascending order.
    // Then, we only sum the even-indexed number, which is the lower number of the pair.

    public int arrayPairSum(int[] nums) {
        // Sort the 'nums' array.
        Arrays.sort(nums);

        int sum = 0;
        // Sum the even-indexed number.
        for (int i = 0; i < nums.length; i += 2) {
            sum += nums[i];
        }
        return sum;
    }
}
