package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'prices'.
// We traverse 'prices' once to determine the maximum profit.
//
// Space Complexity : O(n),
// where 'n' is the length of 'prices'.
// We use a 'profits' array of length 'n' to record the maximum profits on each day.

public class BestTimeToBuyAndSellStock_DynamicProgramming {

    // Approach:
    // Let's imagine that we can travel back in time to buy the stock with the least price.
    // Then, we can travel to the future to find the day to sell with the maximum profit.
    //
    // With this, we need to keep track of the minimum price up to any day.
    // Then for each day, we compare the current price with the minimum price to get the maximum profit.
    // For example, prices = [6,1,4,2,5]:
    // Day 1: price = 6, minPrice = 6, maxProfit = 0, when we buy and sell at 6.
    // Day 2: price = 1, minPrice = 1, maxProfit = 0, when we buy and sell at 1.
    // Day 3: price = 4, minPrice = 1, maxProfit = 3, when we buy at 1, and sell at 4.
    // Day 4: price = 2, minPrice = 1, maxProfit = 3, when we buy at 1, and sell at 4. (Note we are not selling at 2)
    // Day 5: price = 5, minPrice = 1, maxProfit = 4, when we buy at 1, and sell at 5.
    //
    // We can use the bottom-up approach of dynamic programming,
    // where we use a 'profits' array to record the maximum profit for the day,
    // and use the 'prices' array to record the minimum price up to that day.

    public int maxProfit(int[] prices) {
        int n = prices.length;

        int[] profits = new int[n];
        // Traverse both the 'prices' and 'profits' array.
        // As the buying and selling on the first day while yield 0 profit, we can skip day 1.
        for (int i = 1; i < n; i++) {
            // For each day, we compare and update the maximum profit,
            // by comparing the max profit on the previous day, and the maximum profit on the current day.
            // We can get the maximum profit of the current day by determining the difference between
            // the minimum price in the past (prices[i - 1]) and the current price (prices[i]).
            profits[i] = Math.max(profits[i - 1], prices[i] - prices[i - 1]);
            // For each day, we update the minimum price up to the current day.
            prices[i] = Math.min(prices[i], prices[i - 1]);
        }
        // The last day in 'profits' is the maximum profit.
        return profits[n - 1];
    }
}
