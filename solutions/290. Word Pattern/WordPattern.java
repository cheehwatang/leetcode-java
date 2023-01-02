package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// Time Complexity  : O(n),
// where 'n' is the number of words in 's' or the length of 'pattern'.
// We check whether the words in 's' matches the 'pattern'.
//
// Space Complexity : O(n),
// where 'n' is the number of words in 's' or the length of 'pattern'.
// We use HashMap with a maximum size of the number of words in 's'.

public class WordPattern {

    // Approach:
    // Using HashMap to record the index of the word in 's' and letter in 'pattern'.
    // If the previous index of the word and letter is different, then the word and letter does not match.
    // For example, pattern = "aaba", s = "alice alice bob bob",
    // 1. Index = 0, the previous index for both word 'alice' and letter 'a' are null, so is the same.
    // 2. Index = 1, the previous index for both word 'alice' and letter 'a' are 0, so is the same.
    // 3. Index = 2, the previous index for both word 'bob' and letter 'b' are null, so is the same.
    // 4. Index = 3, the previous index for word 'bob' is 2, for letter 'a' is 1.
    //    As the two indices are different, string 's' does not match the 'pattern'.

    public boolean wordPattern(String pattern, String s) {
        // Use split() method to get the array of words.
        String[] words = s.split(" ");

        // As we want to get a full match, the pattern is not repeated, so it is a 1-to-1 match.
        // If the number of words and letters are different, then 's' does not follow the 'pattern'.
        if (words.length != pattern.length()) return false;

        // Using two HashMap, one to record the index of the words in 's',
        // and another to record the index of the letters in 'pattern'.
        // Alternatively, we can use Map<Object, Integer> to record both the String and Character object.
        Map<String, Integer> wordIndex = new HashMap<>();
        Map<Character, Integer> letterIndex = new HashMap<>();
        // Traverse both the 'words' array and the 'pattern'.
        for (int i = 0; i < words.length; i++) {
            // If the word and letter indices are different, then return false,
            // as the 's' does not follow the 'pattern'.
            if (!Objects.equals(letterIndex.put(pattern.charAt(i), i), wordIndex.put(words[i], i)))
                return false;
        }
        // If we successfully checked all the words and letters, then the 's' follows hte 'pattern'.
        return true;
    }
}
