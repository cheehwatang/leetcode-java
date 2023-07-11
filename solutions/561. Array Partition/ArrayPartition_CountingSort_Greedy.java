package com.cheehwatang.leetcode;

// Time Complexity  : O(n + 20001),
// where 'n' is the length of 'nums'.
// The counting array creation and the counting array traversal has time complexity O(20001).
// Depending the size of input array 'nums', this could be significant.
// Next, we traverse the array 'nums' to perform counting sort, with linear time complexity.
//
// Space Complexity : O(1),
// as the counting array has a fixed size of 20001, regardless of the size of the input.

public class ArrayPartition_CountingSort_Greedy {

    // Approach:
    // From the problem, we know that the best approach is to pair the numbers with the least difference,
    // and sum the lower number of the pair.
    // This is the greedy approach, as we only consider the lower number of the pair,
    // regardless on the value, as we know this would lead to the maximum sum.
    //
    // With that understanding, we can perform counting sort on the numbers in 'nums'.
    // Then, we sum the number in an alternate manner while traversing the counting array.
    // Note: The counting sort approach works because we know the possible range of the numbers.

    public int arrayPairSum(int[] nums) {
        // As the constraint stated that "-10e4 <= nums[i] <= 10e4",
        // thus the counting array needed to account the range.
        int[] counting = new int[20001];

        // Perform counting sort, recording the frequency of each number in 'nums'.
        // As the range includes the negative numbers, we offset the counting array by 10000.
        for (int number : nums) counting[number + 10000]++;

        // 'count' flag to keep track which number to sum.
        boolean count = true;
        int sum = 0;
        for (int i = 0; i < counting.length; i++) {
            // As counting[i] represents the frequency, we use a while loop to keep checking until 0.
            while (counting[i] > 0) {
                // If the flag 'count' is true, we sum the number.
                // Note: we need to consider the offset of 10000 we performed earlier.
                if (count) sum += (i - 10000);

                counting[i]--;
                // Alternate the flag for each number.
                count = !count;
            }
        }
        return sum;
    }
}
