package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'text'.
// The String.split() method, String.chars() and filter(), and the string concatenation of the result string,
// all has linear time complexity.
//
// Space Complexity : O(n),
// where 'n' is the length of 'text'.
// The splitting of the 'text' to form a string array with approximately 'n' length.
// The string concatenation the form the result string has the same size as the input 'text'.

public class RearrangeSpacesBetweenWords {

    // Approach:
    // Count the spaces and words in the 'text'.
    // Then, we determine the count of spaces between words and trailing spaces.
    // Then create a new String using the determined counts.

    public String reorderSpaces(String text) {

        // String.trim() removes all the leading and trailing spaces.
        // String.split("\\s+") provide an array of words,
        // where words are determined as non-whitespace characters separated by spaces.
        String[] words = text.trim().split("\\s+");

        // Every element in 'words' array is a word.
        int wordCount = words.length;

        // .chars() returns a stream of char.
        // .filter(predicate) returns a stream of char that fulfills the predicate (in this case ch == ' ').
        // .count() returns the counts of elements in the stream.
        // Putting all together, it means counting the space char ' ' in the 'text'.
        int spaces = (int) text.chars().filter(ch -> ch == ' ').count();

        // Determine the maximum spacesBetweenWords. If only 1 word, spacesBetweenWords is 0.
        int spacesBetweenWords = wordCount > 1 ? spaces / (wordCount - 1) : 0;

        // Determine how many trailingSpaces remains.
        int trailingSpaces = spaces - spacesBetweenWords * (wordCount - 1);

        // First join all the words with the " " of spacesBetweenWords, then all the remaining trailingSpaces.
        return String.join(" ".repeat(spacesBetweenWords), words) + " ".repeat(trailingSpaces);
    }
}
