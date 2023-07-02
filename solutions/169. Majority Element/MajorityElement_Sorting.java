package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n logn),
// where 'n' is the length of 'nums'.
// We use Arrays.sort() method which implements Dual-Pivot Quicksort with O(n logn) time complexity.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input.

public class MajorityElement_Sorting {

    // Approach:
    // For the majority, we are certain that a number has frequency at least 'n / 2'.
    // As such, we can sort 'nums'.
    // Whichever number that is in the middle of the sorted array is the majority number.

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
