package com.cheehwatang.leetcode;

// Time Complexity  : O(n^2),
// where 'n' is the length of string 's'.
// We traverse the string 's' with nested for-loop.
//
// Space Complexity : O(n^2),
// where 'n' is the length of string 's'.
// We use a table to record if the particular 'start' and 'end' pointer substring is a palindrome.

public class LongestPalindromicSubstring_DynamicProgramming {

    // Approach:
    // Using dynamic programming to store the palindrome was found.
    // If the inner substring is a palindrome, and if 'start' and 'end' pointers have the same character,
    // we can be sure that the substring from 'start' to 'end' is a palindrome.
    // For Example:
    // s = "racecar"
    // Checking each character, we know 1 character itself is a palindrome, here we focus on "e" in the middle.
    // - "cec", we know "e" is a palindrome, and both "c" and "c" is the same, so this is a palindrome.
    // - "aceca", we know "cec" is a palindrome from previous check, and both "a" and "a" is the same.
    // - "racecar", we know "aceca" is a palindrome, and both "r" and "r" is the same,
    //
    // So we have found the longest palindrome, by building a table from length of 1 to s.length().

    public String longestPalindrome(String s) {
        int n = s.length();
        // The row represents the 'start' and column represents the 'end' pointer.
        boolean[][] table = new boolean[n][n];

        // Rather than storing the substring when a longer palindrome is found,
        // it is lower time-complexity and lower memory-complexity when storing just the pointers indicating the palindrome.
        // We only get the substring at the end when returning the result.
        int start = 0;
        int end = 0;
        for (int length = 0; length < n; length++) {
            for (int index = 0; index + length < n; index++) {
                // 'index' indicates the 'start' and 'index' + 'length' indicates the 'end'.
                // Check if charAt(start) == charAt(end), and whether the inner substring is a palindrome.
                table[index][index + length] = s.charAt(index) == s.charAt(index + length) &&
                        (length < 2 || table[index + 1][index + length - 1]);
                // If it is a palindrome, update the 'start' and 'end'.
                if (table[index][index + length] && length > end - start) {
                    start = index;
                    end = index + length;
                }
            }
        }
        // The substring method is from start (inclusive) to end (exclusive).
        // So we need "end + 1" to include the character at 'end'.
        return s.substring(start, end + 1);
    }
}
