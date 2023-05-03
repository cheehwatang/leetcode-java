package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of String 's'.
// The conversion of String 's' to char array has linear time complexity.
// Then, we traverse the char array with the two pointers approach, which has a linear time complexity.
// When including the characters swapping when reversing the words, in total it would be linear time complexity as well.
// Finally, the conversion of the char array to String results in another linear time complexity.
// To be specific, it would approximate to O(4*n), but we simplify to O(n).
//
// Space Complexity : O(n),
// where 'n' is the length of String 's'.
// The toCharArray() method and the String() method has a linear space complexity.

public class ReverseWordsInAStringIII_TwoPointers {

    // Approach:
    // Using two pointers, 'start' and 'end', each time 'end' reaches a space,
    // we reverse the words between the 'start' and 'end' pointers.
    // After each reversal, the 'start' pointer is repositioned to the next character after the 'end' pointer.
    // To help with the word reversal, we convert the String 's' to a char array,
    // then we swap the letters for the characters between the 'start' and 'end' pointers.

    public String reverseWords(String s) {

        // Convert String 's' to a char array.
        char[] chars = s.toCharArray();

        int start = 0;
        int end;
        for (end = 0; end <= chars.length; end++) {
            // When 'end' reaches a space character ' ', reverse the words from 'start' to 'end' - 1 index in 'chars'.
            if (end == chars.length || chars[end] == ' ') {
                reverse(chars, start, end - 1);
                // reset the start for the next word.
                start = end + 1;
            }
        }

        return new String(chars);
    }

    // A private method to reverse the char in the array using the 'start' and 'end' pointer.
    private void reverse(char[] c, int start, int end) {
        while (start < end) {
            char tmp = c[end];
            c[end--] = c[start];
            c[start++] = tmp;
        }
    }
}
