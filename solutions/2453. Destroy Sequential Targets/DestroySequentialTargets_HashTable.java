package com.cheehwatang.leetcode;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n),
// where 'n' is the size of 'nums'. In fact, it is '3n' as we traversed 'nums' twice and 'map' once,
// assuming worst space complexity for the HashMap equals to 'n'. So, it is simplified as O(n).
//
// Space Complexity : O(n),
// where 'n' is the size of 'nums'.
// The worst case is when all the integers in 'nums' have different remainder to 'space',
// For Example: nums = [1,2,3,4,5], space = 5.
// Even with 'space' == 1e9 + 7, the HashMap only scales to the size of 'nums'.

public class DestroySequentialTargets_HashTable {

    // Approach:
    // Using HashMap to store the remainders of the integers in 'nums' to 'space.
    // If two elements are at index 'x' and 'x + space' respectively, then they are sequential targets,
    // with both targets having the same remainder.
    // Thus, all the sequential targets have the same remainder to 'space'.
    // As such, we need to find the remainder with the most integers and get the minimum integer of that remainder.
    // For Example, nums = [1,2,3,4,5], space = 3,
    // the remainders of 3 are:
    // - 0 (with integer 3),
    // - 1 (with integers 1 and 4), and
    // - 2 (with integers 2 and 5).
    // The remainders with the most integers are remainder 1 and 2,
    // thus getting the minimum integer among 1, 2, 4 and 5 resulting in the minimum integer of 1.

    public int destroyTargets(int[] nums, int space) {
        Map<Integer, Integer> map = new HashMap<>();
        // First count the frequencies of the remainders in the HashMap.
        for (int integer : nums)
            map.put(integer % space, map.getOrDefault(integer % space, 0) + 1);

        // Then get the maximum number of integers for all the remainders.
        int maxTargets = Collections.max(map.values());

        // Finally, get the minimum integer of the remainder(s) with the maximum number of integers.
        int minInteger = Integer.MAX_VALUE;
        for (int integer : nums)
            if (map.get(integer % space) == maxTargets)
                minInteger = Math.min(minInteger, integer);
        
        return minInteger;
    }
}
