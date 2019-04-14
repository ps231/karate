package karate.chops.test;

public class Power {

	public static void main(String[] args) {

		System.out.println(power(2, 5));
		System.out.println(power(2, 8));
		System.out.println(power(2, 3));
	}

	private static int power(int x, int n) {
		if (n == 0)
			return 1;

		if (n == 1)
			return x;

		int[] intermediate = new int[n / 2 + 1];
		intermediate[0] = 1;
		intermediate[1] = x;
		return powerHelper(x, n, intermediate);
	}

	private static int powerHelper(int x, int n, int[] intermediate) {
		if (n == 0)
			return intermediate[0];
		if (n == 1)
			return intermediate[1];

		if (n % 2 == 0) {
			if (intermediate[n / 2] == 0)
				intermediate[n / 2] = powerHelper(x, n / 2, intermediate);
			return intermediate[n / 2] * intermediate[n / 2];
		} else {
			if (intermediate[n / 2] == 0)
				intermediate[n / 2] = powerHelper(x, 1, intermediate) * powerHelper(x, n / 2, intermediate);
			return intermediate[1] * intermediate[n / 2] * intermediate[n / 2];
		}

	}

}
