package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given two integers 'dividend' and 'divisor', return the quotient after dividing the 'dividend' by 'divisor',
 * without using multiplication, division and mod operators.
 * The quotient is the integer excluding the remainder, as 'dividend' == ('quotient' * 'divisor') + 'remainder'.
 * Note that the integers are stored within the 32-bit signed integer range of [-2^31, 2^31 - 1].
 * If the quotient is greater than 2^31 - 1, return 2^31 - 1. If the quotient is less than -2^31, return -2^31.
 *
 *
 * Example 1:
 * Input    : dividend = 3, divisor = -2
 * Output   : -1
 * Explanation: 3 / -2 = -1.5, which the quotient is -1.
 *
 *
 * Example 2:
 * Input    : dividend = -2147483648, divisor = -1
 * Output   : 2147483647
 * Explanation: -2147483648 / -1 = 2147483648. However, 2147483648 is greater than 2147483647, thus return 2147483647.
 *
 *
 * Example 3:
 * Input    : dividend = -2147483648, divisor = 4
 * Output   : -536870912
 * Explanation: -2147483648 / 4 = 2147483648, which the quotient is -536870912.
 *
 *
 * @author Chee Hwa Tang
 */

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

        // The record the sign (positive or negative) of the result to return.
        // If only either 'dividend' or 'divisor' is negative, then the 'result' should return in negative.
        boolean positive = (dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0);

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
        return positive ? (int) result : (int) -result;
    }
}
