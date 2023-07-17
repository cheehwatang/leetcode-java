package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'gain'.
// We traverse the 'gain' array once to find the prefix sum of the array, and determine the maximum altitude.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input array.

public class FindTheHighestAltitude {

    // Approach:
    // We perform prefix sum on 'gain' array,
    // and using a 'max' variable to compare each value and determine the maximum altitude.
    // Alternatively, we can use an additional variable to record
    // the current value while adding each value in 'gain'.

    public int largestAltitude(int[] gain) {
        // As it is possible for gain[0] to be negative, we need to get the maximum of the first value to 0.
        int max = Math.max(0, gain[0]);
        // Then, we perform the prefix sum, by starting at index 1,
        // and adding the values from gain[i - 1] to gain[i].
        // After each addition, we compare to get the maximum altitude.
        for (int i = 1; i < gain.length; i++) {
            gain[i] += gain[i - 1];
            max = Math.max(max, gain[i]);
        }
        return max;
    }
}
