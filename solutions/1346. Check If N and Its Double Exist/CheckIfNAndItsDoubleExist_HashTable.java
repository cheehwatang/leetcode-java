package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

// Time Complexity  : O(n),
// where 'n' is the length of 'arr', as we traverse through 'arr' to check for its double or half.
//
// Space Complexity : O(n),
// where 'n' is the length of 'arr', as worst case with us storing every element from 'arr' into the HashSet.

public class CheckIfNAndItsDoubleExist_HashTable {

    // Approach:
    // Using HashSet to record the elements in 'arr' while checking if its double or half is already in the HashSet.
    // The reason for checking both double and half is because 'arr' is not sorted,
    // thus 'n' and its double can be in any order in 'arr'.

    public boolean checkIfExist(int[] arr) {
        Set<Integer> set = new HashSet<>();

        // Do note that we are only traversing 'arr' once, both checking for the double, and adding the element into 'set'.
        // If we first add all the elements into the HashSet, then only traverse 'arr' again to check for the double,
        // there will be an edge case with the integer 0, as its double is still 0.
        for (int integer : arr) {
            // Make sure to check if the integer is even, before checking its half,
            // as both even and odd integer can result in the same half (e.g. 6 / 2 == 3, 7 / 2 == 3).
            if (integer % 2 == 0 && set.contains(integer / 2)) return true;
            // Check for the double.
            if (set.contains(integer * 2)) return true;

            set.add(integer);
        }
        // If none found, return false.
        return false;
    }
}
