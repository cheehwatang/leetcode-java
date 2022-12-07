package com.cheehwatang.leetcode;

// Time Complexity  : O(n^2),
// where 'n' is the length of 'arr',
// as the worst case being every element in 'arr' is zero, thus requires shifting the array for every element.
//
// Space Complexity : O(1),
// as not new arrays are created.

public class DuplicateZeros_TwoPointers {

    // Approach:
    // Using an additional pointer to shift the elements to the right when found at zero.

    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // Move to the next element if the integer is not zero.
            if (arr[i] != 0) continue;

            // Shift the elements to the right, including the zero found.
            for (int j = n - 1; j > i ; j--)
                arr[j] = arr[j - 1];

            // Take note to shift to pointer forward once as the next element is updated to zero.
            i++;
        }
    }
}
