package com.cheehwatang.leetcode;

// Time Complexity  : O(n^2),
// where 'n' is the length of string 's'.
// We traverse the string 's', with each index checking the longest possible palindrome
// with the index as the center of the palindrome.
//
// Space Complexity : O(n),
// where 'n' is the length of string 's'.
// The maximum length of the result is length 'n'.

public class LongestPalindromicSubstring_TwoPointers2 {

    // Approach:
    // When it comes to substring, first came to mind is two pointers.
    // For palindrome, we can check for palindrome from outside in or from centre out.
    // For each character, we check for the longest possible palindrome when expanding from the centre.

    public String longestPalindrome(String s) {

        // Rather than storing the substring when a longer palindrome is found,
        // it is lower time-complexity and lower memory-complexity when storing just the pointers indicating the palindrome.
        // We only get the substring at the end when returning the result.
        int start = 0;
        int end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Check for the longer palindrome, for both odd and even length of palindrome.
            int length = Math.max(expandAroundCentre(s, i, i), expandAroundCentre(s, i, i + 1));

            // If a longer palindrome is found, record the start and end index.
            if (length > end - start + 1) {
                start = i - (length - 1) / 2;
                end = i + length / 2;
            }
        }
        // The substring method is from start (inclusive) to end (exclusive).
        // So we need "end + 1" to include the character at 'end'.
        return s.substring(start, end + 1);
    }

    // Method for checking palindrome when expanding from the centre.
    private int expandAroundCentre(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // As the while loop when the pointers are at the non-palindromic position (-1 for left, +1 for right),
        // we subtract 2.
        // However, as the length is end - start + 1, the length equation below is supposedly
        // right - left - 2 + 1.
        return right - left - 1;
    }
}
