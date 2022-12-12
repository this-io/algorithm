package implementation.easy.string;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {
  public static void main(String[] args) {
    ValidAnagram v = new ValidAnagram();
    System.out.println(v.isAnagram("anagram", "nagaram"));
    System.out.println(v.isAnagram("rat", "car"));
  }

  public boolean isAnagram(String s, String t) {
    if (s.length() == 0 || s == null || t.length() == 0 || t == null || t.length() != s.length()) {
      return false;
    }

    Map<Character, Integer> sCount = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      if (sCount.containsKey(s.charAt(i))) {
        int temp = sCount.get(s.charAt(i));
        temp++;
        sCount.put(s.charAt(i), temp);
      } else {
        sCount.put(s.charAt(i), 1);
      }
    }

    for (int i = 0; i < t.length(); i++) {
      if (sCount.containsKey(t.charAt(i))) {
        int temp = sCount.get(t.charAt(i));
        if (temp == 1) {
          sCount.remove(t.charAt(i));
        } else if (temp > 1) {
          temp--;
          sCount.put(t.charAt(i), temp);
        }
      } else {
        return false;
      }
    }

    if (!sCount.isEmpty()) {
      return false;
    }
    return true;
  }
}
