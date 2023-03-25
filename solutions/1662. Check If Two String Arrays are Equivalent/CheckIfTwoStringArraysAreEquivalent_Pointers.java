package com.cheehwatang.leetcode;

// Time Complexity  : O(m),
// where 'm' is the product of the length of 'word1' or 'word2' and the length of the words in 'word1' or 'word2',
// as we are traversing through every character in every word in 'word1' and 'word2'.
//
// Space Complexity : O(1),
// as we are only using pointers.

public class CheckIfTwoStringArraysAreEquivalent_Pointers {

    // Approach:
    // Using 4 pointers, 2 for the outer elements in 'word1' and 'word2', and 2 for the inner characters.

    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {
        int word1Outer = 0;
        int word1Inner = 0;
        int word2Outer = 0;
        int word2Inner = 0;
        while (word1Outer < word1.length || word2Outer < word2.length) {
            // If only one pointer reached the end of the array, meaning they form different string.
            if (word1Outer == word1.length || word2Outer == word2.length) return false;

            // Check if they have exactly the same characters.
            if (word1[word1Outer].charAt(word1Inner) != word2[word2Outer].charAt(word2Inner)) return false;

            // For both 'word1' and 'word2', shift the outer pointer to next
            // when the inner pointer reached the end of the element.
            if (word1Inner < word1[word1Outer].length() - 1) {
                word1Inner++;
            } else {
                word1Inner = 0;
                word1Outer++;
            }
            if (word2Inner < word2[word2Outer].length() - 1) {
                word2Inner++;
            } else {
                word2Inner = 0;
                word2Outer++;
            }
        }
        // If all the checks are successful, meaning both 'word1' and 'word2' forms the same string.
        return true;
    }
}
