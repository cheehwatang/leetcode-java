package com.cheehwatang.leetcode;

// Time Complexity  : O(logn),
// where 'n' is 'num'.
// Since we are dividing the number by 2 when it is even, we can approximate the time complexity as O(logn),
// considering it similar to binary search.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input.

public class NumberOfStepsToReduceANumberToZero_Math {

    // Approach:
    // The intuitive approach, to subtract by 1 when odd or divide by 2 when even.

    public int numberOfSteps(int num) {
        int count = 0;
        while (num > 0) {
            num = num % 2 == 0 ? num / 2 : num - 1;
            count++;
        }
        return count;
    }
}
