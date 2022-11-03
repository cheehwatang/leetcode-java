package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * Given an array of strings 'arr', return the maximum possible length of the string 's' formed
 * by concatenating a subsequence of 'arr' such that 's' only contains unique characters.
 *
 *
 * Example 1:
 * Input    : arr = ["a", "b", "c", "a"]
 * Output   : 3
 * Explanation: All valid concatenations with only unique characters are "", "a", "b", "c", "ab", "ac", "bc" and "abc".
 *              So the maximum possible length is 3.
 *
 *
 * Example 2:
 * Input    : arr = ["aa", "bb", "cc"]
 * Output   : 0
 * Explanation: Only "" is possible, as all the elements in 'arr' contain duplicate characters.
 *              So maximum possible length is 0.
 *
 *
 * @author Chee Hwa Tang
 */

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters_BitManipulation {

    // Approach:
    // Using bit masking and bit manipulation to check for duplicates and 'concatenate' the unique characters.
    //
    // First, bit masking is the process of storing data as bits (binary).
    // As a bit is represented by 0 or 1, it can be treated as true or false.
    // For string characters with radix of less than 31, in this case 26 lowercase English alphabets,
    // we can use bit masking to store if any character exist (1) or not exist (0).
    // Using the left shift operation '<<', we can store 1 at a certain bit position in the number.
    // For example, 'a' is stored as 1 << 'a' - 'a' (1 << 0) as 1, 'b' as 10 binary, 'c' as 100 binary, etc.
    // Note:
    // Reason for 31 is only when using primitive type int (32-bit signed), while primitive type long is 63 (64-bit signed).
    //
    // In bit manipulation,
    // '&' bitwise AND operation can be used to check for duplicate.
    // For example: Using bit masking mentioned above, "abc" == '111' in binary, "cde" == '11100' in binary.
    //              '00111' & '11100' == '00100'.
    //              So if '&' two bitmasked elements with result of > 0, then we have found duplicate.
    // '|' bitwise OR operation can be used to 'concatenate' the unique characters.
    // For example: "ab" == '11', "de" == '11000', '00011' | '11000' == '11011', indicating "abde".

    public int maxLength(List<String> arr) {
        // List of elements (concatenated or not) to be stored,
        // as we need to concatenate the new elements to all the strings with only unique characters found.
        List<Integer> bitmaskList = new ArrayList<>();
        // Remember the list is storing bitmasked String as int. An empty string is represented as '0'.
        bitmaskList.add(0);

        int max = 0;
        for (String str : arr) {
            int duplicate = 0;
            int currentBitmasked = 0;
            // Check if 'str' contains duplicate characters, as well as perform bit masking into 'currentBitmasked'.
            for (char character : str.toCharArray()) {
                // '&' get > 0 if contains duplicate.
                duplicate |= currentBitmasked & (1 << (character - 'a'));
                // '|' and '<<' to bit mask.
                currentBitmasked |= 1 << (character - 'a');
            }
            // Skip the current element if there are duplicate characters.
            if (duplicate > 0) continue;

            // For all the strings with only unique characters found so far:
            for (int i = 0; i < bitmaskList.size(); i++) {
                // skip if the string shared same character, or
                if ((bitmaskList.get(i) & currentBitmasked) > 0) continue;

                // 'concatenate' otherwise.
                bitmaskList.add(bitmaskList.get(i) | currentBitmasked);
                // For all strings, get the longest, using bitCount method to get all the 1s in the bit masked String.
                max = Math.max(max, Integer.bitCount(bitmaskList.get(i) | currentBitmasked));
            }
        }
        return max;
    }
}
