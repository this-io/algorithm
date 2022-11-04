package main.implementation.easy.binary;

public class MissingNumber {
  public static void main(String[] args) {
    MissingNumber m = new MissingNumber();
    int[] arr = {3,0,1};
    System.out.println(m.missingNumber(arr));
  }

  public int missingNumber(int[] nums) {
    int result = 0;

    for (int i = 0; i <= nums.length; i++) {
      result += i;
    }

    for(int i=0; i< nums.length ; i++) {
      result -= nums[i];
    }
    return result;
  }
}
