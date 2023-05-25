package com.cheehwatang.leetcode;

import java.util.Arrays;

// Time Complexity  : O(n logn),
// where 'n' is the length of 'tokens'.
// We use Arrays.sort() to sort 'tokens', which implements the Dual-Pivot Quicksort with O(n logn) time complexity.
// Additionally, we traverse the 'tokens' array once to perform the greedy approach to get the maximum score.
//
// Space Complexity : O(1),
// as the auxiliary space used is independent on the size of the input.

public class BagOfTokens {

    public int bagOfTokensScore(int[] tokens, int power) {

        // With the rules, this problem is suitable with greedy approach, by:
        // 1. losing the least power to gain the most score (play face up), and
        // 2. losing the least score to gain the most power (play face down).
        // Since the tokens are in random order, we need to sort the tokens in ascending order
        // to perform the greedy algorithm.

        // First sort the bag of tokens in ascending order.
        Arrays.sort(tokens);

        // Set the head and tail pointers.
        int head = 0;
        int tail = tokens.length - 1;

        int score = 0;
        while (head <= tail) {
            // Will keep adding score by losing tokens[head] powers, until power is less than
            // the smallest available token. (Greedy, to maximize the score)
            if (power >= tokens[head]) {
                power -= tokens[head++];
                score++;
            }
            // Gain power of tokens[tail] while score > 0. (Greedy, to maximize power gained when lose 1 score)
            else if (score > 0 && tokens[head] < tokens[tail]) {
                power += tokens[tail--];
                score--;
            }
            // End while loop when all remaining tokens is same value,
            else {
                break;
            }
            // or when head > tail.
        }
        return score;
    }
}
