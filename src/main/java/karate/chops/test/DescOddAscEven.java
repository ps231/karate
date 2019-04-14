package karate.chops.test;

import java.util.*;

public class DescOddAscEven {

	public static void main(String... strings) {
		printArray(sortDescOddAscEven(new Integer[] { 1, 2, 3, 5, 4, 7, 10 }));
		printArray(sortDescOddAscEven(new Integer[] { 1, 2, 3, 5, 4, 6, 7, 10 }));
		printArray(sortDescOddAscEven(new Integer[] { 10, 9, 8, 7, 6, 3, 4, 5 }));
		printArray(sortDescOddAscEven(new Integer[] { 1, 2, 3 }));
		printArray(sortDescOddAscEven(new Integer[] { 4, 2, 10, 6, 1 }));
	}

	private static void printArray(Integer[] A) {
		for (int a : A)
			System.out.print(a + " ");
		System.out.println("");
	}

	private static Integer[] sortDescOddAscEven(Integer[] A) {
		if (A == null || A.length == 0)
			return null;

		int low = 0, high = A.length - 1;
		while (low < high) {
			while (high >= low && A[high] % 2 == 0)
				high--;
			while (low < high && A[low] % 2 == 1)
				low++;

			int temp = A[high];
			A[high] = A[low];
			A[low] = temp;
			low++;
			high--;
		}
		if (A[low] % 2 == 0) {
			Arrays.sort(A, low, A.length - 1);
			Arrays.sort(A, 0, low, Collections.reverseOrder());
		} else {
			Arrays.sort(A, low + 1, A.length - 1);
			Arrays.sort(A, 0, low + 1, Collections.reverseOrder());
		}
		return A;
	}
}
