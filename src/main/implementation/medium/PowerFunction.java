package main.implementation.medium;

public class PowerFunction {
	public static void main(String[] args) {
		PowerFunction p = new PowerFunction();
		System.out.println(p.myPow(1.00012,1024));
	}

	public double myPow(double x, int y) {
		/*int MAX = 2^32;
		int MIN = -(2^32-1);

		if(x == 0) {
			return 1;
		}

		if(n == 0) {
			return 1;
		}
		if(n > 0) {
			return x * myPow(x, n-1);
		} else {
			return 1/(x * myPow(x, (n*-1)-1));
		}*/
		if (y == 0)
			return 1;
		else if (y % 2 == 0)
			return myPow(x, y / 2) * myPow(x, y / 2);
		else
			return x * myPow(x, y / 2) * myPow(x, y / 2);
	}

}
