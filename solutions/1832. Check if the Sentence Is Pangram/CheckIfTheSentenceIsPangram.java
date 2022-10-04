package com.cheehwatang.leetcode;

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

public class CheckIfTheSentenceIsPangram {

    // Approach:
    // For each of the 26 alphabets, check if it is found in the 'sentence'.

    public boolean checkIfPangram(String sentence) {

        // A quick check. If the String length is less than 26 characters, we know it is not a pangram,
        // given there are no spaces in the 'sentence'.
        if (sentence.length() < 26) {
            return false;
        }

        // Traversing the alphabet from 'a' to 'z', check if any is in 'sentence'.
        // If the index is less than 0, return false.
        for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
            if (sentence.indexOf(alphabet) < 0) {
                return false;
            }
        }
        // If after checking all 26 alphabets and not false is returned, return true.
        return true;
    }
}
