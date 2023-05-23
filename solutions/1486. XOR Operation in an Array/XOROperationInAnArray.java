package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the input 'n'.
// We traverse from 0 to 'n' to get the XOR for each number.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input.

public class XOROperationInAnArray {

    // Approach:
    // With the intuitive approach of iterating from 0 to 'n',
    // and XOR '^' the result for each number "start + 2 * i".

    public int xorOperation(int n, int start) {
        int result = 0;
        for (int i = 0; i < n; i++) {
            result ^= (start + 2 * i);
        }
        return result;
    }
}
