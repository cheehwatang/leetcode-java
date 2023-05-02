package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of String 's'.
// The split() method for String has a linear time complexity.
// For each word, we convert to a StringBuilder object, perform reverse() method on the StringBuilder,
// and convert the StringBuilder back to String object, each has linear time complexity to the word.
// Assuming that the input String 's' containing mostly of words, the linear time complexity of the words
// translate to a linear time complexity for the whole reverseWords() method.
// To be specific, it would approximate to O(5*n), but we simplify to O(n).
//
// Space Complexity : O(n),
// where 'n' is the length of String 's'.
// The split() method to get the array of words, the conversion of word to StringBuilder and convert back to String,
// together with joining the words back to a String, all contributes to a linear space complexity.
// To be specific, it would approximate to O(4*n), but we simplify to O(n).

public class ReverseWordsInAStringIII_StringBuilder {

    // Approach:
    // Split the string into String array 'words'.
    // Then use a StringBuilder to reverse each words within the 'words' array.
    // Note: This approach uses more time and memory than the two pointers, due to the use of StringBuilder.

    public String reverseWords(String s) {
        // Split the String 's' using regex " ".
        String[] words = s.split(" ");

        // Reverse each word in the 'words' array.
        for (int i = 0; i < words.length; i++) {
            words[i] = new StringBuilder(words[i]).reverse().toString();
        }

        // Build a new String using the " " delimiter and return result.
        return String.join(" ", words);
    }
}
