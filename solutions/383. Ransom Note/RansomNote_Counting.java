package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given two strings 'ransomeNote' and 'magazine', return true if 'ransomNote' can be constructed by using the letters
 * from 'magazine', and return false otherwise.
 * Each letter in 'magazine' can only be used once in 'ransomNote', and both only contains lower case alphabets.
 *
 * Note:
 * Use counting array or hash tables.
 *
 *
 * Example 1:
 * Input : ransomNote = "dot", magazine = "leetcode"
 * Output: true
 *
 * Example 2:
 * Input : ransomNote = "dart", magazine = "leetcode"
 * Output: false
 *
 * @author Chee Hwa Tang
 */

public class RansomNote_Counting {

    // Approach:
    // Use counting array to record the frequency of each character in 'magazine'.
    // When checking each character in 'ransomNote', reduce the count.
    // If the count for any character reaches zero, it means we have insufficient characters from 'magazine'.

    public boolean canConstruct(String ransomNote, String magazine) {

        // Too few characters from magazine.
        if (magazine.length() < ransomNote.length()) {
            return false;
        }

        // Using a counting array to keep track of the character counts, for 26 alphabets.
        int[] chars = new int[26];

        // Increase the count by one for each occurrence.
        for (int i = 0; i < magazine.length(); i++) {
            chars[magazine.charAt(i) - 'a']++;
        }

        // Reduce the count as found in 'ransomNote'.
        // If the count is less than 1, there is insufficient characters from 'magazine'.
        for (int i = 0; i < ransomNote.length(); i++) {
            int position = ransomNote.charAt(i) - 'a';
            if (chars[position]-- <= 0) {
                return false;
            }
        }
        return true;
    }

}
