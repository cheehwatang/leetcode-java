package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

// Time Complexity  : O(n),
// where 'n' is the length string 's'.
// We traverse the whole string to not find duplicate letters in the worst-case.
//
// Space Complexity : O(n),
// where 'n' is the length string 's'.
// We traverse the whole string to not find duplicate letters in the worst-case,
// storing 'n' number of characters in the HashSet.

public class FirstLetterToAppearTwice_HashTable {

    // Approach:
    // Using HashTable to record character's first occurrence.
    // If the subsequent letter appears when it is already in the HashTable,
    // we have found the first char that appear twice.

    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (set.contains(current))
                return current;
            else
                set.add(current);
        }
        // As we returned the result in the during the check, this is mainly to prevent compile-time error.
        // Otherwise, it can be used to show that no characters appears twice in the string.
        return '!';
    }
}
