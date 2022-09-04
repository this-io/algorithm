package main.implementation.easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SmallerNumberFinder {
  public static void main(String[] args) {
    SmallerNumberFinder smallerNumberFinder = new SmallerNumberFinder();
    int[] input = new int[] {8,1,2,2,3};
    int[] result = smallerNumberFinder.smallerNumbersThanCurrent(input);
    System.out.println("Result==="+result.length);
    for(int i=0; i < result.length; i++){
      System.out.println(+input[i] + " : " +result[i]);
    }
  }

  public int[] smallerNumbersThanCurrent(int[] nums) {
      int[] result = new int[nums.length];
      for(int i =0; i < nums.length; i++){
          int counter = 0;
          for(int j = 0; j < nums.length; j++){
              if(nums[i] > nums[j]){
                  counter++;
              }
          }
          result[i] = counter;
      }
      return result;
  }
}
