package main.implementation.easy;

import java.util.Map;

public class CharCount {
	public static void main(String[] args) {
		System.out.println(counterMethod('a', "Shraddha Ghogare"));
	}

	public static int counterMethod(char theChar, String theInput) {
		if((int)theChar == 0 || theInput.isEmpty())  {
			return 0;
		}

		int output = 0;
		for(int i=0; i<theInput.length(); i++) {
			if(theChar == theInput.charAt(i)) {
				output++;
			}
		}

		return output;
	}

}
