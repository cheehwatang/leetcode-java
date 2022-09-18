package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given an array 'changed', return the original array if 'changed' is a doubled array,
 * or return an empty array if 'changed' is not a doubled array.
 *
 * Note:
 * A doubled array is when an original array is appended double the value of each of its containing element.
 * The resulted array is then shuffled.
 * Example: Original = [1,2,3]
 *          Doubled  = [1,2,3,2,4,6]
 *          Shuffled = [1,4,3,2,2,6]
 *
 *
 * Example 1:
 * Input    : changed = [1,4,3,2,2,6]
 * Output   : [1,2,3] or in other ordering such as [1,3,2], [3,2,1], etc.
 * Explanation: Twice the value of 1: 1 * 2 = 2.
 *              Twice the value of 2: 2 * 2 = 4.
 *              Twice the value of 3: 3 * 2 = 6.
 *              'changed' can split into [1,2,3] and [2,4,6], thus it is a doubled array.
 *
 * Example 2:
 * Input    : changed = [2,4,3,1,6,0]
 * Output   : []
 * Explanation: Twice the value of 0: 0 * 2 = 0.
 *              Twice the value of 1: 1 * 2 = 2.
 *              Twice the value of 2: 2 * 2 = 4.
 *              Twice the value of 3: 3 * 2 = 6.
 *              'changed' is NOT a doubled array, as there is no match for 0 and 4.
 *
 * Example 3:
 * Input    : changed = [0]
 * Output   : []
 * Explanation: Not a doubled array.
 *
 *
 * @author Chee Hwa Tang
 */

public class FindOriginalArrayFromDoubledArray_Counting {

    public int[] findOriginalArray(int[] changed) {

        // For all test cases, if changed.length is 0, or odd number, then it must not be a doubled array.
        // Since all values in the doubled array must be in pairs. (e.g. 1 -> 2, 5 -> 10, etc.)
        if (changed.length == 0 || changed.length % 2 == 1) {
            return new int[0];
        }

        // This method involves using an array of size maxNumber in the 'changed' array,
        // by counting the frequency of each number.
        // Thus, first get the maxNumber by checking all of the numbers in 'changed'.
        int maxNumber = Integer.MIN_VALUE;
        for (int number : changed) {
            maxNumber = Math.max(number, maxNumber);
        }

        // Once found maxNumber, create a countArray to record the frequency of each number.
        // Note: Counting the frequency of each number inadvertently sorted the 'changed' array.
        int[] countArray = new int[maxNumber + 1];
        for (int number : changed) {
            countArray[number]++;
        }

        // Set up the array of the original array, and index to track the position in the array.
        int[] original = new int[changed.length/2];
        int index = 0;

        // Traverse the countArray to perform number matching with number * 2.
        for (int j = 0; j < countArray.length; j++) {
            // If the frequency of the number is already "used up" when matching with smaller number, we will skip.
            if (countArray[j] == 0) {
                continue;
            }

            // If ever the frequency of number j * 2 is 0, we know that number j is not matched.
            // Similarly, when j * 2 is larger than the maxNumber, meaning no match.
            if (j * 2 > maxNumber || countArray[j*2] == 0) {
                return new int[0];
            } else {
                // Input the number to the original array.
                original[index++] = j;
                // Reduce the count for both, number and number * 2
                countArray[j*2]--;
                countArray[j]--;
                // the j-- is used to account for number j frequency of > 1,
                // thus repeating the for-loop for the same number, until countArray[j] reaches 0.
                j--;
            }
        }
        return original;
    }
}
