package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n),
// where 'n' is the length of 'nums'.
// As we traverse 'nums' once to compare if any numbers are within the 'indexDiff' and 'valueDiff' range.
//
// Space Complexity : O(k),
// where 'k' is the value of 'indexDiff'.
// As we are adding and removing the numbers from the HashMap, the maximum size of the HashMap is 'indexDiff'.

public class ContainsDuplicateIII_SlidingWindow_HashMap_BucketSort {

    // Approach:
    // We use Bucket Sort to group the numbers into their respective buckets,
    // with each bucket representing the range of 'valueDiff'.
    // As such, the Bucket Sort is important when implementing a Sliding Window technique.
    // The Sliding Window is to ensure that we are comparing numbers within the 'indexDiff' range from the current number.
    // The Bucket Sort is to help us check if there are any number within the Sliding Window that is within the 'valueDiff' range.
    // Note that each Bucket only represents half of the negative and half of the positive from 'valueDiff'.
    // Thus, we need to check the top half of (Bucket - 1) and bottom half of (Bucket + 1),
    // to ensure that we check the whole positive and negative range of 'valueDiff'.

    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {

        // The constraints in the problem descriptions already satisfy the conditions below, but
        // let's just check the input to be sure.
        if (nums == null || nums.length <= 1 || indexDiff == 0 || valueDiff < 0)
            return false;

        // The HashMap stores the key = bucket and value = nums[index].
        Map<Integer, Integer> slidingWindow = new HashMap<>();

        // The new value diff is ('valueDiff' + 1) to ensure that the getBuckets() method don't get error when dividing 0,
        // and to get positive integer < ceiling.
        // However, all the future comparisons of Math.abs(nums[i] - nums[j]) < valueDiff + 1.
        int newValDiff = valueDiff + 1;

        for (int index = 0; index < nums.length; index++) {

            // Group each numbers into buckets.
            int buckets = getBuckets(nums[index], newValDiff);

            // If nums[index] is within the same bucket in the slidingWindow,
            // meaning it is within the 'valueDiff' and 'indexDiff' range.
            // Imagine:
            // number1 / valueDiff = 1.5, is at bucket 1,
            // number2 / valueDiff = 2.5, is at bucket 2, and
            // number3 / valueDiff = 0.5, at bucket 0.
            // For numbers in bucket 0 and 2, we need to check if the number is < 2.5, or > 0.5.
            if (slidingWindow.containsKey(buckets))
                return true;

            if (slidingWindow.containsKey(buckets - 1)
                    && Math.abs(nums[index] - slidingWindow.get(buckets - 1)) < newValDiff) {
                return true;
            }
            if (slidingWindow.containsKey(buckets + 1)
                    && Math.abs(nums[index] - slidingWindow.get(buckets + 1)) < newValDiff) {
                return true;
            }

            // Expand the sliding window until index == indexDiff.
            // Afterwards, we will slide the SlidingWindow to the right,
            // by remove the last number, and adding the latest number.
            if (index >= indexDiff) {
                slidingWindow.remove(getBuckets(nums[index - indexDiff], newValDiff));
            }
            slidingWindow.put(buckets, nums[index]);
        }

        // If successfully traverse the whole array, meaning we fail to find any numbers fulfilling the conditions.
        return false;
    }

    // Method to group numbers into buckets (as the multipliers of the valueDiff)
    private int getBuckets(int integer, int valueDiff) {
        // For negative integer, add 1, so that the multiple is > -1 and <= -0. However, we use -1 of the result to avoid
        // collision of -0 and 0. This ensures the positive 0 and negative 0 range is in separate buckets.
        // For positive integer, the value can be within >= 0 and < 1, since valueDiff is already + 1.
        return integer < 0 ? (integer + 1)/valueDiff - 1 : integer / valueDiff;
    }

}
