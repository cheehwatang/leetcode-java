package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n + m),
// where 'n' is the length of 'ransomNote', and 'm' is the length of 'magazine'.
// First, we iterate through 'magazine' to record the frequency of each alphabet.
// Then, we iterate through 'ransomNote' to check if we can make the letter from 'magazine'.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the size of 'ransomNote' and 'magazine', with space complexity of O(1).
// Note that if we use forEach and convert the string to char array, then the space complexity is O(n + m).

public class RansomNote_HashTable {

    // Approach:
    // Use hash table to record the frequency of each character in 'magazine'.
    // When checking each character in 'ransomNote', reduce the count.
    // If the count for any character reaches zero, it means we have insufficient characters from 'magazine'.

    public boolean canConstruct(String ransomNote, String magazine) {
        // Too few characters from 'magazine'.
        if (magazine.length() < ransomNote.length()) return false;

        // Using a HashMap to record the count of characters found in 'magazine'.
        Map<Character, Integer> charCount = new HashMap<>();

        // Increase the count by one for each occurrence found in 'magazine'.
        for (int i = 0; i < magazine.length(); i++) {
            char character = magazine.charAt(i);
            // If character is in the HashMap, increase the count by 1,
            // else record a new key-value pair with character (key) with 1 (value).
            int count = charCount.getOrDefault(character, 0) + 1;
            // Update the value in the HashMap.
            charCount.put(character, count);
        }

        // Reduce the count as found in 'ransomNote'.
        // If the count is less than 1, there is insufficient characters from 'magazine'.
        for (int i = 0; i < ransomNote.length(); i++) {
            char character = ransomNote.charAt(i);
            int count = charCount.getOrDefault(character, 0);
            if (count < 1) return false;
            else charCount.put(character, count - 1);
        }
        return true;
    }
}
