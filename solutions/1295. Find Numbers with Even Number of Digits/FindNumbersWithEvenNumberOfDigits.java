package com.cheehwatang.leetcode;

// Time Complexity  : O(m^n),
// where 'm' is the maximum number of digits for the elements of 'nums', and 'n' is the length of 'nums'.
// This is because of the counting of the digits for every element in 'nums'.
//
// Space Complexity : O(1),
// As only fixed variables are used.

public class FindNumbersWithEvenNumberOfDigits {

    // Approach:
    // Calculate the number of digits for every elements in 'nums',
    // using division by 10 and a 'digit' variable to keep track.

    public int findNumbers(int[] nums) {
        int count = 0;
        int digit;
        for (int integer : nums) {
            digit = 0;
            // Calculate the number of digits.
            while (integer != 0) {
                digit++;
                integer /= 10;
            }
            // Increase the count if it is even number of digits.
            if (digit % 2 == 0) count++;
        }
        return count;
    }
}
