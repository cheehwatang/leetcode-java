package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'letters'.
// We traverse 'letters' once to find the first letter that is lexicographically greater than 'target'.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input size.

public class FindSmallestLetterGreaterThanTarget {

    // Approach:
    // As 'letters' is sorted in non-descending order,
    // we can traverse 'letters' to find the first letter that is lexicographically greater 'target'.
    // If none is found, return the first letter.

    public char nextGreatestLetter(char[] letters, char target) {
        for (char letter : letters) {
            // If the letter is greater than target, return letter.
            if (letter - target > 0) return letter;
        }
        return letters[0];
    }
}
