package implementation.hard.string;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
  public static void main(String[] args) throws IOException {
    MinimumWindowSubstring m = new MinimumWindowSubstring();
    //System.out.println(m.minWindow("ADOBECODEBANC", "ABC"));
    //System.out.println(m.minWindow("a", "b"));
    //System.out.println(m.minWindow("ab", "A"));
    System.out.println(m.minWindow(readFile("s.txt"), readFile("t.txt")));

  }

  public static String readFile(String k) throws IOException {
    String file ="src/main/scrap/"+k;

    BufferedReader reader = new BufferedReader(new FileReader(file));
    String currentLine = reader.readLine();
    try {
      reader.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return currentLine;
  }

  public String minWindow(String s, String t) {
    HashMap<Character, Integer> map = new HashMap<>();

    for (char x : t.toCharArray()) {
      map.put(x, map.getOrDefault(x, 0) + 1);
    }

    int matched = 0;
    int start = 0;
    int minLen = s.length() + 1;
    int subStr = 0;
    for (int endWindow = 0; endWindow < s.length(); endWindow++) {
      char right = s.charAt(endWindow);
      if (map.containsKey(right)) {
        map.put(right, map.get(right) - 1);
        if (map.get(right) == 0) matched++;
      }

      while (matched == map.size()) {
        if (minLen > endWindow - start + 1) {
          minLen = endWindow - start + 1;
          subStr = start;
        }
        char deleted = s.charAt(start++);
        if (map.containsKey(deleted)) {
          if (map.get(deleted) == 0) matched--;
          map.put(deleted, map.get(deleted) + 1);
        }
      }
    }
    return minLen > s.length() ? "" : s.substring(subStr, subStr + minLen);
  }

  /*public String minWindow(String s, String t) {
    System.out.println(s.length());
    if (s.isEmpty() || t.isEmpty()) {
      return "";
    }

    Map<Character, Long> tCount = new HashMap<>();
    Map<Character, Long> window = new HashMap<>();

    for (int i = 0; i < t.length(); i++) {
      tCount.merge(t.charAt(i), 1L, Long::sum);
    }
    System.out.println(tCount);

    int need = tCount.size();
    int have = 0;
    double resultLength = Double.POSITIVE_INFINITY;
    int resultLeft = -1;
    int resultRight = -1;

    int l = 0;
    for (int r = 0; r < s.length(); r++) {
      char temp = s.charAt(r);
      //System.out.println(temp);
      window.merge(temp, 1L, Long::sum);
      if(window.get(temp) == tCount.get(temp)) {
        System.out.println(window.get(temp));
        System.out.println(tCount.get(temp));
      }

      if (tCount.containsKey(temp) && window.get(temp) == tCount.get(temp)) {
        have++;
      }
      //System.out.println("have " + have);
      while (need == have) {
        System.out.println("l");
        if ((r - l + 1) < resultLength) {
          resultLength = (r - l + 1);
          resultLeft = l;
          resultRight = r;
        }

        window.put(s.charAt(l), window.get(s.charAt(l)) - 1);

        if (tCount.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < tCount.get(s.charAt(l))) {
          have--;
        }
        l++;
      }
    }
    System.out.println(window);
    if(resultLength == Double.POSITIVE_INFINITY) {
      return "";
    }
    return s.substring(resultLeft, resultRight + 1);
  }*/
}
