package main.implementation.easy;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

//INCOMPLETE
public class LicenseKeyFormatting {
	public static void main(String[] args) {
		LicenseKeyFormatting l = new LicenseKeyFormatting();
		l.licenseKeyFormatting("2-5g-3-J", 2);
		l.licenseKeyFormatting("5F3Z-2e-9-w", 4);
	}

	public String licenseKeyFormatting(String s, int k) {
		StringBuilder op = new StringBuilder("");
		int sLength = s.length();
		char[] arrayedString = s.toCharArray();
		int counter = 0;
		for(int i=arrayedString.length-1; i>=0; i--) {
			if(isProcessable(arrayedString[i])) {
				if(counter%k==0) {
					op.append("-");
				}
				op.append(Character.toString(arrayedString[i]).toUpperCase());
				counter++;
			}

		}
		if(!op.toString().isEmpty() && op.charAt(0) == '-'){
			op.deleteCharAt(0).reverse();
		}
		System.out.println(op.toString());
		return op.toString();
	}

	private static boolean isProcessable(char i) {
		return Character.isDigit(i) || Character.isLetter(i);
	}
}
