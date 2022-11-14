package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(nlogn),
// where 'n' is the number of stones, and nlogn due to the sorting algorithm.
//
// Space Complexity : O(n),
// where 'n' is the number of stones, because of the new int[] created before sorting the stones.

public class MovingStonesUntilConsecutive {

    // Approach:
    // For we sort the stones to get the leftmost and rightmost position.
    // There are mainly three cases for the minimum moves:
    // 1. Stones are already in position, no moves possible (e.g. a = 1, b = 2, c = 3).
    // 2. Only one move is needed:
    //    - When two stones are already adjacent, move the remaining stone next to the other stones.
    //      (e.g. a = 1, b = 2, c = 5)
    //    - When two stones are 1 space apart, move the remaining stone between the two stones.
    //      (e.g. a = 1, b = 3, c = 6)
    // 3. Two moves needed, when all three stones are far apart from one another.
    //
    // For the maximum moves, basically just move the stone one position at a time, which is the spaces among the stones.

    public int[] numMovesStones(int a, int b, int c) {
        int[] stones = new int[]{a, b, c};
        Arrays.sort(stones);
        // Case 1.
        if (stones[1] - stones[0] == 1 && stones[2] - stones[1] == 1) {
            return new int[]{0, 0};
        }
        // For Case 2 and Case 3, the maximum moves for the spaces among the stones are the leftmost - rightmost - 2,
        // -1 for the conversion from index to spaces (index 1 and 3 has only 1 space, but index difference is 2).
        // -1 for the stone in the middle that cannot be occupied by the other two stones.
        //
        // Case 2, if either two stones are adjacent or with 1 space in between.
        if (stones[1] - stones[0] <= 2 || stones[2] - stones[1] <= 2) {
            return new int[]{1, stones[2] - stones[0] - 2};
        }
        // Case 3.
        return new int[]{2, stones[2] - stones[0] - 2};
    }
}
