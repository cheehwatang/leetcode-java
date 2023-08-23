package com.cheehwatang.leetcode;

// Time Complexity  : O(n^3),
// where 'n' is the length of string 's'.
// We traverse the string 's' with a nested for-loop to check every substrings if they are palindromes,
// with each checking for palindromes introducing an addition O(n) time complexity.
//
//
// Space Complexity : O(n),
// where 'n' is the length of string 's'.
// The maximum length of the result is length 'n'.

public class LongestPalindromicSubstring_TwoPointers1 {

    // Approach:
    // When it comes to substring, first came to mind is two pointers.
    // For palindrome, we can check for palindrome from outside in or from centre out.
    // For each character, we check for the longest possible palindrome from the start of 's' to that character (outside in).

    public String longestPalindrome(String s) {

        // Rather than storing the substring when a longer palindrome is found,
        // it is lower time-complexity and lower memory-complexity when storing just the pointers indicating the palindrome.
        // We only get the substring at the end when returning the result.
        int start = 0;
        int end = 0;
        int maxLength = 1;
        for (int right = 1; right < s.length(); right++) {
            int left = 0;
            // Continue to check for palindrome only if the pointers is greater than 'maxLength'.
            while (left < right && right - left + 1 > maxLength) {
                if (isPalindrome(s, left, right)) {
                    maxLength = right - left + 1;
                    start = left;
                    end = right;
                }
                left++;
            }
        }
        // The substring method is from start (inclusive) to end (exclusive).
        // So we need "end + 1" to include the character at 'end'.
        return s.substring(start, end + 1);
    }

    // Method to check for palindrome in the substring between 'start' and 'end'.
    private boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) return false;
        }
        return true;
    }
}
