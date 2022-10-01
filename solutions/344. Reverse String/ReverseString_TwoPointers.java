package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given a character array 's', reverse the elements arrangement by modifying the input array in-place.
 *
 * Note:
 * Use two pointers.
 *
 *
 * Example 1:
 * Input : s = ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 *
 * Example 2:
 * Input : s = ["L","e","e","t","C","o","d","e"]
 * Output: ["e","d","o","C","t","e","e","L"]
 *
 *
 * @author Chee Hwa Tang
 */

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
