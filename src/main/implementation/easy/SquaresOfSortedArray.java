package main.implementation.easy;

public class SquaresOfSortedArray {
	public static void main(String[] args) {
		SquaresOfSortedArray a = new SquaresOfSortedArray();
		int[] input = {-4, -1, 0, 3, 10};
		int[] result = a.sortedSquares(input);
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i] + "  ");
		}
	}

	public int[] sortedSquares(int[] nums) {
		if (nums.length == 0) {
			return nums;
		}
		int left = 0;
		int right = nums.length - 1;
		int[] result = new int[nums.length];
		for (int i = nums.length - 1; i >= 0; i--) {
			int nToSquare = 0;
			if (Math.abs(nums[left]) > Math.abs(nums[right])) {
				nToSquare = nums[left];
				left++;
			} else {
				nToSquare = nums[right];
				right--;
			}
			result[i] = nToSquare * nToSquare;
		}
		return result;
	}
}
