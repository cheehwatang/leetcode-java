package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem:
 * Given a string 'sentence' containing only lowercase English letters,
 * return 'true' if the 'sentence' is a pangram, and return false otherwise.
 * A pangram is a sentence where every letter of the English alphabet appears at least once.
 *
 *
 * Example 1:
 * Input    : "thequickbrownfoxjumpsoverthelazydog"
 * Output   : true
 *
 *
 * Example 2:
 * Input    : "leetcodeisawesome"
 * Output   : 0
 *
 *
 * @author Chee Hwa Tang
 */

public class CheckIfTheSentenceIsPangram_HashSet {

    // Approach:
    // Use a HashSet to keep track of the alphabets that appeared in 'sentence'.
    // If the set has size of 26, it means all the alphabets are in 'sentence'.
    // This works as there no spaces, other symbols and only consist of lowercase letters. Other approach needed otherwise.

    public boolean checkIfPangram(String sentence) {

        // A quick check. If the String length is less than 26 characters, we know it is not a pangram,
        // given there are no spaces in the 'sentence'.
        if (sentence.length() < 26) {
            return false;
        }

        // Record each character in HashSet.
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < sentence.length(); i++) {
            set.add(sentence.charAt(i));
        }
        // If the HashSet has size of 26, then the 'sentence' is a pangram.
        return set.size() == 26;
    }
}
