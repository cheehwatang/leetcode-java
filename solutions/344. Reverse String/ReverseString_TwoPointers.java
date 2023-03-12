package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of the char array 's'.
// We traverse half of the array once to swap the characters, which scales linearly with the length of the char array 's'.
//
// Space Complexity  : O(1),
// as the auxiliary space used is independent on the length of the char array 's'.

public class ReverseString_TwoPointers {

    // Approach:
    // Use two pointers, one from the left, the other from the right, and swap the characters.

    public void reverseString(char[] s) {
        // We only need to traverse until halfway, since we are swapping the left and right.
        // Traversing the whole length will result in the original array, since we swap twice.
        for (int index = 0; index < s.length / 2; index++) {
            int left = index;
            int right = s.length - index - 1;
            // Optional to check if both characters are the same.
            // Or we can just swap the left and right characters without checking.
            if (s[left] != s[right]) {
                char temp = s[left];
                s[left] = s[right];
                s[right] = temp;
            }
        }
    }
}
