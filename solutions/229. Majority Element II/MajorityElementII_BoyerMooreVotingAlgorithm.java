package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse 'nums' twice, once to find the majority candidate,
// and once to verify if the majority candidates has frequency greater than 'n / 3'.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input 'nums'.

public class MajorityElementII_BoyerMooreVotingAlgorithm {

    // Approach:
    // Using the Boyer-Moore Voting algorithm, we find the 2 candidates that can be the majority numbers.
    // This is a modified approach from Boyer-Moore Voting algorithm used to solve "169. Majority Element",
    // where the number with positive count at the end is the majority element.
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
    //
    // With this approach, we can check 2 candidates,
    // and increase the count if the current number is the same as either candidate.
    // If the number is different from both candidates, reduce the count for both candidates.
    // We switch candidate if any of the count reaches 0.

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        // We can use any numbers within the int primitive type, as the count for both candidates are 0.
        // If just so happen the number in 'nums' is the same as the candidate,
        // it will increase the count to 1 anyway.
        int candidate1 = 0, candidate2 = 0, count1 = 0, count2 = 0;
        for (int number : nums) {
            // If the number is the same as 'candidate1'.
            if (number == candidate1) {
                count1++;
            }
            // If the number is the same as 'candidate2'.
            else if (number == candidate2) {
                count2++;
            }
            // If the number different from either candidates,
            // switch with 'candidate1' if 'count1' is 0, or
            else if (count1 == 0) {
                candidate1 = number;
                count1 = 1;
            }
            // switch with 'candidate2' if 'count2' is 0.
            else if (count2 == 0) {
                candidate2 = number;
                count2 = 1;
            }
            // If the number is different and none of the counts are 0,
            // reduce the count for both candidates.
            else {
                count1--;
                count2--;
            }
        }

        // At this point, we are not certain if the candidates have frequency greater than 'n / 3'.
        // With Boyer-Moore Voting algorithm, we only asserted that both candidates
        // are the two numbers with the greatest frequency in 'nums'.
        count1 = 0; count2 = 0;
        // Thus, we count the frequency of both candidates,
        for (int number : nums) {
            if (number == candidate1) count1++;
            else if (number == candidate2) count2++;
        }
        List<Integer> result = new ArrayList<>();
        // and add to result if the frequency is greater than 'n / 3'.
        if (count1 > n / 3) result.add(candidate1);
        if (count2 > n / 3) result.add(candidate2);

        return result;
    }
}
