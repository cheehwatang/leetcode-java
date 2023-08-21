package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

// Time Complexity  : O(n logn),
// where 'n' is the length of 'nums'.
// For each number in 'nums', we offer to the priority queue with O(logn) time complexity,
// thus resulting in O(n logn) time complexity.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// We use a Priority Queue and HashSet to store the numbers in 'nums',
// with the maximum size the same as the size of 'nums'.

public class ThirdMaximumNumber_PriorityQueue_HashSet {

    // Approach:
    // We use Priority Queue, with comparator set to a max heap, allows us to offer the number to the max heap,
    // then we return the first element if the heap size is less than 3, or return the third element.
    // In order to address the possibilities of duplicated numbers,
    // we use HashSet the keep track of the distinct numbers in 'nums'.
    // We skip the number if the number is already found in the HashSet.

    public int thirdMax(int[] nums) {
        // Set up the Priority Queue as a max heap.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        Set<Integer> set = new HashSet<>();

        // For each number,
        for (int number : nums) {
            // Offer to the priority queue if it is not in the HashSet.
            if (set.add(number))
                pq.offer(number);
        }

        // If there are less than 3 distinct numbers, return the first number in the max heap.
        if (set.size() < 3)
            return pq.peek();

        // Return the third maximum number otherwise.
        pq.poll();
        pq.poll();
        return pq.peek();
    }
}
