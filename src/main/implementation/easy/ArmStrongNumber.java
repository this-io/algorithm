package main.implementation.easy;

public class ArmStrongNumber {
	public static void main(String[] args) {
		System.out.println(armstrongNumber(407));
	}

	static String armstrongNumber(int n){
		if(n < 100) return "No";
		int ip = n;
		int theSum = 0;
		while(n > 0) {
			theSum += (int) Math.pow(n%10, 3);
			n = n/10;
		}
		return ip == theSum ? "Yes" : "No";
	}
}
