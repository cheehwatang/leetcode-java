package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n^2),
// where 'n' is the length of 'nums'.
// The traversal of 'nums' to make the number-index Pairs has linear time complexity O(n).
// The sort() method has a time complexity of O(n logn).
// When traversing the sorted array to check for 'indexDiff', the worst-case is when 'valueDiff' is very large,
// resulting in quadratic time complexity, O(n^2).
// Considering all the time complexity, the most impactful is O(n^2).
//
// Space Complexity : O(n),
// where 'n' is the length of 'nums'.
// The traversal of 'nums' to make the number-index Pairs has linear space complexity O(n).

public class ContainsDuplicateIII_Sorting {

    // Approach:
    // First, we couple the 'number' and the 'index' as Pair, for each number in 'nums', by creating a new class Pair.
    // This way, we can sort the Pair based on the 'number'.
    // Once sorted, we can iterate through the numbers within the 'valueDiff' range for each 'number' (Pair),
    // and check if the index difference is within 'indexDiff'.
    // Return true when the numbers within 'valueDiff' and 'indexDiff' is found.

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        // The constraints in the problem descriptions already satisfy the conditions below, but
        // let's just check the input to be sure.
        if (nums == null || nums.length <= 1 || indexDiff == 0 || valueDiff < 0)
            return false;

        // Create a number-index pair for all the numbers in 'nums', and store into a Pair array.
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }

        // With the compareTo() method in the Pair class defined, this will stable sort in ascending order of the numbers.
        Arrays.sort(pairs);

        // Traverse the sorted Pair array to check if the numbers are within the valueDiff and the indexDiff range.
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length && pairs[j].value - pairs[i].value <= valueDiff; j++) {
                if (Math.abs(pairs[i].index - pairs[j].index) <= indexDiff) {
                    return true;
                }
            }
        }

        // If successfully traverse the whole array, meaning we fail to find any numbers fulfilling the conditions.
        return false;
    }

    // Pair class to map both 'number' (value) and index together.
    // For sorting, we need to implement the Comparable interface, and define the compareTo method,
    // so that we sort the Pair based on the 'number' (value).
    class Pair implements Comparable<Pair> {

        // Storing the value and index.
        int value;
        int index;

        // Constructor.
        public Pair(int value, int position) {
            this.value = value;
            this.index = position;
        }

        // We want to later sort the array in the ascending order of value.
        @Override
        public int compareTo(Pair pair) {
            return this.value - pair.value;
        }
    }
}
