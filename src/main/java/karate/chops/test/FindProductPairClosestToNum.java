package karate.chops.test;

import java.util.*;

public class FindProductPairClosestToNum {
	public static void main(String[] args) {
		Pair p = getPairClosestToNum(new int[] { 2, 3, 5, 9 }, 47);
		System.out.println(p.num1 + ", " + p.num2);

		p = getPairClosestToNum(new int[] { 2, 3, 5, 9 }, 16);
		System.out.println(p.num1 + ", " + p.num2);

	}

	private static Pair getPairClosestToNum(int[] A, int num) {
		if (A == null || A.length == 0 || num == 0)
			return null;

		Arrays.sort(A);
		int diff = Integer.MAX_VALUE;
		Pair p = new Pair(-1, -1);
		for (int i = 0, j = A.length - 1; i < j;) {
			int product = A[i] * A[j];
			if (product == num)
				return new Pair(A[i], A[j]);
			else if (product < num) {
				if (Math.abs(num - product) < diff) {
					diff = Math.min(diff, Math.abs(num - product));
					p.num1 = A[i];
					p.num2 = A[j];
				}
				i++;
			} else {
				if (Math.abs(num - product) < diff) {
					diff = Math.min(diff, Math.abs(num - product));
					p.num1 = A[i];
					p.num2 = A[j];
				}
				j--;
			}

		}

		return p;
	}

	private static class Pair {
		int num1;
		int num2;

		Pair(int n1, int n2) {
			num1 = n1;
			num2 = n2;
		}
	}
}
