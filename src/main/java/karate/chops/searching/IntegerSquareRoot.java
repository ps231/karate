package karate.chops.searching;

public class IntegerSquareRoot {
	public static void main(String[] args) {
		System.out.println(maxIntWhoseSquareIsLessThanK(21));
		System.out.println(maxIntWhoseSquareIsLessThanK(300));
		System.out.println(maxIntWhoseSquareIsLessThanK(16));
		System.out.println(maxIntWhoseSquareIsLessThanK(226));
		System.out.println(maxIntWhoseSquareIsLessThanK(35));
	}

//	private static int maxIntWhoseSquareIsLessThanK(int k) {
//		int low = 0, high = k;
//		while (low < high) {
//			int mid = low + (high - low) / 2;
//			int midSquare = (int) Math.pow(mid, 2);
//			if (midSquare > k)
//				high = mid - 1;
//			else if (midSquare < k)
//				low = mid + 1;
//			else
//				return mid;
//		}
//		return Math.pow(low, 2) > k ? low - 1 : low;
//	}

	private static int maxIntWhoseSquareIsLessThanK(int k) {
		if (k <= 0)
			return Integer.MIN_VALUE;
		int low = 1, high = k;

		while (low < high) {
			int mid = low + (high - low) / 2;
			int square = mid * mid;
			if (square > k)
				high = mid - 1;
			else if (square < k)
				low = mid + 1;
			else
				return mid;
		}
		return low * low > k ? low - 1 : low;
	}
}
