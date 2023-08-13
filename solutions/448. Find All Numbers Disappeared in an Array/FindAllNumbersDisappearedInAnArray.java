package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse the 'nums' array twice, once to swap the numbers to the corresponding positions,
// and once to find numbers that are missing.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// The result list has length of 'n'.

public class FindAllNumbersDisappearedInAnArray {

    // Approach:
    // For each number in 'nums', we place the number back to the correct position in 'nums'.
    // For example, in nums = [_4_,3,2,7,8,2,3,1], the first element is 4, and the correct position is index 3 (i - 1).
    // So, we swap nums[0] with nums[3], making nums = [_7_,3,2,_4_,8,2,3,1].
    // We continue to swap until either the number is in the correct position, or the number is a duplicate.
    //
    // Once all the possible numbers are in their respective positions in 'nums',
    // we traverse 'nums' once more to check any numbers that are not in the correct position.
    // If the number is not in the correct position, the actual number in the position is missing.

    public List<Integer> findDisappearedNumbers(int[] nums) {
        // Traverse the 'nums' array,
        for (int i = 0; i < nums.length; i++) {
            // and continue to swap the numbers until either the number is in the correct position,
            // or the number is a duplicate.
            while (nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        List<Integer> result = new ArrayList<>();
        // Traverse 'nums' array once more to check if the number is in the correct position.
        // If it is not, add the number to the result list.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) result.add(i + 1);
        }
        return result;
    }
}
