package implementation.medium.string;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestRepeatingCharacterReplacement {
  public static void main(String[] args) {
    LongestRepeatingCharacterReplacement l = new LongestRepeatingCharacterReplacement();
    System.out.println(l.characterReplacement("ABAB", 2));
    System.out.println(l.characterReplacement("AABABBA", 1));
  }

  public int characterReplacement(String s, int k) {
    if (s.length() == 0 || s == null) {
      return 0;
    }

    Map<Character, Integer> count = new HashMap<>();
    int result = 0;
    int left = 0;
    //int right = 0;

    for (int right = 0; right < s.length(); right++) {
      if(count.containsKey(s.charAt(right))) {
        int t = count.get(s.charAt(right));
        t++;
        count.put(s.charAt(right), t);
      } else {
        count.put(s.charAt(right), 1);
      }

      while((right - left + 1) - Collections.max(count.values()) > k) {
        if(count.containsKey(s.charAt(left))) {
          int t = count.get(s.charAt(left));
          if(t > 0) {
            t--;
            count.put(s.charAt(left), t);
          }
        }
        left++;
      }

      result = Math.max(result, right - left + 1);
    }

    return result;
  }
}
