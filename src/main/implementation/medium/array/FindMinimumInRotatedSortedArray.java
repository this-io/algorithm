package main.implementation.medium.array;

import java.util.PriorityQueue;

public class FindMinimumInRotatedSortedArray {
  public static void main(String[] args) {
    FindMinimumInRotatedSortedArray f = new FindMinimumInRotatedSortedArray();
    int[] input = {3, 4, 5, 1, 2};
    System.out.println(f.findMin(input));
  }

  public int findMinOld1(int[] nums) {
    PriorityQueue<Integer> theQ = new PriorityQueue<>();

    if (nums.length == 0) {
      return 0;
    }

    for (int i = 0; i < nums.length; i++) {
      theQ.add(nums[i]);
    }

    return theQ.peek();
  }

  int findMin(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    if (nums.length == 1) {
      return nums[0];
    }
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      if (nums[left] > nums[right]) {
        left++;
      } else {
        if(left == right) {
          return nums[right];
        }
        return nums[left];
      }
    }
    return 0;
  }
}
