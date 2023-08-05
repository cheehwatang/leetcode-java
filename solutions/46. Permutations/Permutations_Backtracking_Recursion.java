package com.cheehwatang.leetcode;

import java.util.ArrayList;
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

public class Permutations_Backtracking_Recursion {

    // Approach:
    // To get the permutations for 'n' number, we need to use every number in every possible positions.
    // Using a backtrack method, we can test each number in 'nums' for each position,
    // and only add to the position if the number is not already in the current permutation.
    // This is possible because of the constraint that each element in 'nums' is unique.
    //
    // For example, nums = [A,B,C], currentList = [].
    // First position:
    // First element, A, is not in 'currentList', so we put A into 'currentList', resulting in currentList = [A].
    // Move on to second position.
    //
    // Second position:
    // First element, A, is in 'currentList', then we skip.
    // Second element, B, is not in 'currentList', so we put B into 'currentList', resulting in currentList = [A,B].
    // Move on to third position.
    //
    // Third position:
    // First element, A, is in 'currentList', then we skip.
    // Second element, B, is in 'currentList', then we skip.
    // Third element, C, is not in 'currentList', so we put C into 'currentList', resulting in currentList = [A,B,C].
    // With the 'currentList' having the same length as 'nums', we add [A,B,C] into the result.
    // Backtrack to the second position, currentList = [A,B].
    //
    // Second position:
    // Continue with the third element, C.
    // Third element, C, is not in 'currentList', so we put C into 'currentList', resulting in currentList = [A,C].
    // Move on to third position.
    //
    // Third position:
    // First element, A, is in 'currentList', then we skip.
    // Second element, B, is not in 'currentList', so we put B into 'currentList', resulting in currentList = [A,C,B].
    // With the 'currentList' having the same length as 'nums', we add [A,C,B] into the result.
    // Backtrack to the second position, currentList = [A,C].
    // Third element, C, is in 'currentList', then we skip.
    // Backtrack to the first position, currentList = [A].
    //
    // Then continue to change the first position to B or C, and continue the process.
    //
    // Here, we are using recursion to build up each permutation until length 'n', then add to the result list.
    // Note that we are using only one list to record the permutation.
    // As such, we need to create a new list copy before adding to the result list.

    // Main method to get the list of permutations.
    public List<List<Integer>> permute(int[] nums) {
        // Create a new empty list as the result.
        List<List<Integer>> result = new ArrayList<>();
        // Initialize the recursive method.
        // Note that we are using a boolean array to keep track if the element is used in the current permutation.
        // This approach allows duplicate values in 'nums'.
        // Alternatively, we could check using List.contains() method,
        // with the condition that each element in 'nums' is unique.
        backtrack(nums, result, new ArrayList<>(), new boolean[nums.length]);

        // Once all the recursive methods are completed, return the result.
        return result;
    }

    // Recursive method to build each permutation and backtracking.
    private void backtrack(int[] nums, List<List<Integer>> result, List<Integer> currentList, boolean[] used) {
        // If the 'currentList' has the same length as 'nums', it means that the permutation is formed,
        // thus we add to 'result'.
        if (currentList.size() == nums.length) {
            result.add(new ArrayList<>(currentList));
            return;
        }

        // For each element in 'nums',
        for (int i = 0; i < nums.length; i++) {
            // we skip the element if it is already used in 'currentList'.
            if (used[i]) continue;
            // Otherwise, add the element into 'currentList',
            currentList.add(nums[i]);
            // and mark as used,
            used[i] = true;
            // before calling moving to the next position to check all the elements for that position.
            backtrack(nums, result, currentList, used);
            // Once finish traversing the recursion, backtrack by setting the current element to false in 'used[i]',
            used[i] = false;
            // and remove the element from 'currentList'.
            currentList.remove(currentList.size() - 1);
        }
    }
}
