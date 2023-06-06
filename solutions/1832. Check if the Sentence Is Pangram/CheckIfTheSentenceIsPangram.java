package com.cheehwatang.leetcode;

// Time Complexity  : O(26 * n),
// where 'n' is the length of the string 'sentence'.
// For each alphabet, we use String.indexOf() method to check if the alphabet is in 'sentence'.
// String.indexOf() has time complexity of O(n).
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input size.

public class CheckIfTheSentenceIsPangram {

    // Approach:
    // For each of the 26 alphabets, check if it is found in the 'sentence'.

    public boolean checkIfPangram(String sentence) {

        // A quick check. If the String length is less than 26 characters, we know it is not a pangram,
        // given there are no spaces in the 'sentence'.
        if (sentence.length() < 26) return false;

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
