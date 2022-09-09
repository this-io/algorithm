package main.implementation.medium.array;

public class SearchInRotatedSortedArray {
  public static void main(String[] args) {
    SearchInRotatedSortedArray s = new SearchInRotatedSortedArray();
    int[] input = {1,3};
    int target = 3;
    System.out.println(s.search(input, target));
  }

  public int search(int[] nums, int target) {
    if (nums.length == 0) {
      return -1;
    }
    if (nums.length == 1 && nums[0] == target) {
      return 0;
    } else if (nums.length == 1 && nums[0] != target) {
      return -1;
    }
    int left = 0;
    int right = nums.length - 1;
    while (left <= right) {
      if(nums[left] == target) {
        return left;
      } else {
        if (nums[left] != target) {
          left++;
          continue;
        }
        if(left == right && nums[right] == target) {
          return right;
        }
        if(nums[left] == target) {
          return left;
        }
      }
    }
    return -1;
  }
}
