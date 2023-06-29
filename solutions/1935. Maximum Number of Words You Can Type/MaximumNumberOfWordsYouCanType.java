package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

// Time Complexity  : O(n + m),
// where 'n' is the length of 'text' and 'm' is the length of 'brokenLetters'.
// We traverse 'brokenLetters' once to record each letter into the HashSet, with O(m) time complexity.
// The String.split() function has a linear time complexity O(n) to the length of the input string.
// Additionally, we traverse each word in 'words' to check if the word is broken,
// approximating to O(n) time complexity.
// As such, the total time complexity of the method is O(n + m).
//
// Space Complexity : O(n + m),
// where 'n' is the length of 'text' and 'm' is the length of 'brokenLetters'.
// We record each letters in 'brokenLetters' in the HashSet.
// We split 'text' into an array of 'words', with the total length of the strings in the array
// approximate to the length of 'text'.

public class MaximumNumberOfWordsYouCanType {

    // Approach:
    // Store the characters in the 'brokenLetters' in a HashSet.
    // When traversing each word, check if any letters are in the HashSet.
    // If none, increase the count by 1.
    // We can use String.split() function to split the 'text' into words,
    // since the words are guaranteed to be separated by a single space.

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
