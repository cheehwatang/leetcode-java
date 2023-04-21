package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of string 's'.
// We traverse the string 's' from right to left, having a linear time complexity.
// The append of strings to the StringBuilder have a total time complexity of O(n).
// The conversion of the StringBuilder to the final result string also has a linear time complexity.
//
// Space Complexity : O(n),
// where 'n' is the length of string 's'.
// The StringBuilder and the final result string
// requires memory that grows linearly with the size of the input string 's'.

public class ReverseWordsInAString_TwoPointers {

    // Approach:
    // Using the pointer 'start' to traverse the list from right to left.
    // Once meet a letter (last letter of a word), mark the last letter position as 'end',
    // while continue the traversal of 'start' pointer until the start of the word.
    // Append the word to a StringBuilder using the substring of pointer 'start' and 'end'.

    public String reverseWords(String s) {

        // Use StringBuilder to reduce time and space complexity,
        // as String concatenation is O(n).
        StringBuilder reversedWords = new StringBuilder();
        int start;
        int end;

        // Traverse from right to left using the 'start' pointer.
        for (start = s.length() - 1; start >= 0; start--) {
            // If 'start' meets spaces ' ', we skip the loop, until 'start' meets a letter.
            if (s.charAt(start) == ' ') continue;

            // Once 'start' meets a letter, 'end' is used to mark the end of the word.
            end = start;
            // Traverse the 'start' until the start of the word.
            while (start >= 0 && s.charAt(start) != ' ') start--;

            // Add the word (between 'start' and 'end') to the 'reversedWords'.
            // If it is the first word in 'reversedWords', do not add a leading space " ".
            reversedWords.append(" ").append(s, start + 1, end + 1);
        }
        // Remove the leading space and convert the StringBuilder to String.
        return reversedWords.deleteCharAt(0).toString();
    }
}
