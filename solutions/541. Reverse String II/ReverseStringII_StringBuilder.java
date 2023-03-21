package com.cheehwatang.leetcode;

// Time Complexity  : O(n^2),
// where 'n' is the length of string 's'.
// As we traverse string 's' to append or insert the characters into the StringBuilder, would be O(n).
// However, insertion into StringBuilder has a time complexity of O(n),
// since we have to shift the characters to the right.
// As such, the worst case is when we insert all the letters at the index 0,
// resulting in O(n) for each character inserted O(n), which is O(n^2).
//
// Space Complexity : O(n),
// where 'n' is the length of string 's'.
// The StringBuilder and the final result string scales linearly with the length of string 's'.

public class ReverseStringII_StringBuilder {

    // Approach:
    // Using a StringBuilder,
    // 1. Append the characters if not reversed, or
    // 2. Insert the characters at the start of index if we want reversed, where index % k == 0, and (index / k) % 2 == 0.

    public String reverseStr(String s, int k) {
        StringBuilder reversedString = new StringBuilder();

        for (int index = 0; index < s.length(); index++) {
            // 'kMultiples' is to check if index is at first k (need to reverse) or second k (no need to reverse).
            int kMultiples = index / k;

            // To reverse, insert the characters at kMultiples * k.
            if (kMultiples % 2 == 0) reversedString.insert(kMultiples * k, s.charAt(index));
            // If no need to reverse, then just append.
            else reversedString.append(s.charAt(index));
        }
        return reversedString.toString();
    }
}
