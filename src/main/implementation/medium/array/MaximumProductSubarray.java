package main.implementation.medium.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MaximumProductSubarray {
  public static void main(String[] args) {
    MaximumProductSubarray m = new MaximumProductSubarray();

    //int[] input = {-2, 0, -1};
    //int[] input = {-3,-1,-1};
    int[] input = {2,3,-2,4};
    //int[] input = {0,2};
    //int[] input = {3,-1,4};
    System.out.println(m.maxProduct(input));
  }

  public int maxProduct(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    List<Integer> theArray = Arrays.stream(nums).boxed().collect(Collectors.toList());
    int result = Collections.max(theArray);
    //int min = Collections.min(theArray);
    int curMin = 1, curMax = 1;

    for (int i : nums) {
      if (i == 0) {
        curMax = 1;
        curMin = 1;
        continue;
      }
      int temp = curMax * i;
      curMax = Math.max(i * curMax, Math.max(i * curMin, i));
      curMin = Math.min(temp, Math.min(i * curMin, i));
      result = Math.max(result, curMax);
    }
    return result;
  }
}
