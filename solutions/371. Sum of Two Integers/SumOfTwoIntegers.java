package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the longest bits of the number 'a' or 'b'.
// The worst-case is when the while-loop occurs for numbers such as 11111 + 1,
// which loops for 5 times until the result 100000.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input.

public class SumOfTwoIntegers {

    // Approach:
    // Using bit manipulation, with the bitwise AND '&' to get the carries (1 + 1 = 0 carries 1),
    // and with bitwise XOR '^' to get the 1s that remains in that position.
    // For example, 1 + 1 = 10, with 1 & 1 = 1, and 1 ^ 1 = 0.
    // We then use bitwise left shift for the carries, 1 << 1 = 10.
    // Repeat the process with 10 & 0 = 0, 10 ^ 0 = 10.
    // With that, we have found to sum of 1 + 1 to be 2 (or binary 10).

    public int getSum(int a, int b) {
        // If either is zero, return the non-zero number.
        if (a == 0) return b;
        if (b == 0) return a;

        // While there are still carries remain.
        // For this, we use 'b' to hold the carries.
        while (b != 0) {
            int carries = a & b;
            a = a ^ b;
            // Left shift the carries by one bit.
            b = carries << 1;
        }
        return a;
    }
}
