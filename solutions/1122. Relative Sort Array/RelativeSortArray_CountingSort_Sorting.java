package com.cheehwatang.leetcode;

// Time Complexity  : O(n + m),
// where 'n' is the length of 'arr1', and 'm' is the length of 'arr2'.
// We traverse 'arr1' and 'arr2' once, results in O(n + m) time complexity.
// Additionally, we traverse all the elements in 'arr1' from the 'counting' array
// as we rebuild the 'arr1' array.
// We can also simplify to time complexity to O(n), as 'arr2' is a subset of 'arr1'.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent on the size of the input 'arr1' and 'arr2'.
// Additionally, we replace the result with 'arr1' instead of creating a new 'result' array.

public class RelativeSortArray_CountingSort_Sorting {

    // Approach:
    // Using counting sort to first record the frequency of each element in 'arr1' into a 'counting' array.
    // Then, we traverse 'arr2' to check the relative position,
    // and input the elements into the result array in ascending index order.
    // After traversing 'arr2', we traverse the 'counting' array to input the remaining elements
    // into the result array in ascending number order.
    //
    // Note: The counting array approach is possible due to the stated constraint of "0 <= arr1[i] <= 1000".

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // With the constraint of "0 <= arr1[i] <= 1000", we set up the counting array of size 1001,
        // accounting for the zero-indexing.
        int[] counting = new int[1001];

        // Perform counting sort, with the index representing the number,
        // and counting[i] representing the frequency.
        for (int number : arr1) counting[number]++;

        // Index 'i' is to keep track of the position in the result array.
        // Here, we use 'arr1' as the result array to reduce space complexity when using a new 'result' array.
        // Optional to use a new 'result' array for better readability and clarity.
        int i = 0;
        for (int number : arr2) {
            // For each number in 'arr2', we add the number with counting[i] frequency into the result array.
            while (counting[number] > 0) {
                // Shifting index 'i' each time a number is added to the result.
                arr1[i++] = number;
                counting[number]--;
            }
        }

        // Traverse the 'counting' array to get the remaining numbers that are not in 'arr2'.
        for (int number = 0; number < counting.length; number++) {
            // For each number in 'counting', we add the number 'i' into the result array
            // if the frequency is more than zero.
            while (counting[number] > 0) {
                // Shifting index 'i' each time a number is added to the result.
                arr1[i++] = number;
                counting[number]--;
            }
        }
        // We use 'arr1' as the result array.
        return arr1;
    }
}
