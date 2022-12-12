package implementation.easy;

public class CountingBits {
	public static void main(String[] args) {
		CountingBits c = new CountingBits();
		int[] result = c.countBits(45);

		for(int i=0; i< result.length; i++) {
			System.out.print(result[i]+"  ");
		}
	}

	public int[] countBits(int n) {
		int[] result = new int[n+1];
		for(int i=0; i<=n; i++) {
			char[] binaryIp = Integer.toBinaryString(i).toCharArray();
			int counter = 0;
			//System.out.println("===="+Integer.toBinaryString(i));
			for(int j=0; j < binaryIp.length; j++) {
				//System.out.println("counter : "+counter);
				if(Character.toString(binaryIp[j]).equals("1")) {
					counter++;
				}
			}
			result[i] = counter;
		}
		return result;
	}

}
