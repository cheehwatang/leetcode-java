package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length string 's'.
// We traverse the whole string to not find duplicate letters in the worst-case.
//
// Space Complexity : O(1),
// as we are using a fixed boolean array independent of the size of the input string 's'.

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
