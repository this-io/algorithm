package main.implementation.easy.array;

import java.util.HashMap;
import java.util.Map;

public class ContainsDuplicate {
  public static void main(String[] args) {
    ContainsDuplicate c = new ContainsDuplicate();
    int[] nums = {1,2,3,1};
    System.out.println(c.containsDuplicate(nums));
  }

  public boolean containsDuplicate(int[] nums) {
    Map<Integer, Integer> theMap = new HashMap<>();

    for(int i : nums) {
      if(theMap.containsKey(i)) {
        return true;
      } else {
        theMap.put(i, 1);
      }
    }
    return false;
  }
}
