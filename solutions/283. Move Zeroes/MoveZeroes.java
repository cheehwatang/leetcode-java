package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse through 'nums' to check every element.
//
// Space Complexity : O(1),
// as we only use fixed variables that does not grow with 'n'.

public class MoveZeroes {

    // Approach:
    // Using Two Pointers to traverse through 'nums':
    // - 'head' pointer check for non-zero integer, and
    // - 'tail' pointer is the latest index to put the non-zero integer.
    // Once all the non-zero numbers are put into their respective positions,
    // we replace the remaining positions in the array with 0.

    public void moveZeroes(int[] nums) {

        // Both 'tail' and 'head' pointer starts at index 0.
        int tail = 0;

        for (int head = 0; head < nums.length; head++)
            // If the integer is non-zero, we put it in the final position.
            if (nums[head] != 0) nums[tail++] = nums[head];

        // Once done, we replace the remaining positions with 0.
        for (; tail < nums.length; tail++)
            nums[tail] = 0;
    }
}
