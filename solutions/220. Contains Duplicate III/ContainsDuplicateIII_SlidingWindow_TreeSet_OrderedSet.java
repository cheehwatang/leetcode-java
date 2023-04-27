package com.cheehwatang.leetcode;

import java.util.TreeSet;

// Time Complexity  : O(n logn),
// where 'n' is the length of 'nums'.
// As we traverse 'nums', we perform floor(), ceiling(), remove() and add() methods on the TreeSet for each time.
// The four methods used have a time complexity of O(logn).
// Thus, the final time complexity is O(n logn).
//
// Space Complexity : O(k),
// where 'k' is the value of 'indexDiff'.
// As we are adding and removing the numbers from the TreeSet, the maximum size of the TreeSet is 'indexDiff'.

public class ContainsDuplicateIII_SlidingWindow_TreeSet_OrderedSet {

    // Approach:
    // This problem requires us to check both directions of the 'valueDiff', +/-.
    // As such, an OrderedSet such as TreeSet is important when implementing a Sliding Window technique.
    // The Sliding Window is to ensure that we are comparing numbers within the 'indexDiff' range from the current number.
    // The TreeSet help us check if there are any number within the Sliding Window that is within the 'valueDiff' range.
    // Details of the implementation is explained below.

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        // The constraints in the problem descriptions already satisfy the conditions below, but
        // let's just check the input to be sure.
        if (nums == null || nums.length <= 1 || indexDiff == 0 || valueDiff < 0)
            return false;

        TreeSet<Integer> slidingWindow = new TreeSet<>();

        // Traverse the 'nums' to check each numbers using the SlidingWindow (TreeSet).
        for (int index = 0; index < nums.length; index++) {

            // TreeSet.floor() returns the largest number less than or equal to the given element in the set.
            // TreeSet.ceiling() returns the smallest number more than or equal to the given element in the set.
            // Both return null if no number is found.
            // Here, we find if any numbers, nums[index] - valueDiff >= number >= nums[index] + valueDiff.
            Integer floor = slidingWindow.floor(nums[index] + valueDiff);
            Integer ceiling = slidingWindow.ceiling(nums[index] - valueDiff);

            // If we found numbers in the SlidingWindow that is within the 'valueDiff' range from nums[index],
            // it means that we found the number pair that fulfills the 3 conditions.
            if ((floor != null && floor >= nums[index]) || (ceiling != null && ceiling <= nums[index]))
                return true;

            // Expand the sliding window until index == indexDiff.
            // Afterwards, we will slide the SlidingWindow to the right,
            // by remove the last number, and adding the latest number.
            if (index >= indexDiff)
                slidingWindow.remove(nums[index - indexDiff]);

            slidingWindow.add(nums[index]);
        }

        // If successfully traverse the whole array, meaning we fail to find any numbers fulfilling the conditions.
        return false;
    }
}
