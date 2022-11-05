package com.cheehwatang.leetcode;

/**
 * Problem:
 * Given an array of strings 'words' with each element containing only two lowercase English letters,
 * create the longest possible palindrome by concatenating any elements in 'words' in any order
 * and return the length of the longest possible palindrome (0 if not possible).
 * Do note that each element can be selected at most once.
 *
 *
 * Example 1:
 * Input : words = ["ab", "ba", "zz"]
 * Output: 6
 * Explanation: Possible longest palindromes are "abzzba" and "bazzab", both with length 6.
 *
 *
 * Example 2:
 * Input : words = ["aa", "bb", "cc"]
 * Output: 2
 * Explanation: The longest possible palidromes are "aa", "bb" and "cc".
 *
 *
 * @author Chee Hwa Tang
 */

public class LongestPalindromeByConcatenatingTwoLetterWords_Counting {

    // Approach:
    // With the elements containing only two lowercase English characters, we can use a 2D counting array of size 26 * 26,
    // to store the frequency of the elements in 'words'.
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
        // As there are only 2 lowercase English letters in each word, we can represent the word using a
        // 2D array, with the row representing the first letter, and column representing the second letter.
        int[][] counting = new int[26][26];
        int max = 0;
        for (String word : words) {
            // Convert the char to its relative integer by subtracting with 'a' (e.g. 'a' == 0, 'b' == 1, etc).
            int a = word.charAt(0) - 'a';
            int b = word.charAt(1) - 'a';
            // We can flip the letters by using counting[b][a], while counting[a][b] represents the original lettering.
            // If we found the pair corresponding to the flipped word, then we can increase the max by 4 and update
            // the frequency of the flipped word.
            // For Example: If "ab" is previously stored in counting[0][1], when the word "ba" came up later,
            //              the flipped word of "ba" which is "ab" in counting[0][1] is found.
            // This is also why it is a greedy algorithm, as we count pair in the final result as soon as it is found,
            // since the position of the pair in a palindrome is not important, as long as they are placed opposite of
            // each other.
            if (counting[b][a] > 0) {
                max += 4;
                counting[b][a]--;
            }
            // If no pair is found, store the occurrence of the word.
            else {
                counting[a][b]++;
            }
        }
        // For the odd word in the center of the palindrome (e.g. "aa", "bb", "cc", etc.),
        // Check for all 26 possible pairs, if any is found, increase the max by 2.
        // For Example: words = ["ab","ba","zz","yy"]
        //              With "ab" and "ba" form a pair, with max = 4,
        //              either "zz" or "yy" can fit in the center to expand the palindrome, forming "abzzba" or "abyyba".
        // Do note that the valid pairs formed previously is already counted, since a == b, counting[a][b] == counting[b][a].
        for (int i = 0; i < 26; i++) {
            if (counting[i][i] > 0) {
                max += 2;
                break;
            }
        }
        return max;
    }
}
