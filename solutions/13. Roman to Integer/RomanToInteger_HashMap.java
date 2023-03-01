package com.cheehwatang.leetcode;

import java.util.Map;

// Time Complexity  : O(n),
// where 'n' is the length of the input string 's'.
// We iterate through the string 's' once to check each roman numeral and adjust the sum accordingly.
//
// Space Complexity : O(1),
// as the dictionary take up constant space
// and the auxiliary space used is independent on the size of the input string 's'.

public class RomanToInteger_HashMap {

    // Approach:
    // Generally, the Roman characters increases in value from right to left. However...
    // Notice the pattern in the Roman numeral, where IV = 5 - 1, IX = 10 - 1, XL = 50 - 10 etc.
    // Whenever the left (eg I) is less than the right (eg X), we will deduct left (in this case 1).
    // Thus, we need to keep track of the previous value to compare.
    //
    // Here, we use HashMap to check for the roman numeral and integer pair.
    // As compared to using switch cases, this approach is faster as getting value from HashMap is O(1),
    // but HashMap occupies additional memory.

    public int romanToInt(String s) {
        // Create the Map for the roman numeral and integer pair.
        Map<Character,Integer> romanToIntMap = Map.of(
                'I', 1,
                'V', 5,
                'X', 10,
                'L', 50,
                'C', 100,
                'D', 500,
                'M', 1000);

        int sum = 0;
        int previous = 0;
        // Starting from the smallest roman numeral (from the right).
        for (int i = s.length()-1; i >= 0; i--) {
            int current = romanToIntMap.get(s.charAt(i));
            // Add to the sum if the current numeral is equal or greater than the previous one,
            // or subtract from the sum if the current numeral is smaller, as explained in the Approach.
            sum = (current >= previous ? sum + current : sum - current);
            previous = current;
        }
        return sum;
    }
}