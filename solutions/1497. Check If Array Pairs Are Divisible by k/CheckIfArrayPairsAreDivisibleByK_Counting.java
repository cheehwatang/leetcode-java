package com.cheehwatang.leetcode;

// Time Complexity  : O(n + k),
// where 'n' is the length of 'arr', as we traverse 'arr' when recording the frequency in the counting array,
// and half of 'k' when traversing the counting array to check for the pairs summing up to a number divisible by 'k'.
//
// Space Complexity : O(k),
// as we use an array of size 'k' to record the frequency.

public class CheckIfArrayPairsAreDivisibleByK_Counting {

    // Approach:
    // Using a counting array to record the frequency of the integer remainders with 'k'.
    // For any two integers, if the remainders sum to an integer that is divisible by 'k',
    // then the two integers sums to a number that is divisible by 'k'.
    // For Example: arr = [5,7,4,8,2,6], k = 4,
    // the remainders for elements in 'arr' are [1,3,0,0,2,2], with 1 + 3 == 4, 0 + 0 == 0 and 2 + 2 == 4,
    // which are divisible by 4.
    // We can see that 5 + 7 == 12, 4 + 8 == 12, and 2 + 6 == 8, with both 12 and 8 being divisible by 4.
    // Note the two cases in this approach:
    // 1. The remainder pair are different, in the case of 5 + 7 above,
    //    the frequency of remainder 'i' and '(k - i)' has to be the same for complete the pairs.
    // 2. The remainder pair are the same, in the case of 4 + 8 and 2 + 6 above,
    //    the frequency of remainder 'i' has to be even to complete the pairs.

    public boolean canArrange(int[] arr, int k) {

        // Record the frequency of the remainder for each integer in 'arr'.
        int[] counting = new int[k];
        for (int integer : arr) {
            // Note that the integers in 'arr' can be negative.
            // Thus, we need to adjust the negative remainder to positive remainder.
            // "(integer % k + k) % k" accounts for both negative and positive remainders.
            // We can also check if the remainder is negative, then add a 'k' to make the remainder positive.
            // For Example, arr = [-2,3,2,-1], k = 5,
            // remainder for the prefix sum of [-2,1,3,2] are -2, 1, 3 and 2 respectively.
            // We know that [3,2] sum to 5, which is divisible by 5.
            // After converting -2 to 3, by adding 5, it has the same remainder with prefix sum 3.
            counting[(integer % k + k) % k]++;
        }
        // For the second case, with remainder of 0.
        int result = counting[0] / 2;
        // For the second case, with remainder of k / 2.
        if (k % 2 == 0)  result += counting[k / 2] / 2;

        // For the first case, with remainder 'i' and '(k - i)' forming the pair.
        for (int i = 1; i <= (k - 1) / 2; i++)
            result += Math.min(counting[i], counting[k - i]);

        // This approach counts the number of pairs that sum to an integer divisible by 'k'.
        // For the boolean result, we simply check if all pairs are formed.
        return result * 2 == arr.length;
    }
}
