package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given two integers 'a' and 'b', return the sum of the two integers without using the operators + and -.
 *
 *
 * Example 1:
 * Input    : a = 1, b = -1
 * Output   : 0
 *
 *
 * Example 2:
 * Input    : a = -100, b = -95
 * Output   : -195
 *
 *
 * @author Chee Hwa Tang
 */

public class SumOfTwoIntegers {

    // Approach:
    // Using bit manipulation, with the Bitwise AND '&' to get the carries (1 + 1 = 0 carries 1),
    // and with Bitwise XOR '^' to get the 1s that remains in that position.

    public int getSum(int a, int b) {
        // If either is zero, return the non-zero number.
        if (a == 0) return b;
        if (b == 0) return a;

        // While there are still carries remain.
        while (b != 0) {
            int carries = a & b;
            a = a ^ b;
            b = carries << 1;
        }
        return a;
    }
}
