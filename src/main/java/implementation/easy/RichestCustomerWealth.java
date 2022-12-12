package implementation.easy;

public class RichestCustomerWealth {
	public static void main(String[] args) {
		RichestCustomerWealth r = new RichestCustomerWealth();
		int[][] input = {{1,2,3},{3,2,1}};
		System.out.println("Result : "+ r.maximumWealth(input));

		System.out.println("==========================");
		int[][] input1 = {{1,5},{7,3},{3,5}};
		System.out.println("Result : "+ r.maximumWealth(input1));

		System.out.println("==========================");
		int[][] input3 = {{2,8,7},{7,1,3},{1,9,5}};
		System.out.println("Result : "+ r.maximumWealth(input3));
	}

	private int maximumWealth(int[][] accounts) {
		int max = 0;
		for (int[] account : accounts) {
			int temp = 0;
			for (int theNumber : account) {
				temp += theNumber;
			}
			if(temp > max) {
				max = temp;
			}
		}
		return max;
	}
}
