package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n * m),
// where 'n' is the length of 'nums', and 'm' is the length of 'target'.
// For each number string in 'nums', we check if the number string is prefix or suffix of 'target',
// using String.startWith() and String.endWith() functions, which has O(m) time complexity.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// We use a HashMap with a maximum size of 'n', if all strings in 'nums' are unique.

public class NumberOfPairsOfStringsWithConcatenationEqualToTarget_HashTable {

    // Approach:
    // Using HashMap to record the frequency of the elements in 'nums',
    // while checking for its prefix or suffix that can form 'target'.
    // The String class offers two helpful methods, startWith(String) and endsWith(String),
    // which returns boolean whether the string starts with or ends with the input string.
    //
    // Note: This problem can be solved with Brute Force nested for-loops to check the concatenation of every element.

    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (String number : nums) {
            // If 'number' is the prefix of 'target', add the count of the corresponding suffix.
            if (target.startsWith(number)) {
                String suffix = target.substring(number.length());
                count += map.getOrDefault(suffix, 0);
            }
            // If 'number' is the suffix of 'target', add the count of the corresponding prefix.
            if (target.endsWith(number)) {
                String prefix = target.substring(0, target.length() - number.length());
                count += map.getOrDefault(prefix, 0);
            }
            // Note that we used two if-statements here, because 'number' can be both prefix and suffix of 'target'.

            // For each, record the frequency of 'number' in the map.
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        return count;
    }
}
