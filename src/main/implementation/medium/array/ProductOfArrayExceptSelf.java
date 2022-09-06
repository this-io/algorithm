package main.implementation.medium.array;

public class ProductOfArrayExceptSelf {
  public static void main(String[] args) {
    ProductOfArrayExceptSelf productOfArrayExceptSelf = new ProductOfArrayExceptSelf();
    int[] input = {1, 2, 3, 4};
    for (int i : productOfArrayExceptSelf.productExceptSelf(input)) {
      System.out.print(i + "  ");
    }
  }

  public int[] productExceptSelf(int[] nums) {
    if (nums.length == 0) {
      return new int[0];
    }
    int[] result = new int[nums.length];
    int prefix = 1;
    for (int i = 0; i < nums.length; i++) {
      result[i] = prefix;
      prefix *= nums[i];
    }

    int postfix = 1;
    for (int i = nums.length-1; i >= 0; i--) {
      result[i] *= postfix;
      postfix *= nums[i];
    }

    return result;
  }
}
