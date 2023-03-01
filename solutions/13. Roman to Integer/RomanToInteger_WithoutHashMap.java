package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of the input string 's'.
// We iterate through the string 's' once to check each roman numeral and adjust the sum accordingly.
//
// Space Complexity : O(1),
// as the auxiliary space used for the variables is independent on the size of the input string 's'.

public class RomanToInteger_WithoutHashMap {

    // Approach:
    // Generally, the Roman characters increases in value from right to left. However...
    // Notice the pattern in the Roman numeral, where IV = 5 - 1, IX = 10 - 1, XL = 50 - 10 etc.
    // Whenever the left (eg I) is less than the right (eg X), we will deduct left (in this case 1).
    // Thus, we need to keep track of the previous value to compare.
    //
    // Here, we use switch case to check for the roman numeral and integer pair.
    // As compared to using HashMap, this approach is more time-consuming,
    // as we need to iterate through the switch cases, but saves on the memory from the HashMap.

    public int romanToInt(String s) {
        int sum = 0;
        int previous = 0;
        int current = 0;
        // Starting from the smallest roman numeral (from the right).
        for (int i = s.length()-1; i >= 0; i--) {
            char letter = s.charAt(i);
            switch (letter) {
                case 'I':
                    current = 1;
                    break;
                case 'V':
                    current = 5;
                    break;
                case 'X':
                    current = 10;
                    break;
                case 'L':
                    current = 50;
                    break;
                case 'C':
                    current = 100;
                    break;
                case 'D':
                    current = 500;
                    break;
                case 'M':
                    current = 1000;
                    break;
            }
            // Add to the sum if the current numeral is equal or greater than the previous one,
            // or subtract from the sum if the current numeral is smaller, as explained in the Approach.
            sum = (current >= previous ? sum + current : sum - current);
            previous = current;
        }
        return sum;
    }
}
