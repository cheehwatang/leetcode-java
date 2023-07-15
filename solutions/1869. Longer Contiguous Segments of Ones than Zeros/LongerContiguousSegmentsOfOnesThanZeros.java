package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 's'.
// We traverse the string 's' once to count the consecutive substring.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input string.

public class LongerContiguousSegmentsOfOnesThanZeros {

    // Approach:
    // We traverse the string 's' to compare the current character with the previous character,
    // and use two variables to record the longest length of consecutive '0' and '1' respectively.
    // If the two characters are the same, increase the count.
    // Else, reset the count to 1.
    // For each character, we check whether it is '0' or '1', and update the max respectively.

    public boolean checkZeroOnes(String s) {
        int max0 = 0, max1 = 0, count = 1;
        // Traverse the string 's',
        for (int i = 0; i < s.length(); i++) {
            // and increase 'count' by 1 if the current character is the same as the previous character.
            if (i > 0 && s.charAt(i) == s.charAt(i - 1))
                count++;
            // If the two characters are different, reset 'count' to 1.
            else
                count = 1;

            // If the character is '0', update 'max0'.
            if (s.charAt(i) == '0') max0 = Math.max(max0, count);
            // If the character is '1', update 'max1'.
            else max1 = Math.max(max1, count);
        }
        // Return true if 'max1' is greater than 'max0'.
        return max1 > max0;
    }
}
