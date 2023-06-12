package com.cheehwatang.leetcode;

// Time Complexity  : O(n * m),
// where 'n' is the length of 'accounts', and 'm' is the length of accounts[0].
// For each customer in 'accounts' (n), we traverse all the bank balance (m), resulting in O(n * m).
//
// Space Complexity : O(1),
// as the auxiliary space used is independent on the input size.

public class RichestCustomerWealth {

    // Approach:
    // Get the sum for each account by iterating through the account, and get the max wealth for each customer.

    public int maximumWealth(int[][] accounts) {

        int maxWealth = 0;
        // For each customer, get the sum of the account value and compare to 'maxWealth'.
        for (int[] customer: accounts) {
            int sum = 0;
            //For each bank, add to the sum.
            for (int balance: customer) sum += balance;
            // Update the maxWealth with the higher wealth.
            maxWealth = Math.max(sum, maxWealth);
        }
        return maxWealth;
    }
}
