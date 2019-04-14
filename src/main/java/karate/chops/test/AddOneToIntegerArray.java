package karate.chops.test;

import java.util.*;

public class AddOneToIntegerArray {

	public static void main(final String[] args) {
		int[] A = new int[] { 1, 9, 9 };
		A = addOne(A);
		System.out.println(Arrays.toString(A));

		List<Integer> B = new ArrayList<Integer>();
		B.add(9);
		B.add(9);
		B = plusOne(B);
		System.out.println(B.toString());

		B = new ArrayList<Integer>();
		B.add(2);
		B.add(8);
		B = plusOne(B);
		System.out.println(B.toString());
	}

	private static int[] addOne(int[] A) {
		int carry = 1;
		for (int i = A.length - 1; i >= 0; i--) {
			int sum = A[i] + carry;
			if (sum < 10) {
				A[i] = sum;
				carry = 0;
				break;
			} else {
				carry = sum / 10;
				A[i] = sum % 10;
			}
		}

		if (carry != 0) {
			int[] B = new int[A.length + 1];
			B[0] = carry;
			for (int i = 0; i < A.length; i++)
				B[i + 1] = A[i];
			A = B;
			System.out.println("shift right necessary" + carry);
		}

		return A;
	}

	private static List<Integer> plusOne(List<Integer> A) {
		int sum = 0, carry = 0;
		for (int i = A.size() - 1; i >= 0; i--) {
			if (i == A.size() - 1)
				sum = A.get(i) + 1;
			else
				sum = A.get(i) + carry;

			A.set(i, sum % 10);
			carry = sum / 10;
			sum = 0;
		}
		if (carry > 0)
			A.add(0, carry);

		return A;
	}
}