package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the maximum bitlength for both 'start' and 'goal'.
// The Integer.bitCount() method has linear time complexity.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input.

public class MinimumBitFlipsToConvertNumber {

    // Approach:
    // In order to make 'start' to be 'goal', we would flip the bits that are different.
    // Using the bitwise XOR operator "^", we can get the bit differences between 'start' and 'goal'.
    // Then, we can either implement bit traversal, or use the Integer.bitCount() method
    // to count the number of bits that are different.

    public int minBitFlips(int start, int goal) {
        // 'start' ^ 'goal' to get the differences,
        // then use Integer.bitCount to count the number of bits that are different.
        return Integer.bitCount(start ^ goal);
    }
}
