package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of the string 's'.
// We traverse the string 's' once to check every letter for duplicates.
// Additionally, the conversion of the string 's' to Char Array, and the conversion of StringBuilder to String,
// both have maximum time complexity of O(n).
//
// Space Complexity : O(n),
// where 'n' is the length of the string 's'.
// The maximum length of the StringBuilder is the length of the string 's', when no duplicates present.
// Additionally, the string result also has a maximum length of 'n'.

public class RemoveAllAdjacentDuplicatesInString_StringBuilder {

    // Approach:
    // Using stack to check for the duplicates is suitable here,
    // because some duplicates can be found after other duplicates are removed, for example "abccba" -> "".
    // As we can append and remove the last character from a StringBuilder,
    // the StringBuilder here acts as a Stack.

    public String removeDuplicates(String s) {
        // Rather than using Stack<> and StringBuilder together, we can just use a StringBuilder for the function of stack,
        // by checking the last / rightmost character in the StringBuilder.
        // Since the StringBuilder is backed by an array with default initial capacity of 16,
        // we can set the initial capacity to the maximum length possible to prevent inefficiency in resizing when
        // s.length() > 16.
        StringBuilder sb = new StringBuilder(s.length());

        // For every letter in 's',
        for (char letter : s.toCharArray()) {
            // check if the 'stringBuilder' is empty, as it results in IndexOutOfBound error if not checked.
            // If found the duplicate, remove the rightmost character in the 'stringBuilder', like a stack.
            if (sb.length() > 0 && sb.charAt(sb.length() - 1) == letter)
                sb.deleteCharAt(sb.length() - 1);
            // If not, add the letter to the 'stringBuilder'.
            else
                sb.append(letter);
        }
        // Convert the StringBuilder to string before returning it.
        return sb.toString();
    }
}
