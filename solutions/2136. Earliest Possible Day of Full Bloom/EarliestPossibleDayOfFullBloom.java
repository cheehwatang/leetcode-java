package com.cheehwatang.leetcode;

import java.util.Arrays;

/**
 * Problem:
 * Given two arrays of integers:
 * - 'plantTime' representing the number of full days to plant the i-th seed, and
 * - 'growTime' representing the number of full days for the seed to grow after being completely planted
 *    which blooms after the last day of growth,
 * return the earliest possible day when all seeds are blooming.
 * Note that it is not required to work on planting the same seed on consecutive days,
 * but the seed only starts to grow after it is completely planted.
 *
 *
 * Example 1:
 * Input    : plantTime = [1,2,3], growTime = [1,2,3]
 * Output   : 7
 * Explanation : (using '*' as planting, '#' as growing and '^' as bloomed)
 *                                Days 0 1 2 3 4 5 6 7
 * plantTime = 3, growTime = 3,        * * * # # # ^
 * plantTime = 2, growTime = 2,              * * # # ^
 * plantTime = 1, growTime = 1.                  * # ^
 *
 *
 * Example 2:
 * Input    : plantTime = [2,5,3,1], growTime = [8,2,1,4]
 * Output   : 12
 * Explanation : (using '*' as planting, '#' as growing and '^' as bloomed)
 *                                Days 0  1  2  3  4  5  6  7  8  9  10 11 12
 * plantTime = 2, growTime = 8,        *  *  #  #  #  #  #  #  #  #  ^
 * plantTime = 5, growTime = 2,              *  *  *  *  *  #  #  ^
 * plantTime = 1, growTime = 4.                             *  #  #  #  #  ^
 * plantTime = 3, growTime = 1.                                *  *  *  #  ^
 *
 *
 * @author Chee Hwa Tang
 */

public class EarliestPossibleDayOfFullBloom {

    // Approach:
    // For this problem, it is important to note that, not matter how we choose,
    // we need a minimum of total 'plantTime' for all the flower seeds.
    // So then, the crucial factor is the 'growTime'.
    // To simplify, all the 'growTime' in the example includes the extra day to bloom.
    // For Example, given flowerA and flowerB takes the same 4 days to plant, but 1 day and 3 days to bloom respectively.
    // As such, we plant flowerB first, as it requires longer time to bloom.
    // We know the total 'plantTime' is 4 + 4 == 8.
    // To get the minimum time to bloom, planting the longer bloom time first yield the shortest time in total.
    // (8 + 3 == 11 days) > (9 days == 8 + 1).
    // For that, we noticed that it is a greedy algorithm, since our focus is to plant the longest 'growTime' first.
    //
    // Additionally, we need to sort the 'growTime' in descending order,
    // while keeping in check its corresponding 'plantTime'.
    // We can use a 2D array or a Pair class for the sorting. Here using Pair class for better readability.

    public int earliestFullBloom(int[] plantTime, int[] growTime) {
        int n = plantTime.length;
        Pair[] flowerTime = new Pair[n];
        for (int i = 0; i < n; i++) {
            flowerTime[i] = new Pair(plantTime[i], growTime[i]);
        }
        // Sort the 'growTime' in descending order.
        // The 'plantTime' is not important as flowers with same 'growTime' but different 'plantTime' results in same total time.
        Arrays.sort(flowerTime, (a, b) -> b.growTime - a.growTime);

        // 'plantingDay' is the total days used for planting up to now,
        // which together with the current flower's 'plantTime' and 'growTime' result in a total time up to this flower.
        // This then is checked if we have a greater 'totalDays',
        // as it is possible for the previous flower 'totalDays' to be greatest.
        // For Example: flowerA with 'plantTime' 1 and 'growTime' 10, and flowerB with 'plantTime' 1 and 'growTime' 1.
        int plantingDay = 0;
        int totalDays = 0;
        for (Pair current : flowerTime) {
            // Check if we have found a greater 'totalDays', and update the days already used for previous plantings.
            totalDays = Math.max(totalDays, plantingDay + current.plantTime + current.growTime);
            plantingDay += current.plantTime;
        }
        // As we start at Day 0 (-1 Day from totalDays), and we need to include an extra day to bloom (+1 Day for totalDays),
        // they cancel out each other (totalDays + 1 - 1 == totalDays).
        return totalDays;
    }

    // Class Pair for sorting and readability.
    class Pair {
        public int plantTime;
        public int growTime;

        Pair(int plantTime, int growTime) {
            this.plantTime = plantTime;
            this.growTime = growTime;
        }
    }
}
