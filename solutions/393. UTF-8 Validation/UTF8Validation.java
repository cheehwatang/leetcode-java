package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of integer array 'data'.
// We traverse the 'data' array to check if the numbers fit the UTF8 pattern.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent on the size of the input.

public class UTF8Validation {

    // UTF-8 Binary Sequence:
    // 1 byte = 0xxxxxxx
    // 2 bytes = 110xxxxx 10xxxxxx
    // 3 bytes = 1110xxxx 10xxxxxx 10xxxxxx
    // 4 bytes = 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx

    // Approach:
    // With the 8-bits binary number, we can check if the number in 'data' matches any of the pattern as shown below:
    // - 0xxxxxxx : <= 127
    // - 10xxxxxx : >= 128 && <= 191
    // - 110xxxxx : >= 192 && <= 223
    // - 1110xxxx : >= 224 && <= 239
    // - 11110xxx : >= 240 && <= 247
    //
    // We also use a count to keep track the number 10xxxxxx required, for 2, 3 and 4 bytes pattern.

    public boolean validUtf8(int[] data) {
        // 'count' keep track of the 10xxxxxx required.
        int count = 0;
        for (int number : data) {
            // Number greater than 247 does not fit any of the above pattern.
            if (number > 247) return false;

            // If count is 0, and the number is fits 110xxxxx, 1110xxxx or 11110xxx, then we will update the count
            // to check the subsequent number if it follows 10xxxxxx.
            if (count == 0) {
                // If number matches 11110xxx, check for the subsequent three numbers to follow 10xxxxxx.
                if (number >= 240) count = 3;
                // If number matches 1110xxxx, check for the subsequent two numbers to follow 10xxxxxx.
                else if (number >= 224) count = 2;
                // If number matches 110xxxxx, check for the subsequent number to follow 10xxxxxx.
                else if (number >= 192) count = 1;
                // If number matches 10xxxxxx while the count is 0, then it is invalid.
                else if (number >= 128) return false;
                // Note that we did not perform any checks for 0xxxxxxx (<= 127),
                // as no action is needed (count remains 0 and move to the next number).
            }
            // If the count is more than 0,
            else {
                // check if the number matches 10xxxxxx.
                if (number >= 128 && number <= 191) count--;
                // If not, then the sequence is invalid.
                else return false;
            }
        }
        // If the count reaches zero at the end, meaning no leftover 10xxxxxx unchecked.
        return count == 0;
    }
}
