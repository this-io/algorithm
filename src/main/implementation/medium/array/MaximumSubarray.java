package main.implementation.medium.array;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MaximumSubarray {
  public static void main(String[] args) {
    MaximumSubarray m = new MaximumSubarray();
    //int[] input = {5,4,-1,7,8};
    int[] input = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
    System.out.println(m.maxSubArray(input));
  }

  public int maxSubArray(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }

    int maxSum = nums[0];
    int curSum = 0;
    for(int i : nums) {
      if(curSum < 0) {
        curSum = 0;
      }
      curSum += i;
      maxSum = Math.max(maxSum,curSum);
    }

    return maxSum;
  }
}
