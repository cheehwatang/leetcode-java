package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given an array of integers, return true or false, whether the integer array is a valid UTF-8 encoding.
 *
 * Note:
 * UTF-8 contains characters ranging from 1 to 4 bytes long, with rules shown in the example below.
 * Number of Bytes (n) => UTF-8 Binary Sequence               =>  Explanation
 *                  1     0xxxxxxx                            =>  starts with 0
 *                  2     110xxxxx 10xxxxxx                   =>  starts with two 1s and one 0
 *                  3     1110xxxx 10xxxxxx 10xxxxxx          =>  starts with three 1s and one 0
 *                  4     11110xxx 10xxxxxx 10xxxxxx 10xxxxxx =>  starts with four 1s and one 0
 *                        => Bytes 2 - 4, contains another n-1 octet binary sequence starting with 10.
 *
 * Example 1:
 * Input        = [230,140,175,36]
 * Output       = true
 * Explanation: Converting to binary [11100110,10101111,10001100,00100100]
 *                                   [1110xxxx,10xxxxxx,10xxxxxx,0xxxxxxx], first 3 is 3 Bytes, followed by 1 Byte.
 *
 * Example 2:
 * Input        = [120,215,166,48]
 * Output       = true
 * Explanation: Converting to binary [01111000,11010111,10100110,00110000]
 *                                   [0xxxxxxx,110xxxxx,10xxxxxx,0xxxxxxx], 1 Byte, 2 Bytes, followed by 1 Byte.
 *
 * Example 3:
 * Input        = [245,150,188,74]
 * Output       = false
 * Explanation: Converting to binary [11110101,10010110,10111100,01001010]
 *                                   [11110xxx,10xxxxxx,10xxxxxx,0xxxxxxx], supposedly first 4 is 4 Bytes.
 *
 *
 * @author Chee Hwa Tang
 */

public class UTF8Validation_BitManipulation {

    // 1 byte = 0xxxxxxx
    // 2 bytes = 110xxxxx 10xxxxxx
    // 3 bytes = 1110xxxx 10xxxxxx 10xxxxxx
    // 4 bytes = 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx

    // This method involves shifting the bits right, to get the binary digits of importance.
    // int >> 7 to shift seven position to the right, getting only the first binary digit.
    // The bit manipulation works for both integers and binary numbers.
    // Example: 01001010 (int 74) >> 7 = 0, 11010111 (215) >> 5 == 110 (int 6).

    public boolean validUtf8(int[] data) {
        int count = 0;
        for (int value : data) {
            if (count == 0) {
                // for 4 bytes, shift 3 position to check 11110xxx
                // for 3 bytes, shift 4 position to check 1110xxxx
                // for 2 bytes, shift 5 position to check 110xxxxx
                // for 1 bytes, shift 7 position to check 0xxxxxxx
                // each will update the count, to check the subsequent number if follows 10xxxxxx.
                if (value >> 3 == 0b11110) {
                    count = 3;
                } else if (value >> 4 == 0b1110) {
                    count = 2;
                } else if (value >> 5 == 0b110) {
                    count = 1;
                } else if (value >> 7 == 0b0) {
                    count = 0;
                } else {
                    return false;
                }
            } else {
                // shift 6 position to check 10xxxxxx
                if (value >> 6 == 0b10) {
                    count--;
                } else {
                    return false;
                }
            }
        }
        // If the count reaches zero at the end, meaning no leftover 10xxxxxx unchecked.
        return count == 0;
    }

}
