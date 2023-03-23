package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of string 'colors'.
// We traverse the string 'colors' once to find the adjacent balloons with the same color.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the size of input string 'colors' or int array 'neededTime'.

public class MinimumTimeToMakeRopeColorful_DynamicProgramming {

    // Approach:
    // Check for any similar color with the previous balloon.
    // If it is the same color, then we always remove the balloon requiring the least time (Greedy Approach).
    // Here, the balloon with the most time needed is kept, and we are using 'neededTime' array to record,
    // instead of a separate variable.

    public int minCost(String colors, int[] neededTime) {
        int minTime = 0;

        // Traverse the string 'colors' to check for any consecutive balloons of identical color.
        for (int index = 1; index < colors.length(); index++) {
            // If found, then we record the least time needed to remove either balloon,
            // and update the current balloon with the most time needed.
            if (colors.charAt(index) == colors.charAt(index - 1)) {
                minTime += Math.min(neededTime[index], neededTime[index - 1]);
                neededTime[index] = Math.max(neededTime[index], neededTime[index - 1]);
            }
        }
        return minTime;
    }
}
