package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;

// Time Complexity  : O(n),
// where 'n' is the length of 'intervals'.
// We traverse the 'intervals' to check for the position of insertion as well as merging any overlapping intervals.
//
// Space Complexity : O(n),
// where 'n' is the length of 'intervals'.
// We use a new ArrayList and a new array for the result.

public class InsertInterval {

    // Approach:
    // Traverse the 'intervals' array to find the following 3 cases:
    // 1. The non-overlapping intervals before the 'newInterval',
    // 2. The overlapping intervals with 'newInterval', and
    // 3. The non-overlapping intervals after the 'newInterval'.
    // Use a new List to put the new intervals.
    // Lastly, convert the list into array and return the result.
    // The use of List is due to the uncertainty of the size of the array after the insertion.
    // So we only create a new result array after we have inserted the 'newInterval'.

    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int index = 0;

        List<int[]> result = new ArrayList<>();

        // Case 1: No overlapping intervals before the 'newInterval'.
        // There are no overlaps before the 'newInterval'
        // if the starting point of 'newInterval' is greater than the ending point of the interval.
        while (index < n && newInterval[0] > intervals[index][1])
            result.add(intervals[index++]);

        // Case 2: Overlapping of the interval(s) and 'newInterval', if any.
        // If there are overlaps, update the 'newInterval' until we have merged all the overlapping intervals.
        while (index < n && newInterval[1] >= intervals[index][0]) {
            newInterval[0] = Math.min(newInterval[0], intervals[index][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[index][1]);
            index++;
        }
        // Once merged, put the merged interval into the result.
        result.add(newInterval);

        // Case 3: No overlapping intervals after the 'newInterval'.
        while (index < n)
            result.add(intervals[index++]);

        // Convert the List to Array and return the result.
        return result.toArray(new int[result.size()][2]);
    }
}
