package implementation.easy;

public class StringReversal {
	public static void main(String[] args) {
		//String output = reverseString("Shraddha Ghogare");
		//System.out.println(output);
		reverseStringFromMiddle("Indian");
	}

	public static String reverseString(String input) {
		if(input.isEmpty()) {
			return "";
		}
		String output ="";
		for(int i=input.length()-1; i>=0; i--) {
			output = output+input.charAt(i);
		}
		return output;
	}

	public static String reverseStringFromMiddle(String input) {
		if(input.isEmpty()) {
			return "";
		}
		int length = input.length();
		if(length%2 > 0) {
			char[] op = input.toCharArray();
			int mid = length/2;
			int iCounter = mid - 1;
			int jCounter = mid + 1;

			while(iCounter >= 0 && jCounter <= length) {
				char temp = op[iCounter];
				op[iCounter] = op[jCounter];
				op[jCounter] = temp;
				iCounter--;
				jCounter++;
			}
			for(int i=0; i<op.length; i++) {
				System.out.print( op[i]);
			}
		} else {
			char[] op = input.toCharArray();
			int mid = length/2;  //4/2 = 2
			int iCounter = mid - 1; //1
			int jCounter = mid; //2
			System.out.println(iCounter +" "+ jCounter);
			while(iCounter >= 0 && jCounter <= length) {
				char temp = op[iCounter];
				op[iCounter] = op[jCounter];
				op[jCounter] = temp;
				iCounter--;
				jCounter++;
			}
			for(int i=0; i<op.length; i++) {
				System.out.print( op[i]);
			}
		}

		return "";
	}
}
