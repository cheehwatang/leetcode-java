package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;

// Time Complexity  : O(n^3 + m),
// where 'n' is the length of the list 'arr', and 'm' is the number of characters in the list 'arr'.
// We iterate through each character in the strings to find duplicates, with O(m) time complexity.
// In the worst-case when all characters are unique, we iterate through 'bitmaskList', O(n^2) size,
// for string in the list 'arr'.
//
// Space Complexity : O(n^2 + m),
// where 'n' is the length of the list 'arr', and 'm' is the number of characters in the list 'arr'.
// In the worst-case when all characters are unique, the space used in the 'bitmaskList' is O(n^2),
// since 'n' number of elements is added to the list for each element.
// Each string in the list 'n' is converted to char Array, resulting in time complexity of O(m).

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters_BitManipulation {

    // Approach:
    // Using bitmasking and bit manipulation to check for duplicates and 'concatenate' the unique characters.
    //
    // First, bitmasking is the process of storing data as bits (binary).
    // As a bit is represented by 0 or 1, it can be treated as true or false.
    // For string characters with radix of less than 31, in this case 26 lowercase English alphabets,
    // we can use bitmasking to store if any character exist (1) or not exist (0).
    // Using the left shift operation '<<', we can store 1 at a certain bit position in the number.
    // For example, 'a' is stored as 1 << 'a' - 'a' (1 << 0) as 1, 'b' as 10 binary, 'c' as 100 binary, etc.
    // Note:
    // Reason for 31 is only when using primitive type int (32-bit signed), while primitive type long is 63 (64-bit signed).
    //
    // In bit manipulation,
    // '&' bitwise AND operation can be used to check for duplicate.
    // For example: Using bitmasking mentioned above, "abc" == '111' in binary, "cde" == '11100' in binary.
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
            // Check if 'str' contains duplicate characters, as well as perform bitmasking into 'currentBitmasked'.
            // Optional to use str.get(index) to get the character, saving on the time and space complexity.
            // Below is written for better readability.
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

                // concatenate otherwise.
                bitmaskList.add(bitmaskList.get(i) | currentBitmasked);
                // For all strings, get the longest, using bitCount method to get all the 1s in the bit masked String.
                max = Math.max(max, Integer.bitCount(bitmaskList.get(i) | currentBitmasked));
            }
        }
        return max;
    }
}
