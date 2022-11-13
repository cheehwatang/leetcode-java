package com.cheehwatang.leetcode;

// Time Complexity  : O(m ^ n),
// where 'm' is the length of the words in 'words', and 'n' is the length of the string array 'words'.
// For each word in 'words' (of length n), other than the first at index 0, we check the differences between the letters
// for both strings (of length m) in the 'isDifferent()' function.
//
// Space Complexity : O(1),
// as we are only checking through each letters without using any HashMap.

public class OddStringDifference {

    // Approach:
    // Compare all the words in 'words' with the first word, words[0],
    // to evaluate find any or all is different to the first word.
    // If all is different, then we know the first word is the odd one out.
    // Otherwise, there will only be one word that is different to the first word.
    // Since we are only searching for the odd word, we can just count the matches and note the mismatched word.
    //
    // Credit: @ivey

    public String oddString(String[] words) {
        // 'matchWithFirstWord' to keep track on the number of word that matches the first word, words[0].
        int matchWithFirstWord = 0;
        // 'mismatchIndex' to keep track on the word that is different to the first word, words[0].
        int mismatchIndex = -1;

        for (int i = 1; i < words.length; i++) {
            if (isDifferent(words[0], words[i]))
                mismatchIndex = i;
            else
                matchWithFirstWord++;
        }
        // If the first word, words[0], is the odd one out,
        // then the 'mismatchIndex' will continue to update while 'matchWithFirstWord' remains at 0.
        // If there are multiple matches with the first word, words[0], then 'mismatchIndex' will only be updated once.
        return matchWithFirstWord > 0 ? words[mismatchIndex] : words[0];
    }

    // Function to check if the two strings have different "difference integers".
    // Return true if the two are different, and return false otherwise.
    private boolean isDifferent(String a, String b) {
        for (int i = 1; i < a.length(); i++) {
            if (a.charAt(i) - a.charAt(i - 1) != b.charAt(i) - b.charAt(i - 1))
                return true;
        }
        return false;
    }
}
