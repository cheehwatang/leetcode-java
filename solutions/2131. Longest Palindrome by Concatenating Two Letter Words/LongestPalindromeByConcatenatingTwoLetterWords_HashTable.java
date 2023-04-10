package com.cheehwatang.leetcode;

import java.util.HashMap;
import java.util.Map;

// Time Complexity  : O(n),
// where 'n' is the length of String array 'words'.
// We traverse the String array once to count and check for the length of palindrome that can form.
//
// Space Complexity : O(n),
// where 'n' is the length of String array 'words'.
// The worst-case is when no pair is found that can form a palindrome,
// resulting in the HashMap to grow linearly with the input when all the strings are unique.

public class LongestPalindromeByConcatenatingTwoLetterWords_HashTable {

    // Approach:
    // Use a HashMap to keep track of the frequency of each element in 'words'.
    //
    // There are two fundamental cases to form a palindrome using the elements in 'words':
    // 1. Word with 2 different characters (eg. "ab", "cd")
    // 2. Word with the same characters (eg. "aa", "bb")
    //
    // Case 1:
    // We need to find the pair that matches each other in a palindrome. For example using words "ab" and "ba".
    // They can form a palindrome by either "abba" or "baab".
    // Even if we have other palindromes in between, it does not affect, such as "abXXXXba" or "baXXXXab".
    // With that, we need to store the occurrence of either "ab" or "ba", whichever came first.
    // Then the next word can be flipped and checked.
    // As the pair is "used" as soon as matched, this is a greedy approach.
    //
    // Case 2:
    // This can further split into 2 behaviors.
    // First is the same as Case 1, "aa" and "aa" forming "aaaa" palindrome.
    //
    // Second is for it to be in the center of the palindrome.
    // For example, words are "ab", "ba" and "zz", it can form "abzzba".
    // As such, we need to first check the case 1 behavior, forming examples like "aaaa", before checking the center.
    // As there will only be one center element (if exist), we check if any exist.

    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        for (String word : words) {
            // Get the flipped word.
            String flipped = "" + word.charAt(1) + word.charAt(0);
            // If the flipped word is found, reduce the count of the flipped word.
            // Removing the key from the map when it is 0 is important later on when we need to check for the center word
            // that can form the palindrome.
            if (map.containsKey(flipped)) {
                max += 4;
                map.put(flipped, map.get(flipped) - 1);
                // As we are using map.containsKey(), we need to clean up the HashMap when the count is 0.
                if (map.get(flipped) == 0) map.remove(flipped);
            } else {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }
        // For the odd word in the center of the palindrome (e.g. "aa", "bb", "cc", etc.),
        // check for all 26 possible pairs, if any is found, increase the max by 2.
        // For Example: words = ["ab","ba","zz","yy"]
        //              With "ab" and "ba" form a pair, with max = 4,
        //              either "zz" or "yy" can fit in the center to expand the palindrome, forming "abzzba" or "abyyba".
        // Exit the for-loop once found, as we only can use one at the center.
        for (int i = 0; i < 26; i++) {
            char current = (char) ('a' + i);
            if (map.getOrDefault("" + current + current, 0) > 0) {
                max += 2;
                break;
            }
        }
        return max;
    }
}
