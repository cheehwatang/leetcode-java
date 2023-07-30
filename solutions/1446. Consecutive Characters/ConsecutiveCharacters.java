package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of string 's'.
// We traverse the string 's' to determine the max consecutive characters.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input.

public class ConsecutiveCharacters {

    // Approach:
    // We traverse the string 's', counting by comparing the current character with the previous character,
    // increase the count if the same,
    // or reset the count to 1 if the characters are different.
    // For each character, we compare the max with the current count
    // to get the maximum length of consecutive characters.

    public int maxPower(String s) {
        int max = 1, count = 1;
        // Traverse the string 's', starting at index 1,
        // since the first character always yields count of 1.
        for (int i = 1; i < s.length(); i++) {
            // If the current character is the same as the previous character,
            // increase 'count' by 1, and update the 'max' value.
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
                max = Math.max(max, count);
            }
            // If the characters are different, reset the 'count' to 1.
            else {
                count = 1;
            }
        }
        // Once we traverse the string, the 'max' is the number of characters in the longest consecutive characters.
        return max;
    }
}
