package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;

// Time Complexity  : O(m + n)
// where 'm' is the length of string 's', and 'n' is the length of string 'p'.
// We traverse the string 'p' once to count the frequency of the letters.
// Then, we use the sliding window technique to traverse the string 's' once, each time checking
// if the sliding window contains the same letters as found in string 'p'.
//
// Space Complexity : O(m),
// where 'm' is the length of string 's'.
// The maximum size of the result list is the length of string 's', where every position is the start index
// of 'p' anagram in 's'.

public class FindAllAnagramsInAString {

    // Approach:
    // Using integer array to count the frequency of the letters found in 'p' to check for anagrams,
    // with each position representing a lowercase English alphabet, index 0 to 25 as 'a' to 'z'.
    // With that, we can use a sliding window with the same size as the length of string 'p'
    // to compare if they are made up of the same letters frequency as that of 'p'.

    public List<Integer> findAnagrams(String s, String p) {
        int m = s.length(), n = p.length();

        List<Integer> result = new ArrayList<>();

        // Return the empty list if string 'p' is longer than string 's'.
        if (m < n) return result;

        // Get the letters frequency in string 'p'.
        int[] pFrequency = countCharacters(p);

        // Before we start the sliding window technique, we need to get the letters frequency of the sliding window.
        int[] windowFrequency = countCharacters(s.substring(0, n));
        // If the letters frequency of the sliding window is the same as the letters frequency of 'p',
        // add index 0 to the result.
        if (areSame(pFrequency, windowFrequency)) result.add(0);

        // Continue to move the sliding window one index at a time,
        for (int index = n; index < m; index++) {
            // each time updating the letter frequency, increasing the count for the front letter,
            windowFrequency[s.charAt(index) - 'a']++;
            // and decreasing the back letter.
            windowFrequency[s.charAt(index - n) - 'a']--;
            // If the letters frequency of the sliding window is the same as the letters frequency of 'p',
            // add the index of the sliding window's back to the result.
            if (areSame(pFrequency, windowFrequency)) result.add(index - n + 1);
        }

        return result;
    }

    // Method to count the frequency of the characters in the input string,
    // and return an integer array representing the frequency of the letters.
    private int[] countCharacters(String word) {
        int[] frequency = new int[26];
        // For each letter in 'word', count the frequency of the character.
        for (char letter : word.toCharArray())
            frequency[letter - 'a'] += 1;

        return frequency;
    }

    // Method to traverse two frequency integer array to check if both has the same frequency of letters.
    private boolean areSame(int[] frequency1, int[] frequency2) {
        for (int i = 0; i < 26; i++)
            // Return false if any frequency is different.
            if (frequency1[i] != frequency2[i]) return false;

        // If successfully traverse the arrays, return true.
        return true;
    }
}
