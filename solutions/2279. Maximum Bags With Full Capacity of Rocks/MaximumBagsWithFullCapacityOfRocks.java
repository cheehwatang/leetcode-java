package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n^2),
// where 'n' is the number of bags (size of 'capacity' or 'rocks').
// The Arrays.sort() method uses the Dual-Pivot Quicksort, which results in complexity of O(n logn) in most cases,
// but worst case is quadratic O(n^2).
//
// Space Complexity : O(1),
// as we only modify the array in-place.

public class MaximumBagsWithFullCapacityOfRocks {

    // Approach:
    // As we want to get the most bags to fill to full capacity,
    // we always fill the bags needing the least number of rocks to full capacity (Greedy Approach).
    // First, get the number of rock left to fill until full capacity, by getting difference of capacity[i] and rocks[i].
    // Then, we sort in ascending order.
    // Lastly, we add the rocks into the bags in ascending order, until unable to fill anymore,
    // either all bags are full, or no more additional rocks available.

    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length; // Same as capacity.length.

        // Here, we use 'capacity' to record the number of rocks left to full capacity.
        // Alternatively, we can use 'rocks' instead.
        // Idea here is to modify the existing array in-place to save memory (reduce space complexity).
        for (int i = 0; i < n; i++) capacity[i] -= rocks[i];

        // Sort in ascending order, so we can fill the bag the least empty first.
        Arrays.sort(capacity);

        int count = 0;
        // Add the rocks from the 'additionalRocks' into the bags.
        for (int rocksUntilFull : capacity) {
            // If we do not have sufficient rocks left, exit the for-loop.
            // Note that we can also return 'count' here,
            // but we still need to return statement at the end of the method to prevent compile-time error.
            if (additionalRocks < rocksUntilFull) break;

            // Reduce the 'additionalRocks' for each bag filled.
            // Note that if the bag is already full, no additional rocks is used.
            additionalRocks -= rocksUntilFull;

            // When successfully fill, increase the count by one.
            count++;
        }
        return count;
    }
}
