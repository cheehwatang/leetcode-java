package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given three integers:
 * 1. 'total' representing the amount of money you have,
 * 2. 'cost1' representing the price of a pen, and
 * 3. 'cost2' representing the price of a pencil,
 * return the number of distinct ways you can buy some number of pens and pencils.
 * Note that part or all of the money can be spent to buy multiple quantities (or none) of either pen or pencil.
 *
 *
 * Example 1:
 * Input    : total = 10, cost1 = 5, cost2 = 2
 * Output   : 10
 * Explanation: There is a total of 10 distinct ways to buy (or not buy) the pens and pencils.
 * - If we buy 0 pens, we can buy 0, 1, 2, 3, 4, or 5 pencils.
 * - If we buy 1 pen, we can buy 0, 1 or 2 pencils.
 * - If we buy 2 pens, we can buy 0 pencils.
 *
 *
 * Example 2:
 * Input    : total = 1, cost1 = 5, cost2 = 2
 * Output   : 1
 * Explanation: We do not have enough money to buy either a pen or pencil, thus we can only buy 0 pens and 0 pencils.
 *
 *
 * @author Chee Hwa Tang
 */

public class NumberOfWaysToBuyPensAndPencils {

    // Approach:
    // First determine how many pen it is possible to buy.
    // Then for each number of pen, check how many pencil can be bought with the remaining amount of money.

    public long waysToBuyPensPencils(int total, int cost1, int cost2) {

        long count = 0;

        // Determine the number of pen possible.
        int pen = total / cost1;

        // For each number of pen bought, determine how much pencil can be bought with the money left.
        for (int i = 0; i <= pen; i++) {
            int remaining = total - (cost1 * i);
            int pencil = remaining / cost2;
            // The + 1 is to account for the case with 0 pencils.
            count += pencil + 1;
        }
        return count;
    }
}
