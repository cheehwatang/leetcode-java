package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem:
 * Given a string 's' consisting of lowercase English letters, return the first letter to appear twice,
 * from left to right of the string.
 *
 *
 * Example 1:
 * Input    : s = "leetcode"
 * Output   : 'e'
 *
 *
 * Example 2:
 * Input    : s = "helloworld"
 * Output   : 'l'
 * Explanation:
 * Characters such as 'l' and 'o' appears twice, but 'l' appears twice first.
 *
 *
 * @author Chee Hwa Tang
 */

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
