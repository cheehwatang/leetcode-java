package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;

// Time Complexity  : O(2^n),
// where 'n' is the length of the integer.
// The worst case scenario is when 'k' == 1, every increment in length 'n' doubles the number of integers to check.
//
// Space Complexity : O(2^n),
// where 'n' is the length of the integer.
// The worst case scenario is when 'k' == 1, every increment in length 'n' doubles the number of results.

public class NumbersWithSameConsecutiveDifferences_Backtracking {

    // Approach:
    // Using depth first search to append 0 - 9 to each number starting from 1 to 9 to form possible numbers,
    // until the numbers have 'n' digits. Note that starting from 1 to 9 as leading zero is not valid.
    // If the next digit is not valid, either less than 0, or more than 9, we backtrack to try another number.

    // Wrapper method to initiate the recursive method.
    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();
        // Initiate the recursive method with the first digit from 1 to 9.
        for (int i = 1; i <= 9; i++)
            findNumber(n, k, i, 1, i, result);

        // Convert the queue to an int array.
        return result.stream().mapToInt(i -> i).toArray();
    }

    // Recursive method.
    private void findNumber(int n, int k, int number, int digit, int lastDigit, List<Integer> list) {

        // Breaking condition, when the number has 'n' length.
        if (digit == n) {
            list.add(number);
            return;
        }
        // Check if the lastDigit with positive and negative k difference is possible.
        // (i.e. 15 with k = 4, to append 1 to form 151 or 9 to form 159).
        // If positive k is possible, append lastDigit + k to the number, and call the method for the next digit.
        if (lastDigit + k <= 9)
            findNumber(n, k, number * 10 + (lastDigit + k), digit + 1, lastDigit + k, list);

        // If negative k is possible, append lastDigit - k to the number, and call the method for the next digit.
        // Additionally, skip this if k == 0 as it can result in duplicates.
        if (k > 0 && lastDigit - k >= 0)
            findNumber(n, k, number * 10 + (lastDigit - k), digit + 1, lastDigit - k, list);
    }
}
