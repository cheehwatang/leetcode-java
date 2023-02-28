package com.cheehwatang.leetcode;

// Time Complexity  : O(1),
// as the time to iterate through the while loops is a constant average time,
// no matter the input 'num'.
//
// Space Complexity : O(1),
// as the string result has an average space not dependent on the size of the input 'num'.

public class IntegerToRoman_WithoutHashTable {

    // Approach:
    // This method uses multiple while loops to reduce the 'num' and append the corresponding roman numeral.
    // As we subtract the largest possible number, we append the corresponding roman numeral to the StringBuilder.
    // StringBuilder is preferable to string concatenation
    // as StringBuilder is faster and more efficient in memory usage.

    public static String intToRoman(int num) {
        StringBuilder romanNumeral = new StringBuilder();

        // Note that we are subtracting from the largest roman numeral values to the smallest,
        // each time appending the corresponding roman numeral to the StringBuilder.
        while (num >= 1000) {
            romanNumeral.append("M");
            num -= 1000;
        }
        while (num >= 900) {
            romanNumeral.append("CM");
            num -= 900;
        }
        while (num >= 500) {
            romanNumeral.append("D");
            num -= 500;
        }
        while (num >= 400) {
            romanNumeral.append("CD");
            num -= 400;
        }
        while (num >= 100) {
            romanNumeral.append("C");
            num -= 100;
        }
        while (num >= 90) {
            romanNumeral.append("XC");
            num -= 90;
        }
        while (num >= 50) {
            romanNumeral.append("L");
            num -= 50;
        }
        while (num >= 40) {
            romanNumeral.append("XL");
            num -= 40;
        }
        while (num >= 10) {
            romanNumeral.append("X");
            num -= 10;
        }
        while (num >= 9) {
            romanNumeral.append("IX");
            num -= 9;
        }
        while (num >= 5) {
            romanNumeral.append("V");
            num -= 5;
        }
        while (num >= 4) {
            romanNumeral.append("IV");
            num -= 4;
        }
        while (num >= 1) {
            romanNumeral.append("I");
            num -= 1;
        }
        // Convert the StringBuilder to string before returning it.
        return romanNumeral.toString();
    }
}
