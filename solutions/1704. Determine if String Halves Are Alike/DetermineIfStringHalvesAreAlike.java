package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 's'.
// We traverse the string 's' once to count the vowels in the two halves.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input string.

public class DetermineIfStringHalvesAreAlike {

    // Approach:
    // We traverse the two halves to count the number of vowels.
    // Return true if the vowel counts are equal.

    public boolean halvesAreAlike(String s) {
        int n = s.length();

        int count1 = 0;
        int count2 = 0;
        // We only need to traverse half of the String 's',
        // since we can get the character of the second half with "i + n / 2".
        for (int i = 0; i < n / 2; i++) {
            // Add to the count if we found a vowel for each respective halves.
            if (isVowel(s.charAt(i))) count1++;
            if (isVowel(s.charAt(i + n / 2))) count2++;
        }
        // If the counts for both halves are equal, return true.
        return count1 == count2;
    }

    // Helper method to determine if the character is vowel.
    // This helps with readability.
    private boolean isVowel(char character) {
        final String VOWELS = "aeiouAEIOU";
        // If the index is >= 0, then 'character' is a vowel.
        // If the index is -1, then 'character' is not a vowel.
        return VOWELS.indexOf(character) != -1;
    }
}
