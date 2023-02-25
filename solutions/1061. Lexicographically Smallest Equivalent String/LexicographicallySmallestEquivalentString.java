package com.cheehwatang.leetcode;

// Time Complexity  : O(m logn),
// where 'm' is the total number of find() and union() functions called, and 'n' is the number of lowercase letters, 26.
// The naive approach of the union-find, with both the find() and union() having the time complexity of O(logn).
// With Union by Rank and Path Compression, the time complexity is amortized to almost linear complexity.
//
// Space Complexity : O(k + 26),
// where 'k' is the length of 'baseStr'.
// We used an array to keep track of the set representative (parent) for each lowercase letter, which is 26.
// Additionally, we used a new result string with the same length as 'baseStr'.

public class LexicographicallySmallestEquivalentString {

    // Approach:
    // Using the Disjoint Set Data Structure (Union-Find Data Structure) to
    // group the characters that are equivalent in 's1' and 's2',
    // which the character of the smaller value lexicographically being the set representative (parent).
    // At the same time, this follows the rules of equivalence relation,
    // which is Reflexivity, Symmetry and Transitivity.
    // Once the relationships between 's1' and 's2' are mapped,
    // make a new string from 'baseStr' using the new relationships.

    // Main function to get the smallest equivalent string.
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        // The 'parent' array keeps track of the set representative (parent) of each characters.
        int[] parent = new int[26];

        // Initialize the parent[], by setting all the set representatives (parents) to itself.
        for (int i = 0; i < parent.length; i++)
            parent[i] = i;

        // Merge (union) all the equivalent characters in 's1' and 's2',
        for (int i = 0; i < s1.length(); i++) {
            union(parent, s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        // Make a new string from the 'baseStr' using the new relationship,
        // with the new character being the parent of the character in 'baseStr'.
        StringBuilder result = new StringBuilder();
        for (char character : baseStr.toCharArray()) {
            // As the returned result of the find() function is an integer indicating the index from char 'a',
            // we add the integer to 'a', and cast to char.
            result.append((char) ('a' + find(parent, character - 'a')));
        }

        // Return the converted string.
        return result.toString();
    }

    // Function to find the set representative.
    private int find(int[] parent, int character) {
        // We have found the set representative when the character points back to itself.
        if (parent[character] == character) return character;

        // As part of the Path Compression, we set all the related characters to the set representative.
        return parent[character] = find(parent, parent[character]);
    }

    // Function to merge the two disjoint set.
    private void union(int[] parent, int char1, int char2) {
        // Get the set representative of the two characters.
        int find1 = find(parent, char1);
        int find2 = find(parent, char2);

        // If the parent of 'char1' is smaller lexicographically, then the parent of 'char1' becomes the parent.
        // If the parent of 'char2' is smaller lexicographically, then the parent of 'char2' becomes the parent.
        if (find1 < find2) parent[find2] = find1;
        else if (find1 > find2) parent[find1] = find2;
    }
}
