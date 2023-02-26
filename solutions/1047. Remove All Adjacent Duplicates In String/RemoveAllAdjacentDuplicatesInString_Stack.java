package com.cheehwatang.leetcode;

import java.util.Stack;

// Time Complexity  : O(n),
// where 'n' is the length of the string 's'.
// We traverse the string 's' once to check every letter for duplicates.
// Additionally, the conversion of the string 's' to Char Array, the appending of the letter from the stack to StringBuilder,
// the reversal of the StringBuilder, and the conversion of StringBuilder to String,
// all have maximum time complexity of O(n).
// Compare to using StringBuilder to function as stack, this approach is much slower.
//
// Space Complexity : O(n),
// where 'n' is the length of the string 's'.
// In the worst-case scenario when no duplicates present,
// the maximum size of the stack and maximum length of the StringBuilder is the length of the string 's'
// Additionally, the string result also has a maximum length of 'n'.

public class RemoveAllAdjacentDuplicatesInString_Stack {

    // Approach:
    // Using stack to check for the duplicates is suitable here,
    // because some duplicates can be found after other duplicates are removed, for example "abccba" -> "".

    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();

        // For every letter in 's',
        for (char letter : s.toCharArray()) {
            // check if the 'stack' is empty, as it results in EmptyStackException error if not checked.
            // If found the duplicate, pop the top element from the stack.
            if (!stack.empty() && stack.peek() == letter)
                stack.pop();
            // If not, push the letter to the 'stack'.
            else
                stack.push(letter);
        }
        // Use StringBuilder to convert the letters remained in the stack back to string.
        StringBuilder result = new StringBuilder(stack.size());
        while (!stack.empty()) result.append(stack.pop());

        // As the stack is last in first out (LIFO), we need to reverse the StringBuilder,
        // then we convert the StringBuilder to string before returning it.
        return result.reverse().toString();
    }
}
