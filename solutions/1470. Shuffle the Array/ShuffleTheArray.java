package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the size of 'nums'.
// We traverse the array 'nums' once to get the elements to put into the new array.
//
// Space Complexity : O(n),
// where 'n' is the size of 'nums'.
// We created a new array for the result with the size of 'nums'.

public class ShuffleTheArray {

    // Approach:
    // Traverse the array while taking the integer from the 'i' and 'n + i' position to
    // put into the new position in the new array, at index '2 * i' and '2 * i + 1' respectively.

    public int[] shuffle(int[] nums, int n) {
        // Result array of size 2 * n.
        int[] result = new int[2 * n];

        // For each element,
        for (int i = 0; i < n; i++) {
            // put nums[i] into the '2 * i' position,
            result[2 * i] = nums[i];
            // and put nums[n + i] into the '2 * i + 1' position.
            result[2 * i + 1] = nums[n + i];
        }

        // Return the result array with elements in the shuffled position.
        return result;
    }
}