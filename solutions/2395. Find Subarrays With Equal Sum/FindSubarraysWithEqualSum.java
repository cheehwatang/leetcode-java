package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums', as we traverse 'nums' to check every subarray of length 2.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums', as we store the subarray sum in 'nums' in the HashSet.

public class FindSubarraysWithEqualSum {

    // Approach:
    // Using Hash Set to record the sum that is found. Return true when found the same sum in the Hash Set.

    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i < nums.length; i++)
            // The set.add() function returns boolean whether added or not.
            // If the subarray sum is already in the HashSet, then we have found the subarray of equal sum.
            if (!set.add(nums[i] + nums[i - 1])) return true;

        return false;
    }
}
