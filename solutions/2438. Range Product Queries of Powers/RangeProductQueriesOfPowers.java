package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;

// Time Complexity  : O(j * k),
// where 'j' is the length of 'queries' array, and 'k' is the number of powers of 2 in input 'n'.
// We iterate through 'queries' to get the products,
// with the worst-case being that the product of each query is from the whole range of the possible powers generated from 'n'.
//
// Space Complexity : O(j + k),
// where 'j' is the length of 'queries' array, and 'k' is the number of powers of 2 in input 'n'.
// An array of length 'j' is used to store the result, and a list of length 'k' is use to store the powers.

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
