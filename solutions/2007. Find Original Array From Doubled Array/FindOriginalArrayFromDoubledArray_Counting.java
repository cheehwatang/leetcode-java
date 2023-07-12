package src.com.cheehwatang.leetcode;

// Time Complexity  : O(n + m),
// where 'n' is the length of 'changed', and 'm' is the maximum number in 'changed'.
// We traverse the 'changed' array twice,
// first is to find the maximum number, and second is to count the numbers in 'changed'.
// Additionally, we traverse the counting array once with size of 'm'.
// Thus, the total time complexity is O(n + m).
//
// Space Complexity : O(n + m),
// where 'n' is the length of 'changed', and 'm' is the maximum number in 'changed'.
// We use a counting array of size 'm' to count the frequency of the numbers in 'changed'.
// Additionally, the result array has size half of 'changed', thus has space complexity of O(n).
// Thus, the total space complexity is O(n + m).

public class FindOriginalArrayFromDoubledArray_Counting {

    // Approach:
    // We use a counting array to count the frequency of the numbers in 'changed' array.
    // Instead of using the constraint size of 10^5, we can first determine the maximum number in 'changed',
    // then create a counting array of size "max + 1".
    //
    // As we traverse the counting array, we skip the numbers that has 0 frequency.
    // For each number with frequency greater than 0, we check if the double exists.
    // Return an empty array if empty.
    // Else, record the number in the result array, and reduce the frequency of both number by 1.

    public int[] findOriginalArray(int[] changed) {
        int n = changed.length;

        // For all test cases, if "changed.length" is 0, or odd number, then it must not be a doubled array.
        // Since all values in the doubled array must be in pairs. (e.g. 1 -> 2, 5 -> 10, etc.)
        if (n == 0 || n % 2 == 1) return new int[0];

        // This method involves using an array of size 'maxNumber' in the 'changed' array,
        // by counting the frequency of each number.
        // Thus, first get the 'maxNumber' by checking all the numbers in 'changed'.
        int maxNumber = Integer.MIN_VALUE;
        for (int number : changed) maxNumber = Math.max(number, maxNumber);

        // Once found 'maxNumber', create a 'countArray' to record the frequency of each number.
        // Note: Counting the frequency of each number inadvertently sorted the 'changed' array.
        int[] countArray = new int[maxNumber + 1];
        for (int number : changed) countArray[number]++;

        // Set up the array of the original array, and index to track the position in the array.
        int[] original = new int[n/2];
        int index = 0;

        // Traverse the countArray to perform number matching with number * 2.
        for (int j = 0; j <= maxNumber; j++) {
            // If the frequency of the number is already "used up" when matching with smaller number, we will skip.
            if (countArray[j] <= 0) continue;

            // If "j * 2" is greater than the 'maxNumber', then there is no match.
            // If the frequency of number j * 2 is 0, we know that number j is not matched.
            // Note that we would need to check if "j * 2" is greater than 'maxNumber' first to prevent IndexOutOfBoundsException.
            if (j * 2 > maxNumber || countArray[j*2] == 0) return new int[0];

            // Input the number to the original array.
            original[index++] = j;
            // Reduce the count for both, number and number * 2
            countArray[j*2]--;
            countArray[j]--;
            // The j-- is used to account for number 'j' frequency of > 1,
            // thus repeating the for-loop for the same number, until 'countArray[j]' reaches 0.
            j--;
        }
        return original;
    }
}
