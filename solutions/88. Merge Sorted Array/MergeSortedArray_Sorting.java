package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O((m + n)^2),
// where 'm' is the length of 'nums1' with elements and 'n' is the length of 'nums2'.
// This is because of the Arrays.sort() function uses the Dual-Pivot Quicksort,
// which on average has a time complexity of O(t logt), but has the worst case quadratic function of O(t^2).
//
// Space Complexity : O(1),
// as no new arrays are created.

public class MergeSortedArray_Sorting {

    // Approach:
    // Copy all the elements from 'nums2' to the remaining positions in 'num1', then sort 'nums1'
    // using the in-built sort function.

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // The inputs for System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length).
        // Note that this is in-place.
        System.arraycopy(nums2, 0, nums1, m, n);

        Arrays.sort(nums1);
    }
}
