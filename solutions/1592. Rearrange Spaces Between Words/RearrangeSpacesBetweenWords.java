package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given a String 'text' of words with varied number of spaces,
 * return a String with all the spaces rearranged in the following conditions:
 * 1. Equal number of spaces between every word.
 * 2. Ensure the spaces between words are maximized.
 * 3. Place the remaining spaces at the end of the text, thus returning a String of same length as 'text'.
 * Note that all the words are in lower case, and the 'text' has at least one word in it.
 *
 *
 * Example 1:
 * Input : text = "   leetcode is awesome   "
 * Output: "leetcode    is    awesome"
 *
 * Example 2:
 * Input : text = " keep up   the   good work  "
 * Output: "keep  up  the  good  work   "
 *
 * @author Chee Hwa Tang
 */

public class RearrangeSpacesBetweenWords {

    // Approach:
    // Count the spaces and words in the 'text', then determine the count of spaces between words and trailing spaces.
    // Then create a new String using the determined counts.

    public String reorderSpaces(String text) {

        // String.trim() removes all the leading and trailing spaces.
        // String.split("\\s+") provide an array of words,
        // where words are determined as non-space characters separated by spaces.
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
