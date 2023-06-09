package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of the string 'sentence'.
// We traverse the string 'sentence' to add the characters to the counting array.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent on the input size.

public class CheckIfTheSentenceIsPangram_BitManipulation {

    // Approach:
    // With the string can only have a maximum of 26 unique characters,
    // we can use an integer to record if any character is present using bit manipulation.
    // Using the bitwise OR "|" operator, along with the bitwise left shift "<<" operator,
    // we could use an integer to record if the character is present, with 1 bit as indicator.
    // Once all recorded, we compare if the result is equal to the number "(1 << 26) - 1",
    // to check if all the alphabets are present in 'sentence'.

    public boolean checkIfPangram(String sentence) {
        // A quick check. If the String length is less than 26 characters, we know it is not a pangram,
        // given there are no spaces in the 'sentence'.
        if (sentence.length() < 26) return false;

        int seen = 0;
        for (int i = 0; i < sentence.length(); i++) {
            // Using the bitwise OR "|" operator to store that the alphabet is present.
            seen = seen | (1 << sentence.charAt(i) - 'a');
        }
        return seen == (1 << 26) - 1;
    }
}
