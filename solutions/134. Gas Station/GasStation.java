package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the number of gas stations (length of 'gas').
// We traverse both the 'gas' and 'cost' array.
//
// Space Complexity : O(1),
// as we only use variables that are independent on the size of the input.

public class GasStation {

    // Approach:
    // Before discussing the main approach, let us understand the brute force approach:
    // From every position, traverse the whole array circularly once,
    // to determine if we can reach the last gas station from the starting position.
    // This would lead to a time complexity of O(n^2).
    //
    // To improve on the brute force approach,
    // it is important to know that it is always possible to visit all the stations,
    // if the sum of 'gas' is greater or equal to the sum of 'cost'.
    // If there are not enough gas to cover the whole journey, then the result must be -1.
    //
    // So how can we determine the unique starting point?
    // For example: gas = [0,0,0,0,5], cost = [1,1,1,1,1].
    // We know that the sum of 'gas' == 5, and the sum of 'cost' == 5.
    // This means we can complete the journey.
    // So, we check each position if it is possible to start.
    // It is not possible to start in the first 4 positions are there are not enough gas to cover the journey.
    // However, gas[4] >= cost[4], so it is possible to start here.
    // With only a unique starting point, there is no need to check if this starting point can cover journey
    // as we have proven with the sum of 'gas' greater or equal to the sum of 'cost'.
    // Another example for clarification: gas = [1,1,1,0,2], cost = [1,1,1,1,1].
    // Although it is possible to start at the first 3 positions, but all have insufficient gas when arrive at index 3.
    // So, index 4 is the starting point as it is possible to start there, and the sum of 'gas' is greater or equal.
    //
    // As such, we only traverse the arrays once,
    // recording the total differences between the sum of 'gas' and the sum of 'cost'.
    // Then, as we check if any starting point is possible to visit the "n - 1" station.
    // If the sum of 'gas' is greater or equal to the sum of 'cost',
    // then the only position that can visit the "n - 1" station is the unique starting point.

    public int canCompleteCircuit(int[] gas, int[] cost) {
        // Record the difference between the sum of 'gas' and the sum of 'cost'.
        int totalSurplus = 0;
        // Keep track of the surplus gas from a particular starting point.
        int surplus = 0;
        // Keep track of the starting index that can arrive at "n - 1" station.
        int startingIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            // Sum the difference between gas[i] and cost[i] for the all the gas stations.
            totalSurplus += gas[i] - cost[i];
            // At any particular starting point, keep track if there are still surplus gas.
            surplus += gas[i] - cost[i];
            // If at any point we do not have enough gas to continue the journey,
            if (surplus < 0) {
                // reset the surplus to zero,
                surplus = 0;
                // and test the next position as the possible starting point.
                startingIndex = i + 1;
            }
        }
        // If 'totalSurplus' is 0 or greater, return the starting position.
        // Else, return -1 as we do not have enough gas to cover the whole journey.
        return totalSurplus < 0 ? -1 : startingIndex;
    }
}
