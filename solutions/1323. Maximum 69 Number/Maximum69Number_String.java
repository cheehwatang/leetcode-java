package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the number of digits in 'num'.
// We convert 'num' to a string, convert the string to a char array, convert the char array back to string,
// and parse the string to the result integer, all has linear time complexity to the number of digits in 'num'.
//
// Space Complexity : O(n),
// where 'n' is the number of digits in 'num'.
// The conversion of 'num' to string, string to char array, char array back to string,
// all of which has a same size as the digits in 'num'.

public class Maximum69Number_String {

    // Approach:
    // For any number, changing the first digit 6 to 9 from left to right yields the maximum number.
    // This is also known as to be Greedy as we only need to find the first digit 6.
    // As such, we can convert the integer 'num' to a char array,
    // and traverse from left to right to change the first digit 6 that we encounter to digit 9.

    public int maximum69Number (int num) {
        // Convert the integer 'num' to String, then to char[] for easy conversion of char '6' to char '9'.
        char[] chars = String.valueOf(num).toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // Once found and converted the 6 to 9, we can exit the loop and return the result.
            if (chars[i] == '6') {
                chars[i] = '9';
                break;
            }
        }
        // Convert the char[] back to String and back to integer.
        return Integer.parseInt(String.valueOf(chars));
    }
}
