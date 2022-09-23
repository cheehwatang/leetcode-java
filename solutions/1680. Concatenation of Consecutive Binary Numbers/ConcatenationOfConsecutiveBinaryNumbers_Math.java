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

public class ConcatenationOfConsecutiveBinaryNumbers_Math {

    // Approach:
    // We concatenate by shifting position of result with division and multiplication, then add the number.
    // As there are a lot of repetitions in shifting of positions, it is much less efficient than using bit manipulation.

    public int concatenatedBinary(int n) {
        final long modulo = (long) (1e9 + 7);
        long result = 0;
        for (int i = 1; i <= n; i++) {
            // For each i, we shift left the position of result with * 2,
            // while shifting right the position of i with / 2.
            int temp = i;
            while (temp > 0) {
                temp /= 2;
                result *= 2;
            }
            // Add the i to the result and get the remainder of modulo.
            result = (result + i) % modulo;
        }
        return (int) result;
    }
}
