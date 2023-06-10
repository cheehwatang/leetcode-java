package com.cheehwatang.leetcode;

// Time Complexity  : O(n logn),
// where 'n' is the input 'n'.
// We traverse from 1 to 'n', and we use division to find the bit length of each number, with O(log n) time complexity,
// resulting in the final O(n logn) time complexity.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent on the input 'n'.

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
