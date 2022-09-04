package main.implementation.easy;

import java.util.HashMap;
import java.util.Map;

public class JewelAndStone {
  public static void main(String[] args) {
    JewelAndStone jewelAndStone = new JewelAndStone();
    int count = jewelAndStone.numJewelsInStones("aA", "aAAbbbb");
    System.out.println("====="+ count);
  }

  public int numJewelsInStones(String J, String S) {
    Map<Character, Integer> jewelToCount = new HashMap<Character, Integer>();
    for (int i = 0; i < S.length(); i++) {
      if (jewelToCount.containsKey(S.charAt(i))) {
        int count = jewelToCount.get(S.charAt(i));
        count++;
        jewelToCount.put(S.charAt(i), count);
      } else {
        jewelToCount.put(S.charAt(i), 1);
      }
    }
    int count=0;
    for (int i = 0; i < J.length(); i++) {
      if(jewelToCount.containsKey(J.charAt(i))){
        count += jewelToCount.get(J.charAt(i));
      }
    }
    return count;
  }
}
