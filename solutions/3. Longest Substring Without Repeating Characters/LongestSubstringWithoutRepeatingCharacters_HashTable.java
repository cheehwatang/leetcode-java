package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

// Time Complexity  : O(n),
// where 'n' is the length of 's'.
// We use two pointers as sliding window to traverse the string 's' once.
//
// Space Complexity : O(n),
// where 'n' is the length of 's'.
// The HashSet stores has a maximum size of the number of unique characters in string 's'.

public class LongestSubstringWithoutRepeatingCharacters_HashTable {

    // Approach:
    // Using a HashSet to record the occurrence of character and the sliding window technique with two pointers.
    // The two pointers move based on whether there are new unique character found (for the 'front' pointer),
    // and whether there are repeated characters found (for the 'back' pointer).
    //
    // As the 'front' pointer move to the right of the string 's', we check if the character is already in the HashSet.
    // If the 'front' character is in the HashSet, then move the 'back' pointer, remove the 'back' characters
    // from the HashSet until the 'front' character is removed from the HashSet.
    // With that, we have the length of the current substring without repeating characters.

    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int max = 0;
        // With both 'front' and 'back' starting at 0, the size of the window is 'front' - 'back' + 1 == 1.
        // If s.length() == 0, the for-loop will terminate instantly.
        for (int front = 0, back = 0; front < s.length(); front++) {
            char character = s.charAt(front);
            // If the character is already in the set (repeated), then remove the characters using the 'back' pointer
            // until a character that is not in the set.
            while (set.contains(character)) {
                set.remove(s.charAt(back));
                back++;
            }
            set.add(character);
            // Update 'max' if the size of the sliding window is greater than 'max'.
            max = Math.max(max, front - back + 1);
        }
        return max;
    }
}
