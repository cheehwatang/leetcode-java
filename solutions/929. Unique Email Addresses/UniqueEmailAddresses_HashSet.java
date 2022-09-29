package com.cheehwatang.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Problem:
 * Given an array of String 'emails', return the number of different email addresses that can receive emails.
 * A valid email address consists of the following:
 * 1. A localName (containing only lowercase letters, and may contain '.' or '+').
 * 2. A domainName starting with the '@' symbol.
 *
 * For the localName, the following rules apply:
 * a. Ignore the '.' symbol.
 * b. Ignore any letters inclusive and after '+'.
 *
 * For the domainName, retain every letters. Note that it is guaranteed to have the '.com' suffix.
 *
 *
 * Example 1:
 * Input    : emails = ["alice@example.com", "alice+bob@example.com", "a.lice+b.ob@example.com"]
 * Output   : 1
 * Explanation:
 * 1. "alice@example.com" = "alice@example.com", no modification made.
 * 2. "alice+bob@example.com" = "alice@example.com", the "+bob" is ignored.
 * 3. "a.lice+b.ob@example.com" = "alice@example.com", "." in "a.lice" is ignored, as well as "+b.ob" is ignored.
 *
 *
 * Example 2:
 * Input    : emails = ["a.b@abc.com", "a+b@a.bc.com", "a.b@a.bc.com"]
 * Output   : 3
 * Explanation:
 * 1. "a.b@abc.com" = "ab@abc.com", ignored the "." in the localName.
 * 2. "a+b@a.bc.com" = "a@a.bc.com", ignored the "+b" in the localName.
 * 3. "a.b@a.bc.com" = "ab@a.bc.com", ignored the "." in the localName only.
 *
 *
 * @author Chee Hwa Tang
 */

public class UniqueEmailAddresses_HashSet {

    // Approach:
    // Split the email by the "@" and "+" symbol,
    // then re-assemble the parts before the "+" symbol (while eliminating the "."),
    // and the parts inclusive and after the "@" symbol.

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
