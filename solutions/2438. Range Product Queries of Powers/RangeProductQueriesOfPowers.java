package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * Given a positive integer 'n', there exists a 0-indexed array called 'powers',
 * composed of the minimum number of powers of 2 that sum to n.
 * For example n = 11, the 'powers' array would be [1,2,8].
 * Along integer 'n', given a 2D integer array 'queries', where queries[i] = [left-i, right-i],
 * return an array 'answers', equal in length to 'queries',
 * where answers[i] is the product of all powers[j] where left-i <= j <= right-i.
 * The products in the 'answers' should be returned in modulo (1e9 + 7).
 *
 *
 * Example 1:
 * Input    : n = 6, queries = [[0,1]]
 * Output   : [8]
 * Explanation:
 * For n = 6, powers = [2,4].
 * The queries, powers[0] * powers[1] == 2 * 4 == 8.
 *
 *
 * Example 2:
 * Input    : n = 14, queries = [[0,0],[1,2]]
 * Output   : [2,32]
 * Explanation:
 * For n = 14, powers = [2,4,8].
 * The queries, powers[0] == 2.
 * The queries, powers[1], powers[2] == 4 * 8 == 32.
 *
 *
 * @author Chee Hwa Tang
 */

public class RangeProductQueriesOfPowers {

    // Approach:
    // With the integer 'n', we first need to get all the possible powers of 2.
    // One way is to use an integer variable, 'power', to keep track of the powers of 2 while performing division.
    // For each division of 2, if there is a remainder of 1, we know there is a power of 2 number.
    // Example:
    // n = 5
    // 'power' = 0, 5 % 2 = 1, so the bit at 2^0 == 1, (for next, 5 / 2 = 2)
    // 'power' = 1, 2 % 2 = 0, so the bit at 2^1 == 0, (for next, 2 / 2 = 1)
    // 'power' = 2, 1 % 2 = 1, so the bit at 2^2 == 1,
    // so it will be a 101 binary digit for n = 5.
    //
    // Once we got the list of powers of 2, then we can iterate through the 'queries' for each powers of 2,
    // multiply then input into the 'answers' array.

    public int[] productQueries(int n, int[][] queries) {
        // Since the multiplication may exceed 2^31 (Integer.MAX_VALUE), keep the calculations in long type,
        // only cast to int when inputting into the 'answers' array.
        long modulo = (long) (1e9 + 7);
        List<Integer> powers = new ArrayList<>();
        int power = 0;
        while (n > 0) {
            // Using bit manipulation, n & 1 is to check for odd or even, same as n % 2.
            // If digit at 2^0 == 1, 1 & 1 == 1 meaning it is odd.
            // If digit at 2^0 == 0, 0 & 1 == 0 meaning it is even.
            if ((n & 1) == 1) powers.add((int) Math.pow(2, power));

            // >> is shift right. Each right shift is division by 2, likewise each left shift is multiplication of 2.
            n = n >> 1;
            power++;
        }
        int[] answers = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            // Keeping the 'product' in long type even when we are using modulo for each multiplication,
            // is so that the 'product' does not overflow during the multiplication.
            long product = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                product = (product * powers.get(j)) % modulo;
            }
            answers[i] = (int) product;
        }
        return answers;
    }
}
