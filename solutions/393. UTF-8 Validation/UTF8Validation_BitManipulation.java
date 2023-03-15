package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of integer array 'data'.
// We traverse the 'data' array to check if the numbers fit the UTF8 pattern.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent on the size of the input.

public class UTF8Validation_BitManipulation {

    // UTF-8 Binary Sequence:
    // 1 byte = 0xxxxxxx
    // 2 bytes = 110xxxxx 10xxxxxx
    // 3 bytes = 1110xxxx 10xxxxxx 10xxxxxx
    // 4 bytes = 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx

    // Approach:
    // Using bit manipulation to shift the bits to the right, to get the binary digits of importance:
    // - shift 7 bits : 0xxxxxxx
    // - shift 6 bits : 10xxxxxx
    // - shift 5 bits : 110xxxxx
    // - shift 4 bits : 1110xxxx
    // - shift 3 bits : 11110xxx
    // number >> 7 to shift seven position to the right, getting only the first binary digit.
    // The bit manipulation works for both integers and binary numbers.
    // Example: 01001010 (int 74) >> 7 = 0, 11010111 (215) >> 5 == 110 (int 6).
    //
    // Note that we are using prefix '0b' before the binary number to represent it as binary number.
    // For example, 0b10 is binary 10 which is number 2.

    public boolean validUtf8(int[] data) {
        int count = 0;
        for (int number : data) {
            // If count is 0, and the number is fits 110xxxxx, 1110xxxx or 11110xxx, then we will update the count
            // to check the subsequent number if it follows 10xxxxxx.
            if (count == 0) {
                // For 4 bytes, shift 3 position to check 11110xxx.
                if (number >> 3 == 0b11110) count = 3;
                // For 3 bytes, shift 4 position to check 1110xxxx.
                else if (number >> 4 == 0b1110) count = 2;
                // For 2 bytes, shift 5 position to check 110xxxxx.
                else if (number >> 5 == 0b110) count = 1;
                // For 1 byte, shift 7 position to check 0xxxxxxx.
                else if (number >> 7 == 0b0) count = 0;
                // If the number does not fit any of the pattern, then it is invalid.
                else return false;
            }
            // If the count is more than 0,
            else {
                // shift 6 position to check 10xxxxxx.
                if (number >> 6 == 0b10) count--;
                // If not, then the sequence is invalid.
                else return false;
            }
        }
        // If the count reaches zero at the end, meaning no leftover 10xxxxxx unchecked.
        return count == 0;
    }
}
