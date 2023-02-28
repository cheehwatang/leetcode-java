package com.cheehwatang.leetcode;

// Time Complexity  : O(1),
// as the time to iterate through the dictionary and the while loop inside results is a constant average time,
// no matter the input 'num'.
//
// Space Complexity : O(1),
// as the dictionary take up constant space,
// while the string result has an average space not dependent on the size of the input 'num'.

public class IntegerToRoman_HashTable {

    // Approach:
    // This method uses two arrays with the corresponding integer-roman acting as dictionary,
    // arranged in descending order.
    // As we subtract the largest possible number, we append the corresponding roman numeral to the StringBuilder.
    // StringBuilder is preferable to string concatenation
    // as StringBuilder is faster and more efficient in memory usage.

    public String intToRoman(int num) {
        // Below are the list of the unique roman numerals to check.
        int[] value = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder romanNumeral = new StringBuilder();
        // Traverse both 'value' and 'roman' array to slowly subtract 'num' until 'num' reaches 0.
        for (int i = 0; i < value.length && num > 0; i++) {
            // Continue to subtract the 'value[i]' from 'num' and append the 'roman[i]' to 'romanNumeral'.
            while (num >= value[i]) {
                romanNumeral.append(roman[i]);
                num -= value[i];
            }
        }
        // Convert the StringBuilder to string before returning it.
        return romanNumeral.toString();
    }
}
