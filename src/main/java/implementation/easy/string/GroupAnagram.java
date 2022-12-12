package implementation.easy.string;

import java.util.*;

public class GroupAnagram {
  public static void main(String[] args) {
    GroupAnagram g = new GroupAnagram();
    String[] st = {"eat", "tea", "tan", "ate", "nat", "bat"};
    //String[] st = {"", "", ""};
    System.out.println(g.groupAnagrams(st));
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    Map<String, List<String>> theMap = new HashMap<>();
    for (String s : strs) {
      String sortedS = sortString(s);
      if (theMap.containsKey(sortedS)) {
        List<String> temp = theMap.get(sortedS);
        temp.add(s);
        theMap.put(sortedS, temp);
      } else {
        List<String> k = new ArrayList<>();
        k.add(s);
        theMap.put(sortedS, k);
      }
    }

    if (theMap.isEmpty()) {
      return null;
    }
    List<List<String>> result = new ArrayList<>();
    for (List<String> l : theMap.values()) {
      result.add(l);
    }
    return result;
  }

  public static String sortString(String inputString) {
    // Converting input string to character array
    char tempArray[] = inputString.toCharArray();

    // Sorting temp array using
    Arrays.sort(tempArray);

    // Returning new sorted string
    return new String(tempArray);
  }
}
