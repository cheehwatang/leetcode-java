package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse the 'nums' array once to find the third maximum number.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent on the input.

public class ThirdMaximumNumber {

    // Approach:
    // Traverse the 'nums' array and use 3 Integer variable to keep track of the top 3 maximum number.
    // Using conditional statements, we shift the numbers accordingly if we found number that is
    // greater than the first, second or third maximum.

    public int thirdMax(int[] nums) {
        // Option to use long, or int = Integer.MIN_VALUE.
        // Here, we cast the int to Integer, and use null for better readability.
        Integer first = null;
        Integer second = null;
        Integer third = null;

        for (Integer number : nums) {
            // Skip number if the number is the same as any of the 3 maximums.
            if (number.equals(first) || number.equals(second) || number.equals(third)) continue;

            // If the number is greater than the first maximum,
            if (first == null || number > first) {
                // shift the numbers down accordingly, and replace the first maximum number.
                third = second;
                second = first;
                first = number;
            }
            // If the number is greater than the second but less than the first,
            else if (second == null || number > second) {
                // shift the second number down, and replace the second maximum number.
                third = second;
                second = number;
            }
            // If the number is greater than the third maximum number,
            else if (third == null || number > third) {
                // replace the third maximum number.
                third = number;
            }
            // Note that we replace directly if any of the numbers is null.
        }
        // If the third maximum number is not found, return the maximum number.
        return third == null ? first : third;
    }
}
