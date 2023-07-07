package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse 'nums' once to count the frequency of the numbers.
// Then, we check the recorded number if the frequency is greater than 'n / 3'.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// The HashMap has a maximum size of '2n / 3', which is linear with the input 'nums'.

public class MajorityElementII_HashTable_Counting {

    // Approach:
    // We count the frequency of the numbers in 'nums' using a HashMap.
    // Then, we check each distinct number recorded if the frequency is greater than 'n / 3'.

    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        // Count the frequency of each number in 'nums'.
        for (int number : nums)
            map.put(number, map.getOrDefault(number, 0) + 1);

        List<Integer> result = new ArrayList<>();
        // From the HashMap, find the majority number if frequency greater than 'n / 3'.
        for (int key : map.keySet())
            if (map.get(key) > (n / 3)) result.add(key);

        return result;
    }
}
