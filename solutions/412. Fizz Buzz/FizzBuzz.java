package com.cheehwatang.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem:
 * Given an integer 'n', return a string array 'answer' (1-indexed) where:
 * 1. answer[i] == "FizzBuzz" if i is divisible by 3 and 5.
 * 2. answer[i] == "Fizz" if i is divisible by 3.
 * 3. answer[i] == "Buzz" if i is divisible by 5.
 * 4. answer[i] == i otherwise.
 *
 * Note:
 * Use counting array or hash tables.
 *
 *
 * Example 1:
 * Input : n = 5
 * Output: ["1","2","Fizz","4","Buzz"]
 *
 * Example 2:
 * Input : n = 15
 * Output: ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz","Buzz","11","Fizz","13","14","FizzBuzz"]
 *
 * @author Chee Hwa Tang
 */

public class FizzBuzz {
    public List<String> fizzBuzz(int n) {

        // Using an arrayList, we can automatically achieve 1-indexed list with list.add(),
        // as it will add to the end of the list.
        List<String> list = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
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
