package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'arr'.
//
// Space Complexity : O(1),
// as not auxiliary space is used.

public class ReplaceElementsWithGreatestElementOnRightSide {

    // Approach:
    // From the end to the start of the array, replace integer that is smaller than the current max,
    // until we found an integer with greater value.
    // Then update the max with the new maximum integer and continue.

    public int[] replaceElements(int[] arr) {
        int max = -1;
        for (int i = arr.length - 1; i >= 0; i--) {
            // "arr[i] = max" allows us to update arr[i] to max,
            // while the first input in Math.max() already records arr[i] before the update.
            // Otherwise, we would need a temporary variable to store the previous max before modifying the array.
            max = Math.max(arr[i], arr[i] = max);
        }
        return arr;
    }
}
