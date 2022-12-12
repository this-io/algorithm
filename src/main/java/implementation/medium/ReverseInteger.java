package implementation.medium;

public class ReverseInteger {
	public static void main(String[] args) {
		ReverseInteger r = new ReverseInteger();
		r.reverse(123);
	}

	public int reverse(int x) {
		if (x == 0) {
			return 0;
		}

		if (x < 10 && x > -10) {
			return x;
		}
		int reverse = 0;
		while (x != 0) {
			int temp = x % 10;
			System.out.println(temp);
			x /= 10;
			System.out.println(x);
			if (reverse > Integer.MAX_VALUE / 10
					|| (reverse == Integer.MAX_VALUE / 10 && temp > 7)
			) {
				return 0;
			}

			if (reverse < Integer.MIN_VALUE / 10
					|| (reverse == Integer.MIN_VALUE / 10 && temp < -8)
			) {
				return 0;
			}
			reverse = reverse * 10 + temp;
		}

		System.out.println(reverse);

		return reverse;
	}
}
