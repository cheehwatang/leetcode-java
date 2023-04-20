package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of string 's'.
// The string split() method and the StringBuilder.toString() method has a time complexity of O(n),
// while appending all words with the stringBuilder.append() has a total time complexity of O(n).
//
// Space Complexity : O(n),
// where 'n' is the length of string 's'.
// The splitting of string 's' into array of 'words', the StringBuilder and the final result string
// requires memory that grows linearly with the size of the input string 's'.

public class ReverseWordsInAString_StringBuilder {

    // Approach:
    // Use the String functions to trim the leading and trailing spaces, then split into words and store in an array.
    // Append the words in the reverse order from the array, with spaces " " in between.

    public String reverseWords(String s) {
        // .trim() removes leading and trailing spaces.
        // "\\s+" is regex for spaces (one or more).
        String[] words = s.trim().split("\\s+");

        // Use StringBuilder to reduce time and space complexity,
        // as String concatenation is O(n).
        StringBuilder stringBuilder = new StringBuilder(words[words.length - 1]);
        for (int i = words.length - 2; i >= 0; i--) {
            stringBuilder.append(" ").append(words[i]);
        }

        return stringBuilder.toString();
    }
}
