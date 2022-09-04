package main.implementation.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CheckAllCharHasEqualOccurrences {

	public static void main(String[] args) {
		CheckAllCharHasEqualOccurrences c = new CheckAllCharHasEqualOccurrences();
		c.areOccurrencesEqual("abacbc");
	}

	public boolean areOccurrencesEqual(String s) {
		Map<Character, Integer> countKeeper = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (countKeeper.containsKey(s.charAt(i))) {
				countKeeper.put(s.charAt(i), countKeeper.get(s.charAt(i)) + 1);
			} else {
				countKeeper.put(s.charAt(i), 1);
			}
		}
		boolean op = false;
		int firstOccurrence=0;
		Set<Integer> what = new HashSet<>();
		what.addAll(countKeeper.values());

		if(what.size() == 1) {
			return true;
		}
		return false;
	}
}
