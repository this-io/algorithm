package main.implementation.easy;

public class ReverseStringRecursion {

	public static void main(String[] args){
		ReverseStringRecursion r = new ReverseStringRecursion();
		r.reverseString(new char[]{'h','e','l','o'});
	}

	public void reverseString(char[] s) {
		reverseSwap(s, 0, s.length - 1);
		for(int i=0; i < s.length; i++) {
			System.out.print(s[i] + " ");
		}
	}

	public void reverseSwap(char[] s, int i, int j) {
		if(i >= j) {
			return;
		}

		char temp = s[i];
		s[i] = s[j];
		s[j] = temp;

		reverseSwap(s, i+1, j-1);
	}
}
