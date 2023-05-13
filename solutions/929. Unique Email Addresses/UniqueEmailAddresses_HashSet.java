package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

// Time Complexity  : O(n * m),
// where 'n' is the length of 'emails', and 'm' is the average number of characters per email.
// For each email, we perform split() and replace() functions which have linear time complexity of O(m).
// Thus, the time complexity is O(n * m), or linear with the number of characters in 'emails'.
//
// Space Complexity : O(n * m),
// where 'n' is the length of 'emails', and 'm' is the average number of characters per email.
// The split() method and the string concatenation results in the linear time complexity with the length of each email.
// Additionally, the HashSet has a linear time complexity, with worst-case being all emails are unique.

public class UniqueEmailAddresses_HashSet {

    // Approach:
    // Split the email by the "@" and "+" symbol,
    // then re-assemble the parts before the "+" symbol (while eliminating the "."),
    // and the parts inclusive and after the "@" symbol.
    // Use HashSet to store altered email addresses, and get the number of unique email addresses.

    public int numUniqueEmails(String[] emails) {

        // Use set to store adjusted email addresses, as HashSet eliminates duplicates.
        Set<String> emailSet = new HashSet<>();

        // For each email.
        for (String email : emails) {

            // Split the email by localName and domainName with .split("@").
            String[] localDomain = email.split("@");

            // Split the localName by the "+" symbol, so we only take the part before the "+" symbol.
            String[] localName = localDomain[0].split("\\+");

            // For the localName[0], remove the ".".
            // Then re-assemble the email address.
            String adjustedEmail = localName[0].replace(".", "") + "@" + localDomain[1];

            // Add the adjustedEmail to the HashSet. If it is a duplicate, it will not be added.
            emailSet.add(adjustedEmail);
        }
        return emailSet.size();
    }
}
