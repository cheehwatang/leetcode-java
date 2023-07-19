package com.cheehwatang.leetcode;

import java.util.*;

// Time Complexity  : O(n logn),
// where 'n' is the length of 'word1' or 'word2'.
// We first traverse both words to count the frequency of the characters, with O(n) time complexity.
// The HashSet.equals() function has a linear time complexity.
// The Collections.sort() function has O(n logn) time complexity.
// Lastly, we use List.equals() function to compare the list of frequencies, with O(n) time complexity.
// Thus, the time complexity is O(n logn), when the words are made up of unique characters.
//
// Space Complexity : O(n),
// where 'n' is the length of 'word1' or 'word2'.
// We use HashMap to count the frequency of each unique characters.
// If the words are made up of only unique characters, then HashMap will have the same size as the word.
// Additionally, the HashMap.keySet() creates a Set object, with O(n) space,
// and we create a Collection object using HashMap.values() and new List object, both with O(n) space.

public class DetermineIfTwoStringsAreClose_Sorting_HashTable {

    // Approach:
    // To understand the approach, it is worth thinking the strings as a distribution of letter by frequency.
    // For example:
    // "aabcccd" would be [2,1,3,1].
    //
    // With Operation 1, the frequency distribution would remain the same,
    // as we are only swapping position of the letters.
    // Continuing the above example with Operation 1,
    // "baacccd" would be [2,1,3,1].
    //
    // With Operation 2, the frequency distribution would change, with 2 letters changing position.
    // Continuing the above example with Operation 2,
    // "bccaaad" would be [3,1,2,1].
    // If we sort the frequency list before and after Operation 2, both would yield [1,1,2,3].
    // Note however that we would need to check if the same set of unique characters exist in both words.
    // For example with "aa" and "bb", it would pass both checks.
    //
    // With that, we would use a HashMap to count the frequency of the unique characters.
    // With the HashMap, the frequencies would remain the same with Operation 1.
    // Next, we check if both words has the same set of characters.
    // Lastly, we sort the frequencies and check if they are the same.
    // If they are the same, then the two strings are close.

    public boolean closeStrings(String word1, String word2) {
        // If 'word1' and 'word2' are of different length, then they are not close.
        if (word1.length() != word2.length()) return false;

        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();
        // Traverse both words and record the frequency.
        for (int i = 0; i < word1.length(); i++) {
            char character1 = word1.charAt(i);
            char character2 = word2.charAt(i);
            map1.put(character1, map1.getOrDefault(character1, 0) + 1);
            map2.put(character2, map2.getOrDefault(character2, 0) + 1);
        }

        // The strings are not close if they are made up of different character set.
        if (!map1.keySet().equals(map2.keySet())) return false;

        // Sort the frequencies of the letters.
        List<Integer> count1 = new ArrayList<>(map1.values());
        List<Integer> count2 = new ArrayList<>(map2.values());
        Collections.sort(count1);
        Collections.sort(count2);
        // Return true if the sorted frequency is the same.
        return count1.equals(count2);
    }
}
