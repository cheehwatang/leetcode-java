package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse 'nums' to check each number for their range.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// The maximum size of the result list is 'n', which each element being unique and not in any range.

public class SummaryRanges {

    // Approach:
    // We traverse 'nums', recording the 'start' number for each range.
    // While the current element is within range with the next element,
    // shift the index to the next until we found the end of the current range.
    // If the current number is the same as 'start', add the number as String to the result.
    // Else, add the Stringify range to the result, for example "1->2".

    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;

        List<String> result = new ArrayList<>();

        // Traverse 'nums'.
        for (int i = 0; i < n; i++) {
            int start = nums[i];
            // While the current element is within range with the next element,
            // shift the index until we found the end of the range.
            while (i + 1 < n && nums[i] + 1 == nums[i + 1])
                i++;

            // If the current number is the same as 'start', add the number as String to the result.
            if (start == nums[i])
                result.add(String.valueOf(start));
            // Else, add the Stringify range to the result, for example "1->2".
            else
                result.add(String.join("->", String.valueOf(start), String.valueOf(nums[i])));
        }
        return result;
    }
}
