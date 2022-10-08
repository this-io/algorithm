package main.implementation.medium.string;

import java.util.Collections;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    LongestSubstringWithoutRepeatingCharacters l = new LongestSubstringWithoutRepeatingCharacters();
    System.out.println(l.lengthOfLongestSubstring("abcabcbb"));
    System.out.println(l.lengthOfLongestSubstring("bbbbb"));
    System.out.println(l.lengthOfLongestSubstring("pwwkew"));
    System.out.println(l.lengthOfLongestSubstring(""));
    System.out.println(l.lengthOfLongestSubstring(" "));
  }

  public int lengthOfLongestSubstring(String s) {
    PriorityQueue<Integer> theQ = new PriorityQueue(Collections.reverseOrder());
    for (int i = 0; i < s.length(); i++) {
      Set<Character> checker = new HashSet<>();
      checker.add(s.charAt(i));
      for (int j = i+1; j < s.length(); j++) {
        if (checker.contains(s.charAt(j))) {
          break;
        } else {
          checker.add(s.charAt(j));
        }
      }
      theQ.add(checker.size());
    }

    return theQ.size() > 0 ? theQ.peek() : 0;
  }
}
