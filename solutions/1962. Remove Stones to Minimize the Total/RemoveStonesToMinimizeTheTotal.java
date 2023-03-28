package com.cheehwatang.leetcode;

import java.util.Collections;
import java.util.PriorityQueue;

// Time Complexity  : O(n logn + k logn),
// where 'n' is the size of 'piles', and 'k' is the number of operations performed.
// The enqueing (offer()) and dequeing (poll()) methods have time complexity of O(logn).
// First, we perform the enqueing for all the elements in 'piles' of size 'n', resulted in O(n logn).
// Then, we perform both enqueing and dequeing 'k' number of times, resulted in O(2 * k logn).
// Including both complexities and simplifying resulted in O(n logn + k logn).
//
// Space Complexity : O(n),
// where 'n' is the size of 'piles'.
// This is due to the use of priority queue, with size grows linearly with 'n'.

public class RemoveStonesToMinimizeTheTotal {

    // Approach:
    // Since we are trying to remove most stones (or getting the minimum stone sum),
    // we always remove from the piles with the greatest number of stones.
    // With that, we can implement as maximum heap to get the pile with the most stones for each operation.

    public int minStoneSum(int[] piles, int k) {

        // Set up a max heap (reversed priority queue) with all the piles in 'piles',
        // and also record the sum of the stones.
        // Other than using Collections.reverseOrder() to change the min heap to max heap,
        // we can use lambda expression: "(a, b) -> b - a".
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        int stoneSum = 0;
        for (int pile : piles) {
            maxHeap.offer(pile);
            stoneSum += pile;
        }

        // For each operation, remove the stones from the piles containing most stones.
        while (k-- > 0) {
            // Get the pile with the most stones.
            int largestPile = maxHeap.poll();
            // As we are using primitive type int, division always results in the floor integer of the division.
            stoneSum -= largestPile / 2;
            // Put the leftovers back into the max heap.
            maxHeap.offer(largestPile - (largestPile / 2));
        }

        // After 'k' operations, we have the minimum stone sum.
        return stoneSum;
    }
}
