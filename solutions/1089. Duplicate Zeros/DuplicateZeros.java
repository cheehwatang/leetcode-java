package com.cheehwatang.leetcode;

// Time Complexity  : O(n^2),
// where 'n' is the length of 'arr',
// as the worst case being every element in 'arr' is zero, thus requires shifting the array for every element.
//
// Space Complexity : O(1),
// as not new arrays are created.

public class DuplicateZeros {

    // Approach:
    // Using the System.arraycopy() function to shift the elements in the array.

    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // Move to the next element if the integer is not zero.
            if (arr[i] != 0) continue;

            // The inputs for System.arraycopy(Object src, int srcPos, Object dest, int destPos, int length).
            // Note that this is in-place as well, if the 'src' and 'dest' is the same.
            System.arraycopy(arr, i, arr, i + 1, n - 1 - i);

            // Take note to shift to pointer forward once as the next element is updated to zero.
            i++;
        }
    }
}
