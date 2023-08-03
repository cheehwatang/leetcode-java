package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n logn),
// where 'n' is the length of 'heights'.
// The cloning the 'heights' array, and the traversal of 'heights' array has O(n) time complexity.
// The sorting of the cloned array has a time complexity of O(n logn),
// according to the Dual-Pivot Quicksort method implemented.
//
// Space Complexity : O(n),
// where 'n' is the length of 'heights'.
// We clone the 'heights' array of length 'n'.

public class HeightChecker_Sorting {

    // Approach:
    // We clone the 'heights' array and sort it to get the 'expected' array.
    // Then, we compare the 'expected' and 'heights' array to count the number of heights that are different.

    public int heightChecker(int[] heights) {
        // Clone and sort the array to get the 'expected' array.
        int[] expected = heights.clone();
        Arrays.sort(expected);

        int count = 0;
        // Traverse both 'expected' and 'heights' arrays to compare and count the number of heights that are different.
        for (int i = 0; i < heights.length; i++) {
            if (heights[i] != expected[i]) count++;
        }
        return count;
    }
}
