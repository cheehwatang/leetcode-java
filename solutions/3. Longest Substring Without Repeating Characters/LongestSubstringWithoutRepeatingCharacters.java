package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 's'.
// We use two pointers as sliding window to traverse the string 's' once.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent of the input.

public class LongestSubstringWithoutRepeatingCharacters {

    // Approach:
    // Using sliding window technique with two pointers 'front' and 'back',
    // and an array to store the latest index of the character found.

    public int lengthOfLongestSubstring(String s) {

        // The standard ASCII characters range from 0 to 127.
        int[] characterIndex = new int[128];
        int max = 0;
        for (int front = 0, back = 0; front < s.length(); front++) {
            char character = s.charAt(front);
            // Get the latest 'back' index
            // if there is a character index (non-zero) that was recorded in the 'characterIndex' array.
            back = Math.max(back, characterIndex[character]);

            // Update 'max' for the longer substring without repeating characters.
            max = Math.max(max, front - back + 1);

            // The index is recorded as "front + 1" is because it will be the start of the substring,
            // when the 'back' index above is updated.
            characterIndex[character] = front + 1;
        }
        return max;
    }
}
