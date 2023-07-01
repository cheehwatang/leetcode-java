package com.cheehwatang.leetcode;

import java.util.*;

// Time Complexity  : O(n * m logm),
// where 'n' is the length of 'strs', and 'm' is the average length of each string.
// For each of the elements in 'strs',
// we convert the string to char array, and convert char array back to string, each with O(m) time complexity,
// and the sorting of the char array results in O(m logm) time complexity.
// As such, the time complexity is O(n * m logm).
//
// Space Complexity : O(n),
// where 'n' is the length of 'strs'.
// The HashMap has a maximum length of 'n', in the case where each strings in 'strs' is a unique anagram.

public class GroupAnagrams {

    // Approach:
    // Using Sorting to first sort the letters in the word in alphabetical order,
    // then store the sorted word in the Hash Table, with the values containing a list to store the word.
    // This is because for the same group of anagrams, they all have the same sorted string.

    public List<List<String>> groupAnagrams(String[] strs) {
        // Key is the sorted string, value is the list of words that forms the sorted string.
        Map<String, List<String>> map = new HashMap<>();
        for (String string : strs) {
            // To sort a string, convert the string to char array, then sort the array before forming the sorted string.
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String sorted = String.valueOf(chars);

            // Create a new entry if a new group of anagram found.
            if (!map.containsKey(sorted)) map.put(sorted, new ArrayList<>());
            map.get(sorted).add(string);
        }
        return new ArrayList<>(map.values());
    }
}
