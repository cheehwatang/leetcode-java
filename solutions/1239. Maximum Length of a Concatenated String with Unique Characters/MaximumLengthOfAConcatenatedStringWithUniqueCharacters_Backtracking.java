package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Problem:
 * Given an array of strings 'arr', return the maximum possible length of the string 's' formed
 * by concatenating a subsequence of 'arr' such that 's' only contains unique characters.
 *
 *
 * Example 1:
 * Input    : arr = ["a", "b", "c", "a"]
 * Output   : 3
 * Explanation: All valid concatenations with only unique characters are "", "a", "b", "c", "ab", "ac", "bc" and "abc".
 *              So the maximum possible length is 3.
 *
 *
 * Example 2:
 * Input    : arr = ["aa", "bb", "cc"]
 * Output   : 0
 * Explanation: Only "" is possible, as all the elements in 'arr' contain duplicate characters.
 *              So maximum possible length is 0.
 *
 *
 * @author Chee Hwa Tang
 */

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters_Backtracking {

    // Approach:
    // Using recursive and backtracking to get the maximum length.
    // In each recursion, there are two states:
    // 1. Take or concatenate the current element.
    // 2. Not take the current element, remains the same.
    // Additionally, there is the scenario where the element contains duplicate characters.
    // If such element exist, then skip to the next element.

    // Wrapper and initialization method.
    public int maxLength(List<String> arr) {
        // Start the recursion from index 0, with an empty string.
        return maxLength(arr, 0, "").length();
    }

    // Recursive method.
    private String maxLength(List<String> arr, int index, String str) {
        // When the recursion reached the end of 'arr', return 'str', as the base case.
        if (index == arr.size()) return str;

        // The element at the current index.
        String current = arr.get(index);
        // If found duplicate, then skip to the next element (index + 1).
        if (containsDuplicate(current)) return maxLength(arr, index + 1, str);

        // Scenario 2, when we not take this element.
        String notTake = maxLength(arr, index + 1, str);

        // For Scenario 1, first check if any common characters found in 'str' and 'current'.
        String take = str;
        for (char character : current.toCharArray()) {
            if (take.indexOf(character) >= 0) {
                take = "";
                break;
            }
        }
        // If not found, then we can take or concatenate 'current' with 'str'.
        if (take.equals(str)) {
            take = maxLength(arr, index + 1, str + current);
        }

        // Return the string that is longer.
        return take.length() >= notTake.length() ? take : notTake;
    }

    // Method to check if the element contains duplicate characters.
    private boolean containsDuplicate(String str) {
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            // If the character is already in the set, then this element contains duplicate.
            if (!set.add(str.charAt(i))) return true;
        }
        // If all characters successfully added into the HashSet, then no duplicates found.
        return false;
    }
}
