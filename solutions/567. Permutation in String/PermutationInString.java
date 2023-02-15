package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of the string 's2'.
// We traverse the string 's2' once with the sliding window technique
// to compare the substrings of length of 's1' to find permutation matching the string 's1'.
// If the string 's1' is longer than string 's2', we would return false, thus not checking.
// As such, the time complexity grows linearly with the length of string 's2'.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the size of the input string 's1' and string 's2'.

public class PermutationInString {

    // Approach:
    // We can use an integer array of size 26 to record the count of the letters in any substrings.
    // By increasing the count for one substring, and decreasing the count for the other substring,
    // we can check whether both substrings are permutation of each other, if the count are all zeroes.
    // For example:
    // s1 = 'abc', s2 = 'bca', count = [0, 0, 0] for letter, 'a', 'b' and 'c' respectively.
    // At index = 0, s1 = 'a', s2 = 'b', count = [1, -1, 0], as we increase for letter 'a', and decrease for letter 'b'.
    // At index = 1, s1 = 'b', s2 = 'c', count = [1, 0, -1], as we increase for letter 'b', and decrease for letter 'c'.
    // At index = 2, s1 = 'c', s2 = 'a', count = [0, 0, 0], as we increase for letter 'c', and decrease for letter 'a'.
    //
    // Using sliding window, we can use the above method to check if the count array is all zeroes,
    // as we move the sliding window forward.
    // Whenever we found the count array to be all zeroes, return true.
    // If we reach the end and still unable to get count array to be all zeroes, return false.

    public boolean checkInclusion(String s1, String s2) {
        int s1Length = s1.length(), s2Length = s2.length();

        // If the length of 's1' is longer than the length of 's2',
        // it is impossible for 's1' to be the permutation for the substrings of 's2'.
        if (s1Length > s2Length) return false;

        int[] alphabetCount = new int[26];
        // First, we check all the letters in 's1', increasing the count,
        // as well as the corresponding letters in 's2', decreasing the count of the alphabet.
        for (int i = 0; i < s1Length; i++) {
            alphabetCount[s1.charAt(i) - 'a']++;
            alphabetCount[s2.charAt(i) - 'a']--;
        }
        // If all the alphabet counts are zeroes, then we have found that 's1' is the permutation of 's2' substring.
        if (isAllZeroesInArray(alphabetCount)) return true;

        // With the sliding window technique, we move the window of length of 's1' forward,
        // each time increasing the count for the back, and decreasing the count for the front of the window.
        for (int i = s1Length; i < s2Length; i++) {
            alphabetCount[s2.charAt(i - s1Length) - 'a']++;
            alphabetCount[s2.charAt(i) - 'a']--;
            // If all the alphabet counts are zeroes, then we have found that 's1' is the permutation of 's2' substring.
            if (isAllZeroesInArray(alphabetCount)) return true;
        }
        // If we reach the end and still unable to get count array to be all zeroes, return false.
        return false;
    }

    // Helper method to check if the array contains only zeroes.
    private boolean isAllZeroesInArray(int[] array) {
        // For every integer,
        for (int integer : array)
            // return false if the integer is not zero.
            if (integer != 0) return false;

        // If all the integers in the array are zeroes, return true.
        return true;
    }
}
