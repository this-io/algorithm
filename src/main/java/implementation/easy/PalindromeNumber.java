package implementation.easy;

public class PalindromeNumber {
	public static void main(String[] args) {
		System.out.println(isPalindrome(123));
	}

	private static boolean isPalindrome(int input) {
		if (input <= 0) {
			return false;
		}
		String revInput = reverseString(String.valueOf(input));

		return (String.valueOf(input).equals(revInput)) ? true : false;
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
}
