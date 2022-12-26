package com.cheehwatang.leetcode;

// Time Complexity  : O(m + n),
// where 'm' is the length of 'nums1' with elements and 'n' is the length of 'nums2'.
//
// Space Complexity : O(1),
// as no new arrays are created.

public class MergeSortedArray_TwoPointers {

    // Approach:
    // Using two pointers to compare the elements in 'nums1' and 'nums2' to check which is greater, from right to left.
    // Move the greater number to the rightmost position in 'nums1' from right to left.

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // Keep track of the index in the final merged sorted array.
        int lastUnsortedIndex = m + n - 1;
        // Keep track of the index in 'nums1'.
        int pointer1 = m - 1;
        // Keep track of the index in 'nums2'.
        int pointer2 = n - 1;

        while (pointer2 >= 0) {
            // If the element in 'nums1' is greater, then copy into the merged array.
            if (pointer1 >= 0 && nums1[pointer1] >= nums2[pointer2])
                nums1[lastUnsortedIndex--] = nums1[pointer1--];
            // If fully traversed 'nums1', or when the element in 'nums2' is greater, then copy into the merged array.
            else
                nums1[lastUnsortedIndex--] = nums2[pointer2--];
        }
    }
}
