package main.implementation.easy.array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class TwoSum {
  public static void main(String[] args) {
    TwoSum t = new TwoSum();
    int[] input = {3,3};
    int target = 6;
    int[] result = t.twoSum(input, target);
    for(int i : result) {
      System.out.print(i +  ", ");
    }
  }

  public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();

    for(int i=0; i<nums.length; i++){
      int second = target - nums[i];
      if (map.containsKey(second)) {
        return new int[]{map.get(second), i};
      }
      map.put(nums[i], i);
    } throw new IllegalArgumentException("No Two sum solution");
  }
}
