package implementation.easy;

public class RunningSum {
	public static void main(String[] args) {
		RunningSum rs = new RunningSum();
		int[] ip = new int[]{1, 2, 3, 4};
		int[] op = rs.runningSum(ip);
		System.out.println("\n");
		for(int i=0; i < op.length; i++) {
			System.out.print(op[i]+" ");
		}
	}

	public int[] runningSum(int[] nums) {
		int result[] = new int[nums.length];
		int previousSum = 0;
		for (int i = 0; i < nums.length; i++) {
			previousSum += nums[i];
			result[i] = previousSum;
		}
		return result;
	}
}
