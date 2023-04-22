package com.cheehwatang.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Time Complexity  : O(n),
// where 'n' is the length of string 's'.
// The string split() method, the Collections.reverse() method, and String.join() method
// has a time complexity of O(n).
//
// Space Complexity : O(n),
// where 'n' is the length of string 's'.
// The splitting of string 's' into array of 'words', and the final result string
// requires memory that grows linearly with the size of the input string 's'.

public class ReverseWordsInAString_Collections {

    // Approach:
    // Use the String functions to trim the leading and trailing spaces, then split into words and store in a list.
    // With Collections package, reverse the word order in the list.
    // Use the String.join with " " as the delimiter to produce the reversedWords.

    public static String reverseWords(String s) {
        // .trim() removes leading and trailing spaces.
        // "\\s+" is regex for spaces (one or more).
        List<String> words = Arrays.asList(s.trim().split("\\s+"));

        // Reverse the strings in the 'words' list.
        Collections.reverse(words);

        // Join the words with a single space between the words.
        return String.join(" ", words);
    }
}
