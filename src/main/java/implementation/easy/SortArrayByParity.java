package implementation.easy;

import java.util.ArrayList;
import java.util.List;

public class SortArrayByParity {
	public static void main(String[] args) {
		SortArrayByParity a = new SortArrayByParity();
		int[] input = {3,1,2,4};
		//a.sortArrayByParity(input);

		int[] result = a.sortArrayByParity1(input);
		for(int i : result) {
			System.out.print(i+ " ");
		}
	}

	public int[] sortArrayByParity(int[] nums) {
		int[] result = new int[nums.length];
		List<Integer> odd = new ArrayList<>();
		List<Integer> even = new ArrayList<>();
		for(int i=0; i < nums.length; i++) {
			if(nums[i]%2 == 0) {
				even.add(nums[i]);
			} else {
				odd.add(nums[i]);
			}
		}
		for(int i=0; i<even.size(); i++) {
			result[i] = even.get(i);
		}
		int c = even.size();
		for(int j: odd) {
			result[c] = j;
			c++;
		}
		return result;
	}

	//This is faster
	public int[] sortArrayByParity1(int[] nums) {
		int[] result = new int[nums.length];
		int frontResultCounter = 0;
		int backCounter = nums.length -1;
		for(int i=0; i < nums.length; i++) {
			if(nums[i]%2 == 0) {
				result[frontResultCounter] = nums[i];
				frontResultCounter++;
			} else {
				result[backCounter] = nums[i];
				backCounter--;
			}
		}
		return result;
	}
}
