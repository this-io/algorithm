package implementation.easy;

public class CountBits {
	public static void main(String[] args) {
		System.out.println();
		CountingBits c = new CountingBits();
		c.countBits(2);
	}

	public int[] countBits(int n) {
		int[] ans = new int[n + 1];
		for (int i = 0; i <= n; i++) {
			char[] bin = Integer.toBinaryString(i).toCharArray();
			int countBit = 0;
			for (int j = 0; j < bin.length; j++) {
				if(bin[j] == '1') {
					countBit++;
				}
			}
			ans[i] = countBit;
			System.out.print(countBit+"\t");
		}

		return ans;
	}
}
