package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'word'.
// For each of the methods used, toUpperCase() and toLowerCase(),
// we create new strings before comparing the strings if they are equal.
// Additionally, the string concatenation also creates a new string.
//
// Space Complexity : O(n),
// where 'n' is the length of 'word'.
// Both methods, toUpperCase() and toLowerCase(), create new strings.

public class DetectCapital {

    // Approach:
    // The naive approach is to check if:
    // 1. The full uppercase of the 'word' is equal.
    // 2. The full lowercase of the 'word' is equal.
    // 3. The uppercase of first letter, and lowercase of the remaining letters are equal.

    public boolean detectCapitalUse(String word) {

        // Check the first and second conditions.
        if (word.equals(word.toUpperCase()) || word.equals(word.toLowerCase()))
            return true;

        // Check the third condition.
        return word.equals(word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase());
    }
}
