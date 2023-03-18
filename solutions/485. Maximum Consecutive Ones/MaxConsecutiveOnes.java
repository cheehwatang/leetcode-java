package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse 'nums' once to count the maximum consecutive ones.
//
// Space Complexity: O(1),
// as the auxiliary space used is independent on the size of the input 'nums'.

public class MaxConsecutiveOnes {

    // Approach:
    // Using a 'count' variable to keep track of the current count of consecutive ones,
    // and a 'max' to keep track of the maximum number of consecutive ones found.

    public int findMaxConsecutiveOnes(int[] nums) {
        // Using 'max' to keep track of maximum consecutive ones, and 'count' to keep track each consecutive ones.
        int max = 0;
        int count = 0;
        for (int number: nums) {
            // Increase count by one, and compare count to max.
            if (number == 1) {
                count++;
                max = Math.max(count, max);
            }
            // Reset count when 0 occurs.
            else count = 0;
        }
        return max;
    }
}
