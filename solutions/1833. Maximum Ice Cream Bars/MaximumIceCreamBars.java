package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n logn),
// where 'n' is the number of ice cream bars (size of 'costs').
// As we sort the array, the Arrays.sort() method uses the Dual-Pivot Quicksort,
// which has an average performance of O(n logn).
//
// Space Complexity : O(1),
// as we only use variables that are independent of the size of the input.

public class MaximumIceCreamBars {

    // Approach:
    // Since we can buy the ice cream bars in any order, we would always buy the cheapest ice cream bars first.
    // As such, we would first sort the 'costs' in ascending order.
    // Then we reduce the 'coins' for each ice cream bar until unable to buy another one.
    // This is also known as Greedy Algorithm as we always buy the cheapest ice cream bar first.

    public int maxIceCream(int[] costs, int coins) {
        // By default, Arrays.sort() sorts the array in ascending order.
        Arrays.sort(costs);

        int numberOfIceCream = 0;
        // For each ice cream bar, from the cheapest to the most expensive,
        for (int cost : costs) {
            // If we do not have enough 'coins', stop buying and break from the loop.
            if (coins < cost) break;
            // Else, buy the ice cream bar.
            coins -= cost;
            numberOfIceCream++;
        }

        return numberOfIceCream;
    }
}
