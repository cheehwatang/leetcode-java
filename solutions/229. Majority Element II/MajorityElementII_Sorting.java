package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Time Complexity  : O(n logn),
// where 'n' is the length of 'nums'.
// We use Arrays.sort() method which implements Dual-Pivot Quicksort with O(n logn) time complexity.
// Then, we traverse 'nums' to count and find the numbers with frequency greater than 'n / 3'.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input 'nums'.

public class MajorityElementII_Sorting {

    // Approach:
    // With sorting the 'nums' array, we can get the numbers in ascending order.
    // As such, we can count each distinct number to check if the frequency is greater than 'n / 3'.

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        List<Integer> result = new ArrayList<>();
        int previous = nums[0];
        int count = 1;
        // For each number, count the frequency.
        for (int i = 1; i < n; i++) {
            // If the current number is the same as previous, increase the count by 1.
            if (nums[i] == previous) {
                count++;
            }
            // If the current number is different, check if the previous number count is the majority.
            // Then, change the counting number to the current number.
            else {
                if (count > n / 3) result.add(previous);
                count = 1;
                previous = nums[i];
            }
        }
        // Check if the last element is the majority.
        if (count > n / 3) result.add(previous);

        return result;
    }
}
