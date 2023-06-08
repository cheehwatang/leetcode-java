package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of the string 'sentence'.
// We traverse the string 'sentence' to add the characters to the counting array.
//
// Space Complexity : O(1),
// as the counting array has a fixed maximum size of 26.

public class CheckIfTheSentenceIsPangram_Counting {

    // Approach:
    // Use a Counting array (of size 26) to keep track of the alphabet frequency that appeared in 'sentence'.
    // If any of the frequency in the counting array is 0, return false.
    // This works as there no spaces, other symbols and only consist of lowercase letters. Other approach needed otherwise.

    public boolean checkIfPangram(String sentence) {
        // A quick check. If the String length is less than 26 characters, we know it is not a pangram,
        // given there are no spaces in the 'sentence'.
        if (sentence.length() < 26) return false;

        int[] alphabets = new int[26];
        // Record the frequency of each character in the counting array.
        for (int i = 0; i < sentence.length(); i++) {
            alphabets[sentence.charAt(i) - 'a']++;
        }

        // Traverse 'alphabets' to check if any frequency is 0.
        for (int frequency : alphabets) {
            // If any character is not recorded, then 'sentence' is not pangram.
            if (frequency == 0) return false;
        }
        return true;
    }
}
