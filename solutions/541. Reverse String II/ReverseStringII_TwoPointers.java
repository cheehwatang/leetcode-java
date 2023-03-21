package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of string 's'.
// As we are using two pointers to reverse the substrings, the worst-case is when we reverse the whole string,
// which scales linearly with the length of string 's'.
// Additionally, the conversion of the string 's' to char array has linear time complexity O(n) as well.
//
// Space Complexity : O(n),
// where 'n' is the length of string 's'.
// The conversion of string 's' to char array, and from char array back to the result string,
// both have a space complexity of O(n).

public class ReverseStringII_TwoPointers {

    // Approach:
    // Basically using two pointers, but we are using index as start, and index + k as end.
    // We convert the String 's' to a char array, then reverse the characters in the array within each k % 2 == 0.

    public String reverseStr(String s, int k) {

        // Convert s into char array.
        char[] chars = s.toCharArray();

        // In each iteration, we increase the index by 2 * k.
        for (int index = 0; index < chars.length; index += 2 * k) {
            // In each loop we will reverse only up to index + k.
            // If we reach the end of the array, then reverse the rest.
            int end = Math.min(index + k, chars.length) - 1;
            reverse(chars, index, end);
        }
        return new String(chars);
    }

    // A private method to reverse the char in the array using the 'start' and 'end' pointer.
    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start++] = chars[end];
            chars[end--] = temp;
        }
    }

}
