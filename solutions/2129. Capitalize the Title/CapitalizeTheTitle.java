package com.cheehwatang.leetcode;

// Time Complexity  : O(n),
// where 'n' is the length of 'title'.
// When we split the 'title' into the words array, as well as the joining of words with delimiter,
// and modifying the letters with toUpperCase() and toLowerCase() methods,
// we are iterating each and every char in the string.
//
// Space Complexity : O(n),
// where 'n' is the length of 'title'.
// We create new strings when we split the 'title' into the words array,
// as well as joining the modified words into a new capitalized string.

public class CapitalizeTheTitle {

    // Approach:
    // Split the 'title' into words array and modify each word based on the criteria stated in the problem.
    // Then, we use the String.join() method with the space " " delimiter to from the capitalized title.
    // Since the problem clearly stated that there words are separated by a space, we can use space " " as delimiter.

    public String capitalizeTitle(String title) {
        // Split the 'title' using a space " " as delimiter.
        String[] words = title.split(" ");

        // For each word, if the length is two or less, change to lowercase.
        // Else, uppercase the first letter and lowercase the remaining characters.
        for (int i = 0; i < words.length; i++) {
            words[i] = words[i].length() <= 2 ?
                    words[i].toLowerCase() :
                    words[i].substring(0, 1).toUpperCase() + words[i].substring(1).toLowerCase();
        }
        // Join the capitalized words using space " " delimiter.
        return String.join(" ", words);
    }
}
