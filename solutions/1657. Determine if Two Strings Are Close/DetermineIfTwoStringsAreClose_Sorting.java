package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n logn),
// where 'n' is the length of 'word1' or 'word2'.
// We first traverse both words to count the frequency of the characters, with O(n) time complexity.
// Then, we use Arrays.sort() function which has O(n logn) time complexity.
// Lastly, we use Arrays.equals() function to compare the counting array, with O(n) time complexity.
// Thus, the time complexity is O(n logn), when the words are made up of unique characters.
//
// Space Complexity : O(26),
// as we use counting array to count the frequency of each unique characters.

public class DetermineIfTwoStringsAreClose_Sorting {

    // Approach:
    // To understand the approach, it is worth thinking the strings as a distribution of letter by frequency.
    // For example:
    // "aabcccd" would be [2,1,3,1].
    //
    // With Operation 1, the frequency distribution would remain the same,
    // as we are only swapping position of the letters.
    // Continuing the above example with Operation 1,
    // "baacccd" would be [2,1,3,1].
    //
    // With Operation 2, the frequency distribution would change, with 2 letters changing position.
    // Continuing the above example with Operation 2,
    // "bccaaad" would be [3,1,2,1].
    // If we sort the frequency list before and after Operation 2, both would yield [1,1,2,3].
    // Note however that we would need to check if the same set of unique characters exist in both words.
    // For example with "aa" and "bb", it would pass both checks.
    //
    // With that, we would use a counting array to count the frequency of the unique characters.
    // Next, we check if both words has the same set of characters.
    // Lastly, we sort the counting array and check if they are the same.
    // If they are the same, then the two strings are close.

    public boolean closeStrings(String word1, String word2) {
        // If 'word1' and 'word2' are of different length, then they are not close.
        if (word1.length() != word2.length()) return false;

        int n = word1.length();

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        // Traverse both words and record the frequency.
        for (int i = 0; i < n; i++) {
            count1[word1.charAt(i) - 'a']++;
            count2[word2.charAt(i) - 'a']++;
        }

        // The strings are not close if they are made up of different character set.
        for (int i = 0; i < 26; i++) {
            if ((count1[i] == 0 && count2[i] != 0) || (count1[i] != 0 && count2[i] == 0)) return false;
        }

        // Sort the frequencies of the letters.
        Arrays.sort(count1);
        Arrays.sort(count2);
        // Return true if the sorted frequency is the same.
        return Arrays.equals(count1, count2);
    }
}
