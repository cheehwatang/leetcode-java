package com.cheehwatang.leetcode;

// Time Complexity  : O(1),
// as we just perform arithmetic.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the size of the input.

public class CountOddNumbersInAnIntervalRange {

    // Approach:
    // If the range contains even number of integers, then the number of odd integers is half of the range.
    // For example, low = 3, high = 6, the range is 4, with only 2 odd integers in the range.
    // If the range contains odd number of integers, then the number of odd integers is dependent
    // if the low and high integer is odd or even.
    // If the low and high integer is odd, then the number of odd integers is half of the range + 1.
    // For example, low = 3, high = 7, the range is 5, with 3 odd integers in the range [3, 5, 7].
    // If the low and high integer is even, then the number of odd integers is half of the range.
    // For example, low = 2, high = 6, the range is 5, with 2 odd integers in the range [3, 5].

    public int countOdds(int low, int high) {
        // Get the range of the number.
        int range = high - low + 1;
        // If the range is odd and the low and high number is odd, then the number of odd integers
        // is half of range + 1.
        if (isOdd(range) && isOdd(low)) return range / 2 + 1;
        // All other scenarios, the number of odd integers is half of range.
        return range / 2;
    }

    // Helper method to determine if the number is odd.
    private boolean isOdd(int number) {
        return number % 2 == 1;
    }
}
