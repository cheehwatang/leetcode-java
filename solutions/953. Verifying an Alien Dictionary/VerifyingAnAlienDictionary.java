package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n),
// where 'n' is the number of letters in every word in 'words'.
// We check every word and compare the letters with the letters of the previous word in 'words'.
//
// Space Complexity : O(1),
// as we only use a hash map of size 26 for the alphabets, which is independent of the size of 'words'.

public class VerifyingAnAlienDictionary {

    // Approach:
    // Using a Hash Map or a Character Array to store the order of the alien alphabets in 'order',
    // with the first letter correspond to index 0, second letter to index 1 and so on.
    // Here we use HashMap for better readability. Performance would be similar for both.
    // Once we have the alphabets mapped to their order, we check each consecutive words in 'words'
    // whether the word in lexicographically greater than the previous word.
    // Lexicographically greater is determined by comparing each letter, if the current word's is greater.
    // If the letters are the same, then the word with the longer length is greater.

    public boolean isAlienSorted(String[] words, String order) {
        // Map the order of the alphabets in a HashMap.
        Map<Character, Integer> map = new HashMap<>(26);
        for (int i = 0; i < order.length(); i++)
            map.put(order.charAt(i), i);

        // Compare each consecutive pair of words.
        for (int i = 1; i < words.length; i++)
            // Return false if the previous word is greater than the current word.
            if (greater(words[i - 1], words[i], map)) return false;

        // Return true if all the pairs are checked.
        return true;
    }

    // Helper method to extract the function to compare the two input words
    // if the first word is lexicographically greater than the second word.
    private boolean greater(String word1, String word2, Map<Character, Integer> map) {
        int n = word1.length(), m = word2.length();

        // Compare each letter of the words.
        // Note that we are comparing up to the length of the short word, to prevent IndexOutOfBoundsError.
        for (int i = 0; i < n && i < m; i++) {
            // Only compare the letters if they are different.
            if (word1.charAt(i) != word2.charAt(i))
                // If the letter of the first word is greater than the letter of the second word, return true.
                // Else, return false.
                return map.get(word1.charAt(i)) > map.get(word2.charAt(i));
        }
        // If all the letters are the same, return if the first word is longer than the second word.
        return n > m;
    }
}
