package main.implementation.easy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddress {
	public static void main(String[] args) {
		UniqueEmailAddress uniqueEmailAddress = new UniqueEmailAddress();
		String[] emails = new String[]{"test.email+alex@leetcode.com","test.email.leet+alex@code.com"};
		int result = uniqueEmailAddress.numUniqueEmails(emails);
		System.out.println("result 1: " + result);

		emails = new String[]{"a@leetcode.com", "b@leetcode.com", "c@leetcode.com"};
		result = uniqueEmailAddress.numUniqueEmails(emails);
		System.out.println("result 2 : " + result);
	}

	private int numUniqueEmails(String[] emails) {
		Set<String> uniqueEmails = new HashSet<>();
		for (String email : emails) {
			StringBuilder sb = new StringBuilder();
			char[] emailChars = email.toCharArray();
			boolean isPlusEncountered = false;
			boolean isAtRateEncountered = false;
			for (Character cc : emailChars) {
				if (cc.toString().matches("[+]")) {
					isPlusEncountered = true;
				} else if (cc.toString().matches("[@]")) {
					isPlusEncountered = false;
					isAtRateEncountered = true;
					sb.append(cc);
				} else if(!isAtRateEncountered) {
					if (!cc.toString().matches("[.+]") && !isPlusEncountered) {
						sb.append(cc);
					}
				} else {
					sb.append(cc);
				}
			}
			uniqueEmails.add(sb.toString());
		}
		System.out.println(uniqueEmails);
		return uniqueEmails.size();
	}
}
