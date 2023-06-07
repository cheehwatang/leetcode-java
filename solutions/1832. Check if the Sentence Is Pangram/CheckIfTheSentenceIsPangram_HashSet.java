package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

// Time Complexity  : O(n),
// where 'n' is the length of the string 'sentence'.
// We traverse the string 'sentence' to add the characters to the HashSet.
//
// Space Complexity : O(1),
// as the HashSet has a fixed maximum size of 26.

public class CheckIfTheSentenceIsPangram_HashSet {

    // Approach:
    // Use a HashSet to keep track of the alphabets that appeared in 'sentence'.
    // If the set has size of 26, it means all the alphabets are in 'sentence'.
    // This works as there no spaces, other symbols and only consist of lowercase letters. Other approach needed otherwise.

    public boolean checkIfPangram(String sentence) {
        // A quick check. If the String length is less than 26 characters, we know it is not a pangram,
        // given there are no spaces in the 'sentence'.
        if (sentence.length() < 26) return false;

        // Record each character in HashSet.
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i));
        }
        // If the HashSet has size of 26, then the 'sentence' is a pangram.
        return set.size() == 26;
    }
}
