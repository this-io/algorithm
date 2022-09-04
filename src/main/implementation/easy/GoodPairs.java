package main.implementation.easy;

import java.util.HashMap;
import java.util.Map;

public class GoodPairs {
  public static void main(String[] args) {
    GoodPairs goodPairs = new GoodPairs();
    int[] nums = new int[]{1,2,3,1,1,3};
    System.out.println(goodPairs.numIdenticalPairs(nums));
  }

  //Greedy approach
  public int numIdenticalPairsTwo(int[] nums) {
    if(nums == null) {
      return 0;
    }
    int goodPair = 0;
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] == nums[j]) {
          goodPair++;
        }
      }
    }
    return goodPair;
  }

  //Need to work on this
  public int numIdenticalPairs(int[] nums) {
    Map<Integer, Integer> numToCount = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length-1; i++) {
      if (numToCount.containsKey(nums[i])) {
        Integer count = numToCount.get(nums[i]);
        count += 1;
        numToCount.put(nums[i], count);
      } else {
        numToCount.put(nums[i], 1);
      }
    }
    int goodPair = 0;
    for (Integer loop : numToCount.keySet()) {
      System.out.println("nums " + loop + "====" + numToCount.get(loop));
      long res = 1;
      if (numToCount.get(loop) >= 2) {
        goodPair +=
            getFact(numToCount.get(loop)) / (getFact(numToCount.get(loop) - 2) * getFact(2));
      }
    }
    return goodPair;
  }

  public static long getFact(int n) {
    long f = 1;
    for (int i = n; i >= 1; i--) {
      f *= i;
    }
    return f;
  }
}
