package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n),
// where 'n' is the length of the string 's', because we traverse the string 's' once.
//
// Space Complexity : O(n),
// where 'n' is the length of the string 's'.
// The algorithm is basically "n / 2" as there are only two occurrences for each letter, to record in the HashMap.

public class CheckDistancesBetweenSameLetters_HashTable {

    // Approach:
    // Using Hash Table to store the index of the first occurrence of a letter.
    // At the second occurrence, check if the spaces between is the same as in distance[i].
    // Due to the fact that distance[i] representing the letters between, but not index difference,
    // we need to reduce the index difference by 1 to compare to distance[i],
    // or compare index difference with distance[i] + 1.

    public boolean checkDistances(String s, int[] distance) {
        Map<Character, Integer> map = new HashMap<>();
        char current;
        for (int i = 0; i < s.length(); i++) {
            current = s.charAt(i);
            // Store the index for the first occurrence.
            if (!map.containsKey(current))
                map.put(current, i);
            else
                // At the second occurrence, check if the distance is the same, return false otherwise.
                if (distance[current - 'a'] + 1 != i - map.get(current))
                    return false;
        }
        // If every letter is checked, return true.
        return true;
    }
}
