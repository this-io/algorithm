package implementation.medium.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class ThreeSum {
  public static void main(String[] args) {
    ThreeSum threeSum = new ThreeSum();
    List<List<Integer>> result = ThreeSum.threeSum(new int[]{-1,0,1,2,-1,-4});

    for(List theSmallerResult : result) {
      System.out.println(theSmallerResult.size());
      for(int i=0; i<=theSmallerResult.toArray().length-1; i++) {
        System.out.print(theSmallerResult.toArray()[i] + "    ");
      }
      System.out.println("====");
    }
  }

  public static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    List<List<Integer>> result = new ArrayList<>();
    for(int i=0; i<nums.length-1; i++) {
      int a = nums[i];
      if(i > 0 && nums[i-1] == a) {
        continue;
      } else {
        int l= i+1, r = nums.length -1;
        while(l < r) {
          int b = nums[l];
          int c = nums[r];
          int threeSum = a + b + c;
          if (threeSum > 0) {
            r -= 1;
          } else if (threeSum < 0) {
            l += 1;
          } else {
            List<Integer> theSmallResult = new ArrayList<>();
            theSmallResult.add(a);
            theSmallResult.add(nums[l]);
            theSmallResult.add(nums[r]);
            result.add(theSmallResult);

            l +=1;
            while (nums[l] == nums[l-1] && l < r) {
              l +=1;
            }
          }
        }
      }
    }

    return result;
  }

  private static void counter() {
    int count = (int) IntStream.range(0, 100).count();
  }


}
