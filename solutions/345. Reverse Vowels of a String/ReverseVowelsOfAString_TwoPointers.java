package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of the string 's'.
// We traverse the string from both ends until they meet,
// thus the time needed grows linearly with the length of string 's'.
//
// Space Complexity : O(n),
// where 'n' is the length of the string 's'.
// Though the checking and swapping has a constant space complexity O(1),
// the conversion of String 's' to char array, and conversion of char array to result string
// have space complexity of O(n), which scales linearly with the length of the input string.

public class ReverseVowelsOfAString_TwoPointers {

    // Approach:
    // Use two pointers to traverse from left and right towards to center.
    // Swap when both position contains vowels "aeiouAEIOU".
    //
    // To check if the character is not vowel, we can either:
    // 1. have a separate method to compare the character with each of the characters in "aeiouAEIOU", or
    // 2. use the String.contains() method to check if the character is found in the string "aeiouAEIOU".
    // Here, we use the former method to check.

    public String reverseVowels(String s) {

        // Convert the string to charArray.
        char[] chars = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;

        // When both pointers meet, we know all the vowels are swapped.
        while (left < right) {
            // If chars[left] is not vowel, continue to move right.
            while (left < right && notVowel(chars[left])) {
                left++;
            }
            // If chars[right] is not vowel, continue to move left.
            while (left < right && notVowel(chars[right])) {
                right--;
            }

            // Swap the vowels.
            if (left < right) {
                char temp = chars[left];
                chars[left++] = chars[right];
                chars[right--] = temp;
            }
        }
        // Convert the char array to string before returning it.
        return new String(chars);
    }

    // Return true if char is not a vowel.
    private boolean notVowel(char c) {
        return c != 'a' && c != 'e' && c != 'i' && c != 'o' && c != 'u'
                && c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U';
    }
}
