package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

// Time Complexity  : O(n * m),
// where 'n' is the length of the list 'arr', and 'm' is the number of characters in the list 'arr'.
// In the worst-case when all characters are unique, there is 'n' times of string concatenation,
// which each string concatenation having a linear time complexity, resulting in time complexity of O(n * m).
// Additionally, checking for duplicates and if the characters are unique introduces additional complexity.
//
// Space Complexity : O(n * m),
// where 'n' is the length of the list 'arr', and 'm' is the number of characters in the list 'arr'.
// In the recursive method, the maximum length of the recursive call stack is the number of elements in the list 'arr',
// O(n).
// In the worst-case when all characters are unique, the space used for the strings concatenation is O(n * m).

public class MaximumLengthOfAConcatenatedStringWithUniqueCharacters_Backtracking {

    // Approach:
    // Using recursive and backtracking to get the maximum length.
    // In each recursion, there are two states:
    // 1. Take or concatenate the current element.
    // 2. Not take the current element, remains the same.
    // Additionally, there is the scenario where the element contains duplicate characters.
    // If such element exist, then skip to the next element.

    // Wrapper and initialization method.
    public int maxLengthString(List<String> arr) {
        // Start the recursion from index 0, with an empty string.
        return maxLengthString(arr, 0, "").length();
    }

    // Recursive method.
    private String maxLengthString(List<String> arr, int index, String str) {
        // When the recursion reached the end of 'arr', return 'str', as the base case.
        if (index == arr.size()) return str;

        // The element at the current index.
        String current = arr.get(index);
        // If found duplicate, then skip to the next element (index + 1).
        if (containsDuplicate(current)) return maxLengthString(arr, index + 1, str);

        // Scenario 2, when we not take this element.
        String notTake = maxLengthString(arr, index + 1, str);

        // For Scenario 1, first check if any common characters found in 'str' and 'current'.
        String take = str;
        for (char character : current.toCharArray()) {
            if (take.indexOf(character) >= 0) {
                take = "";
                break;
            }
        }
        // If common characters not found, then we can take or concatenate 'current' with 'str'.
        if (take.equals(str)) {
            take = maxLengthString(arr, index + 1, str + current);
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
