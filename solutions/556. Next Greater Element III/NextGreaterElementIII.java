package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(d^2),
// where 'd' is the number of digits in the integer 'n'.
// We traverse the char[] of integer 'n' twice to find the relevant digits,
// as well as when forming the char[] and the String when parsing to number.
// However, we use Arrays.sort(), which implements Dual-Pivot Quicksort that offers an average performance of O(d logd).
// The worst case for Dual-Pivot Quicksort is O(d^2).
//
// Space Complexity : O(d),
// where 'd' is the number of digits in the integer 'n'.
// This is mainly due to the char[] that we use, as well as the formation of the String before parsing the number.

public class NextGreaterElementIII {

    // Approach:
    // For any combinations of digits in the number,
    // the greatest number is when all the digits are in descending order (e.g. 54321), and
    // the smallest number is when all the digits are in ascending order (e.g. 12345).
    // Using the smallest number example above, the next greater number is when we swap the last two digits, 12354.
    // From there, we can deduce that the next greater number involves
    // finding the first decreasing sequence when traversing from right to left.
    // For example, 'n' = 12543,
    // the last 3 digits, 543 is in descending order, and it the greatest number of the sequence.
    // The first decreasing sequence is between the 2 and 5, in which case the digit 2 is the one to swap out.
    // The candidate to swap comes from the digits to its right, which is 5, 4 and 3.
    // We choose the least greater number of 2, which is 3, becoming 13542.
    // Then we sort the last 3 digits to get the next greater number of 12543, which is 13245.

    public int nextGreaterElement(int n) {
        // Convert 'n' to char[] for easy manipulation of digits.
        char[] digits = String.valueOf(n).toCharArray();
        int length = digits.length;

        // We declare variable 'i' outside the loop as we need it for other operations later.
        int i;
        // Traverse from right to left.
        for (i = length - 1; i > 0; i--) {
            // Stop the loop when we found the first occurrence of the descending sequence.
            if (digits[i] > digits[i - 1]) break;
        }
        // If we have successfully traverse all the digits but not found any descending sequence,
        // then 'n' is the greatest number, and return -1.
        if (i == 0) return -1;

        // Here, we scan digits to the right of 'i', to find the least greater number.
        // Least greater number, meaning the smallest number that is greater than digits[smallest].
        // Note that we are storing the index in the variable, rather than the char itself.
        // It is mainly preference, either index or char will work.
        int smallest = i;
        for (int j = i + 1; j < length; j++) {
            if (digits[j] < digits[smallest] && digits[j] > digits[i - 1])
                smallest = j;
        }

        // Swap the digits.
        char temp = digits[i - 1];
        digits[i - 1] = digits[smallest];
        digits[smallest] = temp;

        // Sort the digits to the right of char[i], inclusive of char[i].
        Arrays.sort(digits, i, length);

        // As it is possible for the next greater number to be larger than Integer.MAX_VALUE, we use long.
        long nextGreater = Long.parseLong(new String(digits));
        // If the number is greater than Integer.MAX_VALUE, return -1, else return the number.
        return nextGreater > Integer.MAX_VALUE ? -1 : (int) nextGreater;
    }
}
