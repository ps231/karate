package karate.chops.test;

public class DeleteDuplicatesInArray {
	public static void main(String... strings) {
		int[] A = new int[] { 2, 3, 5, 5, 7, 11, 11, 11, 13 };
		int uniqueIndex = deleteDuplicates(A);
		for (int i = 0; i <= uniqueIndex; i++)
			System.out.print(A[i] + " ");

		System.out.println("");
		A = new int[] { 2, 3, 3, 3, 3, 3 };
		uniqueIndex = deleteDuplicates(A);
		for (int i = 0; i <= uniqueIndex; i++)
			System.out.print(A[i] + " ");

		System.out.println("");
		A = new int[] { 2, 3, 5, 5, 7, 11, 11, 11, 13, 15, 15, 18, 18, 18, 19, 20 };
		uniqueIndex = deleteDuplicates(A);
		for (int i = 0; i <= uniqueIndex; i++)
			System.out.print(A[i] + " ");  

		System.out.println("");
		A = new int[] { 5, 5, 5 };
		uniqueIndex = deleteDuplicates(A);
		for (int i = 0; i <= uniqueIndex; i++)
			System.out.print(A[i] + " ");

	}

	private static int deleteDuplicates(int[] A) {
		if (A == null || A.length == 0)
			return -1;

		if (A.length == 1)
			return 0;

		int i = 0;
		for (int j = 1; j < A.length;) {
			if (A[i] != A[j]) {
				i++;
				j++;
			} else {
				while (j < A.length && A[i] == A[j])
					j++;
				if (j < A.length) {
					A[i + 1] = A[j];
					i++;
				}
			}
		}
		return i;

	}
}
