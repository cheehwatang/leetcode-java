package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'word1' or 'word2'.
// Using StringBuilder, we are appending each word to the StringBuilder.
// If we are using normal String concatenation, then the time complexity would be O(n^2).
//
// Space Complexity : O(m),
// where 'm' is the product of the length of 'word1' or 'word2' and the length of the words in 'word1' or 'word2',
// as we are not creating new String for each append.
// If we are using normal String concatenation, then the time complexity would be O(m^2),
// since we are creating new String for each concatenation.

public class CheckIfTwoStringArraysAreEquivalent_String {

    // Approach:
    // Concatenated the elements for both 'word1' and 'word2' to check if they form the same string.
    // Here, we use StringBuilder to lower the time complexity from O(n^2) to O(n).

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        StringBuilder string1 = new StringBuilder();
        StringBuilder string2 = new StringBuilder();
        for (String str : word1) string1.append(str);
        for (String str : word2) string2.append(str);
        return string1.toString().equals(string2.toString());
    }
}
