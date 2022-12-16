package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// Time Complexity  : O(2^n),
// where 'n' is the length of the integer.
// The worst case scenario is when 'k' == 1, every increment in length 'n' doubles the number of integers to check.
//
// Space Complexity : O(2^n),
// where 'n' is the length of the integer.
// The worst case scenario is when 'k' == 1, every increment in length 'n' doubles the number of results.

public class NumbersWithSameConsecutiveDifferences_BFS {

    // Approach:
    // Using breadth first search (BFS) to append 0 - 9 to each number starting from 1 to 9 to form possible numbers,
    // until the numbers have 'n' digits. Note that starting from 1 to 9 as leading zero is not valid.

    public int[] numsSameConsecDiff(int n, int k) {
        List<Integer> result = new ArrayList<>();

        // Starting from 1 to 9 as the first digit.
        for (int i = 1; i <= 9; i++) {
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            // As the first element is at length of 1.
            int length = 1;
            // Continue to add append the digits until length of 'n'.
            while (++length <= n) {
                // Make sure to set store the queue size in a variable first.
                // This is to prevent the loop for terminating prematurely as we are polling elements from the queue.
                // Each length, append the digit to all the numbers that is in the queue.
                for (int j = 0, l = queue.size(); j < l; j++) {
                    int number = queue.poll();

                    // Get the last digit of the number,
                    // to check whether the 'k' difference is positive or negative.
                    // (i.e. 15 with k = 4, to append 1 to form 151 or 9 to form 159)
                    int lastDigit = number % 10;

                    // If positive k is possible, add to the queue.
                    if (lastDigit + k <= 9)
                        queue.offer(number * 10 + (lastDigit + k));

                    // If negative k is possible, add to the queue.
                    // Additionally, skip this if k == 0 as it can result in duplicates.
                    if (k > 0 && lastDigit - k >= 0)
                        queue.offer(number * 10 + (lastDigit - k));
                }
            }
            result.addAll(queue);
        }
        // Convert the queue to an int array.
        return result.stream().mapToInt(i -> i).toArray();
    }
}
