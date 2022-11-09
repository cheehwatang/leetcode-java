package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Problem:
 * Given an array of digit strings 'nums' and a digit string 'target', return the number of pairs of elements in 'nums',
 * where i != j and concatenation of "nums[i] + nums[j]" equals 'target'.
 * Note that the strings only consists of number digits.
 *
 *
 * Example 1:
 * Input : nums = ["1","11","111","1111"], target = "11111"
 * Output: 4
 * Explanation:
 * - (0, 3): "1" + "1111"
 * - (3, 0): "1111" + "1"
 * - (1, 2): "11" + "111"
 * - (2, 1): "111" + "11"
 *
 *
 * Example 2:
 * Input : nums = ["22","22","22"], target = "2222"
 * Output: 6
 * Explanation:
 * - (0, 1): "22" + "22"
 * - (1, 0): "22" + "22"
 * - (0, 2): "22" + "22"
 * - (2, 0): "22" + "22"
 * - (1, 2): "22" + "22"
 * - (2, 1): "22" + "22"
 *
 *
 * @author Chee Hwa Tang
 */

public class NumberOfPairsOfStringsWithConcatenationEqualToTarget_HashTable {

    // Approach:
    // Using Hash Map to record the frequency of the elements in 'nums',
    // while checking for its prefix or suffix that can form 'target'.
    // The String class offers two helpful methods, startWith(String) and endsWith(String),
    // which returns boolean whether the string starts with or ends with the input string.
    //
    // Note: This problem can be solved with Brute Force nested for-loops to check the concatenation of every element.

    public int numOfPairs(String[] nums, String target) {
        Map<String, Integer> map = new HashMap<>();
        int count = 0;
        for (String number : nums) {
            // If 'number' is the prefix of 'target', check if the corresponding suffix is in the map.
            if (target.startsWith(number)) {
                String suffix = target.substring(number.length());
                count += map.getOrDefault(suffix, 0);
            }
            // If 'number' is the suffix of 'target', check if the corresponding prefix is in the map.
            if (target.endsWith(number)) {
                String prefix = target.substring(0, target.length() - number.length());
                count += map.getOrDefault(prefix, 0);
            }
            // Note that we used two if-statements here, since 'number' can be both prefix and suffix of 'target',
            // as shown in Example 1.

            // For each, record the frequency of 'number' in the map.
            map.put(number, map.getOrDefault(number, 0) + 1);
        }
        return count;
    }
}
