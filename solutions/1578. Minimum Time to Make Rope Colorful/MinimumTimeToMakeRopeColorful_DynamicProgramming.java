package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given an 'n' number of balloons arranged on a rope, where each balloon's color is represented by a character provided
 * in a string 'colors'. We want the rope to be colorful, that no two consecutive balloons are of the same color.
 * In order to remove the balloon, the time needed to remove each balloon is provided in an integer array 'neededTime',
 * where the i-th balloon in 'colors' corresponds to the i-th time in 'neededTime'.
 * Return the minimum time needed to make the rope colorful.
 *
 *
 * Example 1:
 * Input    : colors = "aabbcc", neededTime = [1,2,3,4,5,6]
 * Output   : 9
 * Explanation:
 * Three balloons need to be removed, an 'a' in "aa", a 'b' in "bb" and a 'c' in "cc".
 * Minimum time for 'a' is 1, for 'b' is 3, for 'c' is 5.
 * 1 + 3 + 5 = 9.
 *
 *
 * Example 2:
 * Input    : colors = "abab", neededTime = [1,2,3,4]
 * Output   : 0
 * Explanation:
 * No consecutive balloons of the same color. So no balloon is removed.
 *
 *
 * @author Chee Hwa Tang
 */

public class MinimumTimeToMakeRopeColorful_DynamicProgramming {

    // Approach:
    // Check for any similar color with the previous balloon.
    // If it is the same color, then we always remove the balloon requiring the least time (Greedy Approach).

    public int minCost(String colors, int[] neededTime) {

        int minTime = 0;

        // Traverse the 'colors' String to check for any consecutive balloons of identical color.
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
