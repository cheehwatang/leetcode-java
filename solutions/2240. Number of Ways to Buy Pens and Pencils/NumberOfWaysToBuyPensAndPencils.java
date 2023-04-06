package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the number of pen possible to buy.
// After finding out the number of pen possible to buy, we iterate through the pen numbers to find the count for pencils.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the size of the input.

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
