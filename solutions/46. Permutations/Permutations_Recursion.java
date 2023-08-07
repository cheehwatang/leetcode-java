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
// Additionally, the recursive call stack has a maximum length of 'n'.

public class Permutations_Recursion {

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
    // Here, we are using recursion to build up each permutation until length 'n', then add to the result list.
    // Additionally, we used LinkedList instead of ArrayList, because we are adding elements at specific position,
    // for better efficiency.

    // Main method to get the list of permutations.
    public List<List<Integer>> permute(int[] nums) {
        // Create a new empty list as the result.
        List<List<Integer>> result = new LinkedList<>();
        // Initialize the recursive method, starting at index 0.
        permute(nums, result, new LinkedList<>(), 0);

        // Once all the recursive methods are completed, return the result.
        return result;
    }

    // Recursive method to build each permutation.
    private void permute(int[] nums, List<List<Integer>> result, List<Integer> currentList, int index) {
        // If the 'currentList' has the same length as 'nums', it means that the permutation is formed,
        // thus we add to 'result'.
        if (currentList.size() == nums.length) {
            result.add(currentList);
            return;
        }

        // For each of the possible positions,
        for (int i = 0; i <= currentList.size(); i++) {
            // make a copy of the 'currentList',
            List<Integer> current = new LinkedList<>(currentList);
            // and add the number to the position.
            current.add(i, nums[index]);
            // Once added, continue to add to the permutation with the recursive method,
            // by increasing the index by 1.
            permute(nums, result, current, index + 1);
        }
    }
}
