package com.cheehwatang.leetcode;

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

public class FirstLetterToAppearTwice_Counting {

    // Approach:
    // Using HashTable to record character's first occurrence.
    // If the subsequent letter appears when it is already in the HashTable,
    // we have found the first char that appear twice.

    public char repeatedCharacter(String s) {
        // Can use either int[] with default as 0, or boolean[] with default as false, also with loser memory usage.
        boolean[] count = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (count[current - 'a'])
                return current;
            else
                count[current - 'a'] = true;
        }
        // As we returned the result in the during the check, this is mainly to prevent compile-time error.
        // Otherwise, it can be used to show that no characters appears twice in the string.
        return '!';
    }
}
