package com.cheehwatang.leetcode;

// Time Complexity  : O(logn),
// as we are dividing 'n' by either 2, 3 or 5 until reaching 1,
// the time complexity scales with the log2 of 'n' in the worst case.
//
// Space Complexity : O(1),
// as no additional space is used.

public class UglyNumber {

    // Approach:
    // Continue to divide 'n' with either 2, 3 or 5 until unable to fully divide anymore.
    // If the result is 1, then 'n' is an ugly number.
    // If it is another prime number other than 2, 3 or 5, then it is not an ugly number.

    public boolean isUgly(int n) {
        // Edge case of 'n' == 0 and return true.
        if (n == 0) return true;

        // We continue to divide 'n' with number 2, 3, 4 and 5 until 'n' cannot be completely divided.
        for (int i = 5; i >= 2; i--) {
            while (n % i == 0) n /= i;
        }
        
        // As 'n' can be negative, we take the absolute value of the result.
        return Math.abs(n) == 1;
    }
}
