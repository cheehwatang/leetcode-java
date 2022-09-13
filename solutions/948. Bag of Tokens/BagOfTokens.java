package com.cheehwatang.leetcode;

import java.util.Arrays;

/**
 * Problem:
 * Given an array of tokens and an initial power value, return the highest possible score with the rules stated below.
 *
 * Note:
 * You have the following starting parameters:
 * - Power          : power
 * - Score          : 0
 * - Bag of Tokens  : tokens[i], where i is the value of ith token
 *
 * Rules:
 * 1.   If your current power is at least the value of a token, you may play the token face up,
 *      losing power of equivalent value and gaining 1 score.
 * 2.   If your current score is at least 1, you may play the token face down,
 *      gaining power of equivalent value and losing 1 score.
 * 3.   Each token can only be played once, while not necessary to play all tokens.
 *
 * Return the highest score achievable.
 *
 * Example 1:
 * Input    : tokens = [20], power = 15
 * Output   : 0
 * Explanation: Power of 15 is lower than 20, not able to gain a score due to too little score or too little power.
 *
 * Example 2:
 * Input    : tokens = [50,150], power = 100
 * Output   : 1
 * Explanation: Play the 0th token (50) face up, your power becomes 50 and score becomes 1.
 *              Unable to gain another score due to insufficient power.
 *
 * Example 3:
 * Input    : tokens = [20,40,60,80,100], power = 40
 * Output   : 2
 * Explanation:
 * 1. Play the 0th token (20) face up, your power becomes 20 and score becomes 1.
 * 2. Play the 4th token (100) face down, your power becomes 120 and score becomes 0.
 * 3. Play the 1st token (40) face up, your power becomes 80 and score becomes 1.
 * 4. Play the 2nd token (60) face up, your power becomes 20 and score becomes 2.
 * 5. Unable to gain another score due to insufficient power to play the 3rd token (80).
 *
 *
 * @author Chee Hwa Tang
 */

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
            } else {
                break;
            }
            // End while loop when all remaining tokens is same value, or when head > tail.
        }
        return score;
    }

}
