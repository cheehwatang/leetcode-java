package com.cheehwatang.leetcode;

// Time Complexity  : O(1),
// as we would check for each binary (0 to 31) for any inputs of 'dividend' and 'divisor'.
//
// Space Complexity : O(1),
// as the auxiliary space used by the variables is constant and independent of the input.

public class DivideTwoIntegers {

    // Approach:
    // Using bit manipulation, focusing on the shift operators '>>' and '<<'.
    // The shift operators has the property of multiplying the number by 2 for each shift.
    // Example:
    // 1 << 2 == 1 * 2^2 == 4, 5 << 3 == 5 * 2^3 == 40.
    // Together with "dividend == (quotient * divisor) + remainder", if the 'divisor' shift 'x' is less than the 'dividend',
    // dividend == (divisor << x) + (something * divisor) + remainder
    // Continue the process until 'something' == 0, or dividend < divisor, in both cases the 'dividend' is the 'remainder'.

    public int divide(int dividend, int divisor) {
        // This is the handle the corner case where the result is greater than 2^31 - 1.
        if (dividend == Integer.MIN_VALUE && divisor == -1) return (1 << 31) - 1;

        // Case both 'dividend' and 'divisor' to long type to handle the cases where the number == -2^31,
        // from which the absolute value is greater than 2^31 - 1, resulting in integer overflow.
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);

        // As the 'quotient' is made up of 'divisor' * 2^i, much like the binary with 1s and 0s,
        // we check each possible 'i' for the 'divisor', from the largest 'i'.
        long result = 0;
        for (int i = 31; i >= 0; i--) {
            if (longDividend >> i >= longDivisor) {
                // Adjust the 'result' and 'dividend' accordingly.
                result += 1L << i;
                longDividend -= longDivisor << i;
            }
        }
        // The record the sign (positive or negative) of the result to return.
        // If only either 'dividend' or 'divisor' is negative, then the 'result' should return in negative.
        boolean positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

        return positive ? (int) result : (int) -result;
    }
}
