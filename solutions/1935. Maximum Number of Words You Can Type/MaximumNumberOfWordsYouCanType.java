package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem:
 * There is a malfunctioning keyboard where some letter keys do not work.
 * Given a string 'text' of words separated by a single space,
 * and a string 'brokenLetters' of all distinct letter keys that do not work,
 * return the number of words in 'text' that can be fully types using the keyboard.
 *
 *
 * Example 1:
 * Input    : text = "hello world", brokenLetters = "h"
 * Output   : 1
 * Explanation: Cannot type "hello" because the 'h' is broken.
 *
 *
 * Example 2:
 * Input    : text = "hello world", brokenLetters = "xzoac"
 * Output   : 0
 * Explanation: Cannot type "hello" and "world" because the 'o' is broken.
 *
 *
 * Example 3:
 * Input    : text = "hello world", brokenLetters = "abcxyz"
 * Output   : 2
 * Explanation: No words are broken.
 *
 *
 * @author Chee Hwa Tang
 */

public class MaximumNumberOfWordsYouCanType {

    // Approach:
    // Store the characters in the 'brokenLetters' in a HashSet.
    // When traversing each world, check if any letters are in the HashSet. If none, increase the count by 1.

    public int canBeTypedWords(String text, String brokenLetters) {
        // If all the keys are broken, then no words can be typed.
        if (brokenLetters.length() == 26) return 0;

        // Store the letters in the 'brokenLetters' in the HashSet.
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < brokenLetters.length(); i++) {
            set.add(brokenLetters.charAt(i));
        }

        // Split the words in the 'text'.
        String[] words = text.split(" ");
        int count = 0;
        outer:
        // Check every word if any letters are broken, skip if it is.
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (set.contains(word.charAt(i))) continue outer;
            }
            count++;
        }
        return count;
    }
}
