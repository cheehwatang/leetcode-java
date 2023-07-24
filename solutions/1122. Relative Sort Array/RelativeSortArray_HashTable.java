package com.cheehwatang.leetcode;

import java.util.TreeMap;

// Time Complexity  : O(n),
// where 'n' is the length of 'arr1', as 'arr2' is a subset of 'arr1'.
// TreeMap.get() function has a time complexity of O(log n).
// With the worst-case being all the numbers in 'arr1' is unique,
// the counting of numbers in 'arr1' and the relative sorting of 'arr1'
// results in the total time complexity of O(n logn), as we perform TreeMap.get() function for each element.
//
// Space Complexity : O(n),
// where 'n' is the length of 'arr1'.
// With the worst-case being all the numbers in 'arr1' is unique,
// the size of the TreeMap grows linearly with the size of the input 'arr1'.

public class RelativeSortArray_HashTable {

    // Approach:
    // TreeMap is a hash table while retaining the ordering of the key element in ascending order by default.
    // Thus, we can count the frequency of the numbers in 'arr1' and retrieve with the TreeMap.get() method.
    // Crucially, we can get the numbers as keys of the TreeMap is ascending order.
    //
    // First, we record the frequency of each element in 'arr1' into the TreeMap.
    // Then, we traverse 'arr2' to check the relative position,
    // and input the elements into the result array in ascending index order.
    // Remove the number from the TreeMap once the frequency is 0.
    // Lastly, we traverse the TreeMap to input the remaining numbers
    // into the result array in ascending number order.

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        // The key is the number, and value is the frequency.
        TreeMap<Integer, Integer> map = new TreeMap<>();

        // Count the frequency of the numbers in 'arr1'.
        for (int number : arr1) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        // Index 'i' is to keep track of the position in the result array.
        // Here, we use 'arr1' as the result array to reduce space complexity when using a new 'result' array.
        // Optional to use a new 'result' array for better readability and clarity.
        int i = 0;
        for (int number : arr2) {
            // For each number in 'arr2', we get the frequency,
            int frequency = map.getOrDefault(number, 0);
            // and record the number into the result array.
            while (frequency > 0) {
                arr1[i++] = number;
                frequency--;
            }
            // Remove the number from the TreeMap once checked.
            map.remove(number);
        }

        // Traverse the TreeMap keys to get the remaining numbers that are not in 'arr2'.
        // Note: TreeMap.keySet() returns the keys in ascending order.
        for (int number : map.keySet()) {
            // For each number in 'arr2', we get the frequency,
            int frequency = map.get(number);
            // and record the number into the result array.
            while (frequency > 0) {
                arr1[i++] = number;
                frequency--;
            }
        }
        // We use 'arr1' as the result array.
        return arr1;
    }
}
