package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the maximum bitlength of 'a', 'b' and 'c'.
// We traverse each bit for all three inputs, until we finish traversing the integer with the longest bitlength.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input.

public class MinimumFlipsToMakeAORBEqualToC {

    // Approach:
    // Traverse each bit for all three numbers, each time shifting one bit to the right (bitwise right shift '>>'),
    // or dividing the number by 2.
    // For each iteration, we check the rightmost bit ('num' & 1) or ('num' % 2).
    // If 'c' has 1 bit, then add 1 flip if both 'a' and 'b' has 0 bits.
    // If 'c' has 0 bit, then add the bits for both 'a' and 'b', as any 1 bit would need to be flipped.
    //
    // Continue the iterations until all the numbers reaches 0.

    public int minFlips(int a, int b, int c) {
        int flips = 0;

        // While any of the numbers still has bit not checked,
        while (a > 0 || b > 0 || c > 0) {
            // get the bits for 'a', 'b' and 'c'.
            int abBits = (a & 1) + (b & 1);
            int cBit = c & 1;
            // If 'c' has 1 bit, and both 'a' and 'b' has 0 bits, then add 1 flip.
            if (cBit == 1 && abBits == 0) {
                flips += 1;
            }
            // If 'c' has 0 bit, then add the 'abBits'.
            else if (cBit == 0) {
                flips += abBits;
            }
            // Shift all numbers to right by 1 bit.
            a = a >> 1;
            b = b >> 1;
            c = c >> 1;
        }
        return flips;
    }
}
