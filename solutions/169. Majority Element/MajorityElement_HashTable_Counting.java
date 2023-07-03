package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// We traverse 'nums' array once to count the frequency of the numbers.
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// We use HashMap with a maximum size of 'n / 2', thus growing linearly with the input 'nums'.

public class MajorityElement_HashTable_Counting {

    // Approach:
    // Using a HashMap to count the frequency of the numbers in 'nums'.
    // If any number has frequency greater than 'n / 2', then that number is the majority number.

    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int result = 0;
        // Traverse 'nums' and count the frequency of the numbers.
        for (int number : nums) {
            int currentCount = map.getOrDefault(number, 0) + 1;

            if (currentCount > nums.length / 2) {
                // Optional to return the result here.
                // We are using a 'result' variable to prevent compile-time error with the
                // return statement after exiting the for-loop.
                result = number;
                break;
            }
            map.put(number, currentCount);
        }
        return result;
    }
}
