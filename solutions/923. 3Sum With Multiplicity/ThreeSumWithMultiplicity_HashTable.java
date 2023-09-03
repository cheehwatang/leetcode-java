package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n^2),
// where 'n' is the length of 'arr'.
// We traverse 'arr' in a nested for-loop, checking each triplet for each 'arr[i]'.
//
// Space Complexity : O(n^2),
// where 'n' is the length of 'arr'.
// For each 'arr[i]', there are 'n' number of possible differences to store in the HashTable.

public class ThreeSumWithMultiplicity_HashTable {

    // Approach:
    // Using a HashTable to record "target - arr[k]" of the equation, then traverse both 'i' and 'j' to check if equal.
    // Note that we rearranged the equation as arr[i] + arr[j] == target - arr[k].
    // Each loop recording the frequency of "target - arr[k]", add the frequency if equal.

    public int threeSumMulti(int[] arr, int target) {
        int n = arr.length;
        // Store the first value of 'arr[k]' which is arr[n - 1], starting from right to left each iteration.
        Map<Integer, Integer> map = new HashMap<>();
        map.put(target - arr[n - 1], 1);
        long count = 0;
        for (int j = n - 2; j >= 0; j--) {
            // Add the frequency of "target - arr[k]" to the count if found.
            for (int i = j - 1; i >= 0; i--) {
                count += map.getOrDefault(arr[i] + arr[j], 0);
            }
            // Once done with all the 'j' for this loop, increase the frequency for "target - arr[j]".
            int difference = target - arr[j];
            map.put(difference, map.getOrDefault(difference, 0) + 1);
        }
        return (int) (count % (1e9 + 7));
    }
}
