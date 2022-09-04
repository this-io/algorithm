package main.implementation.easy;

public class SumOf1DArray {
  public static void main(String[] args) {
    SumOf1DArray sumOf1DArray = new SumOf1DArray();
    System.out.println(sumOf1DArray.runningSum(null));
  }

  public int[] runningSum(int[] nums) {
    if(nums == null){
      return null;
    }
    int result[] = new int[nums.length];
    int previousSum = 0;
    for (int i = 0; i < nums.length; i++) {
       previousSum += nums[i];
      result[i] = previousSum;
    }
    return result;
  }
}
