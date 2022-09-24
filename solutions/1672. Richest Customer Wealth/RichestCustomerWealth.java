package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given an 'm * n' matrix of 'accounts', where accounts[i][j] is the amount of money the i-th customer has
 * in the j-th bank.
 * Return the wealth that the richest customer has.
 * The wealth of a customer is the sum of money across all the banks.
 *
 *
 * Example 1:
 * Input : accounts = [[1,2],[3,4]]
 * Output: 7
 * Explanation:
 * First customer has wealth = 1 + 2 = 3
 * Second customer has wealth = 3 + 4 = 7
 * Second customer is considered the richest with 7.
 *
 *
 * Example 2:
 * Input : accounts = [[2,2],[1,2],[3,1]]
 * Output: 4
 * Explanation:
 * First customer has wealth = 2 + 2 = 4
 * Second customer has wealth = 1 + 2 = 3
 * Third customer has wealth = 3 + 1 = 4
 * First and Third customer are considered the richest with 4.
 *
 *
 * @author Chee Hwa Tang
 */

public class RichestCustomerWealth {

    public int maximumWealth(int[][] accounts) {

        int maxWealth = 0;
        // For each customer.
        for (int[] customer: accounts) {
            int sum = 0;
            //For each bank.
            for (int balance: customer) {
                sum += balance;
            }

            // Update the maxWealth with the higher wealth.
            maxWealth = Math.max(sum, maxWealth);
        }
        return maxWealth;
    }

}
