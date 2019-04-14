package karate.chops.test;

import java.util.Arrays;

public class EvenOddArrays {

	public static void main(String[] args) {
		int[] A = new int[] { 8, 6, 3, 11, 2, 9, 12 };
		evenodd(A);
		System.out.println(Arrays.toString(A));

		A = new int[] { 1, 3, 6, 10, 2, 9, 8, 7, 5 };
		evenodd(A);
		System.out.println(Arrays.toString(A));
	}

//	private static void evenodd(int[] A) {
//		// TODO Auto-generated method stub
//		int even = 0;
//		int odd = A.length - 1;
//		int temp = 0;
//		
//		while(even < odd) {
//			if(A[even] %2==0)
//				even++;
//			else {
//				temp = A[odd];
//				A[odd] = A[even];
//				A[even] = temp;
//				odd--;
//			}
//		}
//	}

	private static void evenodd(int[] A) {
		int even = 0, odd = 1;
		if (A == null || A.length <= 1)
			return;
		while (odd < A.length) {
			if (A[even] % 2 == 0) {
				even++;
				odd++;
			} else {
				while (odd < A.length && A[odd] % 2 != 0) {
					odd++;
				}
				if (odd < A.length) {
					int temp = A[even];
					A[even] = A[odd];
					A[odd] = temp;
					even++;
					odd++;
				}
			}

		}
	}
}
