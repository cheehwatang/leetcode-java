package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'palindrome'.
// We traverse half of the string 'palindrome' to find characters that are not 'a'.
// Additionally, the conversion of the string 'palindrome' to char array, and conversion of char array to string
// has linear time complexity.
//
// Space Complexity : O(n),
// where 'n' is the length of 'palindrome'.
// We convert the string 'palindrome' to char array, and convert the char array to string to return the result.

public class BreakAPalindrome {

    // Approach:
    // Traverse the string while checking for 3 scenarios:
    // In Example 1: The first encounter of a letter in the string that is not 'a', replace with 'a',
    //               as it is lexicographically smallest.
    // In Example 2: If all the halves are made up of 'a', then replace the last one with 'b',
    //               to make it lexicographically smallest ("aabab" is lexicographically smaller than "babaa").
    // In Example 3: If the string only consists of one character, then not possible to make non-palindrome.

    public String breakPalindrome(String palindrome) {
        // If length is 1, return empty string (Example 3).
        if (palindrome.length() == 1) return "";

        // Make the string into char[] to make it easier to change character.
        char[] chars = palindrome.toCharArray();
        int length = palindrome.length();

        // For the first half, the first encounter of the letter that is not 'a' is replaced with 'a' (Example 1).
        for (int i = 0; i < length / 2; i++) {
            if (chars[i] != 'a') {
                chars[i] = 'a';
                return String.valueOf(chars);
            }
        }
        // If no non-'a' that is found and length is more than one, replace the last character with 'b' (Example 2).
        chars[length - 1] = 'b';
        return String.valueOf(chars);
    }
}
