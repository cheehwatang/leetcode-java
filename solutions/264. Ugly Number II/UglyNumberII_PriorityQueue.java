package com.cheehwatang.leetcode;

import java.util.PriorityQueue;

// Time Complexity  : O(n logn),
// as the poll() function in the priority queue has a logarithmic O(logn) complexity,
// and we are performing poll() at least 'n' number of times.
// There is also a O(logn) time complexity when we use the add() function in the priority queue,
// resulting in an additional O(3 * n * logn) time complexity.
//
// Space Complexity : O(n),
// as the priority queue grows linearly with 'n'.

public class UglyNumberII_PriorityQueue {

    // Approach:
    // Ugly number is found with the multiplication of an ugly number (including 1) with 2, 3 or 5.
    // So, we use priority queue to get the smallest of the ugly numbers found so far,
    // and multiple them with 2, 3 or 5, to get new ugly numbers.
    // As priority queue is a minimum heap data structure,
    // the smallest ugly number in the priority queue is the i-th ugly number.
    // For Example, with priority queue having 1.
    // Next, we add 2 * 1, 3 * 1, and 5 * 1 into the priority queue, removing the number 1.
    // With 2, 3 and 5 in the priority queue, the smallest number is 2.
    // Thus, we add 2 * 2 == 4, 3 * 2 == 6, and 5 * 2 == 10, into the priority queue.
    // We continue until the n-th iteration.
    // Do note that there can be multiple identical ugly numbers,
    // so make sure to remove identical numbers (if any) from the priority queue.

    public int nthUglyNumber(int n) {
        // Note that we are using Long primitive type, because this method will result in overflow if we use Integer.
        // For example if the smallest number in the priority queue is (2 ^ 31) - 1,
        // then it means that other numbers in the priority queue is greater than Integer.MAX_VALUE.
        PriorityQueue<Long> pq = new PriorityQueue<>();
        pq.add(1L);
        for (int i = 1; i < n; i++) {
            long value = pq.remove();
            // Check and remove identical ugly numbers.
            while (pq.size() > 0 && pq.peek() == value) pq.poll();
            pq.add(value * 2);
            pq.add(value * 3);
            pq.add(value * 5);
        }
        // The next smallest ugly number is the n-th ugly number.
        return pq.remove().intValue();
    }
}
