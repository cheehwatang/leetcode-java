package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse 'nums' array once to implement the Boyer-Moore Voting algorithm.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input.

public class MajorityElement_BoyerMooreVotingAlgorithm {

    // Approach:
    // Implement the Boyer-Moore Voting algorithm to find the majority element.
    // For the majority element, it has a frequency of at least 'n / 2'.
    // As such, all the other elements is definitely less than the majority element.
    //
    // For each pair of numbers, we can check which number is the majority by counting each using one counter.
    // For example:
    // nums = [a,a,b,b,b],
    // We start with the first element as the candidate, candidate = a, count = 1.
    // In this case, 'count' is the count for 'a'.
    // Each time if the element is the same as the 'candidate', increase the count.
    // If the element is different, decrease the count.
    // Whenever the 'count' reaches 0, we switch the 'candidate' to the next element, with count = 1.
    // Using nums = [a,a,b,b,b],
    // 1. candidate = a, count = 1.
    // 2. candidate = a, count = 2.
    // 3. candidate = a, count = 1.
    // 4. candidate = a, count = 0.
    // 5. candidate = b, count = 1.
    // As such, 'b' is the majority.

    public int majorityElement(int[] nums) {
        int count = 0;
        int majority = 0;
        // Traverse the 'nums' array.
        for (int number : nums) {
            // If 'count' is 0, set the next number as the new majority.
            if (count == 0) majority = number;

            // Increase count by 1 if number is the same, and decrease count by 1 if number is different.
            count += (number == majority) ? 1 : (-1);
        }
        // The majority element is the element with positive count.
        return majority;
    }
}
