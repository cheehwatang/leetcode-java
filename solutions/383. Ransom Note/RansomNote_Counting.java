package com.cheehwatang.leetcode;

// Time Complexity  : O(n + m),
// where 'n' is the length of 'ransomNote', and 'm' is the length of 'magazine'.
// First, we iterate through 'magazine' to record the frequency of each alphabet.
// Then, we iterate through 'ransomNote' to check if we can make the letter from 'magazine'.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the size of 'ransomNote' and 'magazine', with space complexity of O(1).
// Note that if we use forEach and convert the string to char array, then the space complexity is O(n + m).

public class RansomNote_Counting {

    // Approach:
    // Use counting array to record the frequency of each character in 'magazine'.
    // When checking each character in 'ransomNote', reduce the count.
    // If the count for any character reaches zero, it means we have insufficient characters from 'magazine'.
    //
    // Since we are sure that there is only lowercase English alphabets in both strings,
    // we can use counting array.
    // If there are more characters, we either use a larger counting array or use Hash Table ot keep track.

    public boolean canConstruct(String ransomNote, String magazine) {
        // Too few characters from 'magazine'.
        if (magazine.length() < ransomNote.length()) return false;

        // Using a counting array to keep track of the character counts, for 26 alphabets.
        int[] chars = new int[26];

        // Increase the count by one for each occurrence found in 'magazine'.
        for (int i = 0; i < magazine.length(); i++)
            chars[magazine.charAt(i) - 'a']++;

        // Reduce the count as found in 'ransomNote'.
        // If the count is less than 1, there is insufficient characters from 'magazine'.
        for (int i = 0; i < ransomNote.length(); i++) {
            int position = ransomNote.charAt(i) - 'a';
            // Note that we check if we have the current ransom note character
            // then we subtract it from the magazine array.
            if (chars[position]-- <= 0) return false;
        }
        return true;
    }
}
