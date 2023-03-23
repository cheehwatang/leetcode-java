package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of string 'colors'.
// We traverse the string 'colors' once to find the adjacent balloons with the same color.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the size of input string 'colors' or int array 'neededTime'.

public class MinimumTimeToMakeRopeColorful_Greedy {

    // Approach:
    // Check for any similar color with the previous balloon.
    // If it is the same color, then we always remove the balloon requiring the least time (Greedy Approach).
    // Using a variable to keep track of the most time needed between the two consecutive balloons of the same color.

    public int minCost(String colors, int[] neededTime) {
        int minTime = 0;
        int previousTime = neededTime[0];

        // Traverse the 'colors' String to check for any consecutive balloons of identical color.
        for (int index = 1; index < colors.length(); index++) {

            // If found, then we record the least time needed to remove either balloon,
            // and record the most time needed into the 'previousTime' variable.
            if (colors.charAt(index) == colors.charAt(index - 1)) {
                minTime += Math.min(previousTime, neededTime[index]);
                previousTime = Math.max(previousTime, neededTime[index]);
            }
            // If not found, then keep updating the variable with the current time needed.
            else previousTime = neededTime[index];
        }
        return minTime;
    }
}
