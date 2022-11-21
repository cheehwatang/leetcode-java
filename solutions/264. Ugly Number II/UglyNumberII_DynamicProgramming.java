package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// as we are only iterating from 1 to 'n' once.
//
// Space Complexity : O(n),
// as the array grows linearly with 'n'.

public class UglyNumberII_DynamicProgramming {

    // Approach:
    // Ugly number is found with the multiplication of an ugly number (including 1) with 2, 3 or 5.
    // So, we use a table to keep track of the ugly number that was found,
    // and using pointers for 2, 3 and 5 to keep track on the ugly number that it had to multiply with.
    // As we are building the table of ugly numbers, we only add a new element when it is the smallest
    // among the products of ugly numbers with 2, 3 and 5.
    // For Example, table = [1], pointers for 2, 3 and 5 all at position 0.
    // the next ugly number will be the smallest among (2 * 1), (3 * 1) and (5 * 1), which is 2.
    // Thus table = [1,2], with pointer for 2 is at position 1 now.
    // Next is smallest among (2 * 2), (3 * 1) and (5 * 1), which is 3.
    // So on until we each table[n - 1] position, which is the n-th ugly number, since table is 0-indexed.
    // Do take note to account for when more than one in 2, 3 and 5 produces the same ugly number,
    // for example with ugly number, 6, with 2 * 3 and 3 * 2.

    public int nthUglyNumber(int n) {
        int[] table = new int[n];
        // We know the first ugly number is 1.
        table[0] = 1;
        // All the pointers start at position 0.
        int factor2 = 0, factor3 = 0, factor5 = 0;

        for (int index = 1; index < n; index++){
            table[index] = Math.min(Math.min(2 * table[factor2], 3 * table[factor3]), 5 * table[factor5]);
            // Three separate if statements, rather than if-else to account for the situation where,
            // more than one factor produces the same ugly number (example with 6 above).
            if (table[index] == 2 * factor2) factor2++;
            if (table[index] == 3 * factor3) factor3++;
            if (table[index] == 5 * factor5) factor5++;
        }
        return table[n - 1];
    }
}
