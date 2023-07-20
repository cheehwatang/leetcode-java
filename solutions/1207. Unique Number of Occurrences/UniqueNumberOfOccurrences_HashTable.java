package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

// Time Complexity  : O(n),
// where 'n' is the length of 'arr'.
// We traverse 'arr' once to count the frequency of each number.
// Then, we check every frequency in Map to determine if the frequencies are unique.
//
// Space Complexity : O(n),
// where 'n' is the length of 'arr'.
// We use HashMap to record the frequency of the numbers in 'arr', which has a maximum size of 'n'.

public class UniqueNumberOfOccurrences_HashTable {

    // Approach:
    // We first use a HashMap to count the frequency of each unique numbers in 'arr'.
    // Note that we can alternatively use a counting array since we know the constraint of "-1000 <= arr[i] <= 1000".
    // Once counted, we can use a HashSet to determine if the frequencies are unique.

    public boolean uniqueOccurrences(int[] arr) {
        // Use a HashMap to count the frequency of the numbers in 'arr'.
        Map<Integer, Integer> map = new HashMap<>();
        for (int number : arr) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        // Then, we use a HashSet to check if the frequencies in the HashMap are unique.
        Set<Integer> set = new HashSet<>();
        for (int frequency : map.values()) {
            // If the frequency is already added to the HashSet, return false.
            // Note that Set.add() returns true if successfully added, and false if value not added.
            if (!set.add(frequency)) return false;
        }
        // If all the frequencies are successfully added to the HashSet, return true.
        return true;
    }
}
