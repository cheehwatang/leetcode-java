package com.cheehwatang.leetcode;

import java.util.*;

/**
 * Problem:
 * Given an array of strings 'strs', group the anagrams together and return a list of the anagrams list.
 * An anagram is a word or phrase formed by rearranging the letters of a different word or phrase.
 *
 *
 * Example 1:
 * Input    : strs = ["abc", "aaa", "aba", "cba", "bac", "baa"]
 * Output   : [["aaa"],["aba","baa"],["abc","bac","cba"]]
 *
 *
 * Example 2:
 * Input    : strs = [""]
 * Output   : [[""]]
 *
 *
 * @author Chee Hwa Tang
 */

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
