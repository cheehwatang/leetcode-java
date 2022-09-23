package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given an integer 'n', return the decimal value of the binary string formed by concatenating the binary representation,
 * in the modulo '1e9 + 7'.
 *
 * Note:
 * Use bit manipulation or math.
 *
 * Example 1:
 * Input    : n = 2
 * Output   : 6
 * Explanation: In binary, 1 and 2 corresponds to 1 and 10. Concatenating result in 110 = 6.
 *
 * Example 2:
 * Input    : n = 11
 * Output   : 406586234
 * Explanation: The concatenations result in "110111001011101111000100110101011" = 7406586283.
 * With modulo 1e9 + 7 will result in 406586234.
 *
 *
 * @author Chee Hwa Tang
 */

// Time Complexity: O(N)
// Space Complexity: O(1)
// where N is n.

public class ConcatenationOfConsecutiveBinaryNumbers_BitManipulation {

    // Approach:
    // Using bit manipulation as described below.
    // A bit of description for the bitwise operations used, if you are not familiar.
    // 1. & - Bitwise AND operation:
    //    0 & 0 = 0,
    //    1 & 0 = 0,
    //    1 & 1 = 1.
    //    Example : 1101 & 1010 = 1000
    //
    // 2. << - Shift Left operation, by n position:
    //    Example:
    //    11 (3) << 2 (n position) = 1100 (14)
    //

    public int concatenatedBinary(int n) {

        final long modulo = (long) (1e9 + 7);
        long result = 0;

        // This records the number of binaryDigits we need to shift left.
        int binaryDigits = 0;

        for (int i = 1; i <= n; i++) {

            // If i is a power of 2, we add one additional binaryDigits to shift.
            // Example:
            // i = 8 (1000), i-1 = 7 (111)
            // i & (i-1) = 1000 & 111 = 0
            // So we know we have increased the binaryDigits from 3 (in 111) to 4 (in 1000).
            if ((i & (i - 1)) == 0) {
                binaryDigits++;
            }

            // With the updated binaryDigits, we now can concatenate i to the result.
            // Each time get the remainder of the result % modulo.
            // Example:
            // i = 2
            // result = 1 (1) << 2 (n position) + 10 (2) = 100 (4) + 10 (2) = 110 (6).
            // i = 3
            // result = 110 (6) << 2 (n position) + 11 (3) = 11000 (24) + 11 (3) = 11011 (27).
            //
            result = ((result << binaryDigits) + i) % modulo;
        }
        return (int) result;
    }
}
