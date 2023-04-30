package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n^2),
// where 'n' is the length of 'arr'.
// Arrays.sort() function uses Dual-Pivot Quicksort with average performance of O(n logn), but with worst case of O(n^2).
// Arrays.binarySearch() function has a performance of O(logn),
// however as we traverse each element in 'arr' to perform binary search, the performance of the search is O(n logn).
// As such, we take the worst time complexity of Arrays.sort().
// Do note that both Arrays.sort() and Arrays.binarySearch() functions are developed and optimized,
// thus using them could improve performance as compared to other methods.
//
// Space Complexity : O(1),
// as no additional space is used.

public class CheckIfNAndItsDoubleExist_Sorting_BinarySearch {

    // Approach:
    // Use sorting and binary search to find the double of the elements in 'arr'.

    public boolean checkIfExist(int[] arr) {

        // As binary search requires sorted array, we first need to sort 'arr'.
        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            // Arrays.binarySearch return the index of the double found, and -1 if not found.
            int index = Arrays.binarySearch(arr, arr[i] * 2);

            // If the index is non-negative, then we have found the element's double.
            // However, we need to check if index != i.
            // This is because of the edge case of 0, which the double of 0 is still 0.
            // Thus, we need to make sure that we do not accidentally return true when we found the same 0.
            if (index >= 0 && index != i) return true;
        }
        return false;
    }
}
