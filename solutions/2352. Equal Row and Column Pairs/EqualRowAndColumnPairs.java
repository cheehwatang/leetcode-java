package com.cheehwatang.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

// Time Complexity  : O(n^2),
// where 'n' is the length and width of 'grid', grid.length and grid[i].length.
// We traverse the matrix twice, first to record the frequency of the row elements,
// and second is the count the number of equal pairs.
//
// Space Complexity : O(n^2),
// where 'n' is the length and width of 'grid', grid.length and grid[i].length.
// We basically convert the whole matrix into a HashMap with String of 'n' length as the key.

public class EqualRowAndColumnPairs {

    // Approach:
    // Using HashMap, we record the frequency of each row.
    // Then, we can traverse the matrix again, column-wise, to count the number of equal pairs.
    // Note that it is not a good practice to use array as key to the HashMap,
    // as different arrays with the same elements have different hashcode.
    // As such, we would convert the array into String using a delimiter, before storing as key.

    public int equalPairs(int[][] grid) {
        int n = grid.length;

        Map<String, Integer> map = new HashMap<>();

        // Traverse 'grid' row-wise.
        for (int[] row : grid) {
            // For each row, join the elements into a String.
            // Count the frequency of the string in the HashMap.
            String rowStr = Arrays.stream(row).mapToObj(String::valueOf).collect(Collectors.joining(","));
            map.put(rowStr, map.getOrDefault(rowStr, 0) + 1);
        }

        int count = 0;
        // Traverse 'grid' column-wise.
        for (int column = 0; column < n; column++) {
            // For each column, join the elements into a String.
            // Here, we need to store the column elements into the array first, then only join the String.
            String[] columnArr = new String[n];
            for (int row = 0; row < n; row++) {
                columnArr[row] = String.valueOf(grid[row][column]);
            }
            String columnStr = String.join(",", columnArr);
            // For each column String, we check how many equal pairs that can be formed and add to the count.
            count += map.getOrDefault(columnStr, 0);
        }
        return count;
    }
}
