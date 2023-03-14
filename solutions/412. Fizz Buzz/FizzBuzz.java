package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;

// Time Complexity  : O(n),
// where 'n' is the input integer 'n'.
// We iterate from 1 to 'n' to check each and every number.
//
// Space Complexity : O(n),
// where 'n' is the input integer 'n'.
// As we put the elements into the List, the size of the List grows linearly with the input integer 'n'.

public class FizzBuzz {

    // Approach:
    // For each number from 1 to 'n', check if the number is equal to
    // 15 (for "FizzBuzz"), 5 (for "Buzz") and 3 (for "Fizz").
    //
    // Do note that the ordering of the if-else statement is important, and check for 15 first,
    // as it is divisible by both 3 and 5.

    public List<String> fizzBuzz(int n) {

        // Using an arrayList, we can automatically achieve 1-indexed list with list.add(),
        // as it will add to the end of the list.
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            // Make sure to check for 15 first before checking for 3 and 5.
            if (i % 15 == 0) {
                list.add("FizzBuzz");
            } else if (i % 3 == 0) {
                list.add("Fizz");
            } else if (i % 5 == 0) {
                list.add("Buzz");
            } else {
                list.add(String.valueOf(i));
            }
        }
        return list;
    }
}
