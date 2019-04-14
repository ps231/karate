package karate.chops.test;

public class FindSumOfFirstKEvenLengthPalindromNumbers {
	public static void main(String[] arsg) {
		System.out.println(sumOfFirstKEvenLengthPalindromNumbers(3));
	}

//	if k = 3, then answer = 66, 11+22+33
//	11,22,33,44,55,66,77,88,99,1001,1111,1221,1331,1441,1551,1661...
	private static int sumOfFirstKEvenLengthPalindromNumbers(int k) {
		int sum = 0;
		if (k == 0)
			return sum;
		for (int i = 1; i <= k; i++) {
			StringBuilder num = new StringBuilder();
			num.append(i);
			StringBuilder rev = num.reverse();
			num.append(rev.toString());
			sum += Integer.parseInt(num.toString());
		}
		return sum;
	}
}
