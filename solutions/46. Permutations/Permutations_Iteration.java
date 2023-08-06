package com.cheehwatang.leetcode;

import java.util.LinkedList;
import java.util.List;

// Time Complexity  : O(n * n!),
// where 'n' is the length of 'nums'.
// For each number in 'nums', we traverse each position for the permutations to add the number,
// with each permutation being O(n!).
//
// Space Complexity : O(n!),
// where 'n' is the length of 'nums'.
// The result has 'n!' of permutations, thus the space complexity is O(n!).

public class Permutations_Iteration {

    // Approach:
    // To get the permutations for 'n' number, we can add each number into the resulting List of permutations
    // in every possible position.
    //
    // For example, nums = [A,B,C],
    // we start the list with a single permutation of the first element, A, with result = [[A]].
    // For the second number, B, we put in every possible position (index 0 to i - 1),
    // resulting in result = [[B,A],[A,B]].
    // For the third number, C, we repeat the process for each permutation in the result,
    // with result = [[C,B,A],[B,C,A],[B,A,C],[C,A,B],[A,C,B],[A,B,C]],
    // with the first 3 for [B,A], and the last 3 for [A,B].
    //
    // In this solution, we create a new result list for each number in 'nums',
    // for easier understanding of the solution.
    // Additionally, we used LinkedList instead of ArrayList, because we are adding elements at specific position,
    // for better efficiency.

    public List<List<Integer>> permute(int[] nums) {
        // Create an empty result list.
        List<List<Integer>> result = new LinkedList<>();
        // Add the first element in 'nums' to a new list and add to the 'result'.
        result.add(List.of(nums[0]));

        // For each number in 'nums',
        for (int i = 1; i < nums.length; i++) {
            // we create a new result list,
            List<List<Integer>> newResult = new LinkedList<>();
            // and add the number in each position,
            for (int position = 0; position <= i; position++) {
                // for each of the permutations in 'result'.
                for (List<Integer> permutation : result) {
                    // Be sure to create a new copy of the List with the permutation,
                    // to prevent using the same permutation for each position.
                    List<Integer> current = new LinkedList<>(permutation);
                    // Add the number in the position,
                    current.add(position, nums[i]);
                    // and add to the new result.
                    newResult.add(current);
                }
            }
            // Once the new permutations are formed, update 'result' with the 'newResult'.
            result = newResult;
        }
        // Once all the permutations are formed, return the result.
        return result;
    }
}
