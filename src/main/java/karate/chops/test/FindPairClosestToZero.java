package karate.chops.test;

import java.util.Arrays;

public class FindPairClosestToZero {
	public static void main(String[] arsg) {
		Pair p = findPairClosestToZero(new int[] { -3, -1, 0, 2, 5 });
		System.out.println(p.num1 + ", " + p.num2);

		p = findPairClosestToZero(new int[] { -3, -1, 1, 2, 5 });
		System.out.println(p.num1 + ", " + p.num2);

		p = findPairClosestToZero(new int[] { -3, -1, 0, 1, 2, 5 });
		System.out.println(p.num1 + ", " + p.num2);
	}

	private static Pair findPairClosestToZero(int[] A) {
		if (A == null || A.length == 0)
			return null;

		Arrays.sort(A);
		int closestToZero = Integer.MAX_VALUE;
		int i = 0, j = A.length - 1;
		Pair p = new Pair();
		while (i < j) {
			int sum = Math.abs(A[i] + A[j]);
			if (sum < closestToZero) {
				closestToZero = Math.min(sum, closestToZero);
				p.num1 = A[i];
				p.num2 = A[j];
			}

			if (A[i] + A[j] > 0)
				j--;
			else if (A[i] + A[j] < 0)
				i++;
			else
				return p;
		}
		return p;
	}

	private static class Pair {
		int num1;
		int num2;
	}
}
