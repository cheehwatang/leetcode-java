package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'prices'.
// We traverse 'prices' once to determine the maximum profit.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input.

public class BestTimeToBuyAndSellStock {

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
    // With that, we use a 'minPrice' variable to keep track of the minimum price,
    // and a 'maxProfit' variable to keep track of the maximum profit.
    // While traversing 'prices', we update the 'minPrice' and update the 'maxProfit' for each day.

    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE, maxProfit = 0;
        // For each day,
        for (int price : prices) {
            // we update the minimum price,
            minPrice = Math.min(minPrice, price);
            // and update the maximum profit.
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }
}
