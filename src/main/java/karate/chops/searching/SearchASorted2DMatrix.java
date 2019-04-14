package karate.chops.searching;

public class SearchASorted2DMatrix {
	public static void main(String[] arsg) {
		int[][] A = new int[][] { { 10, 20, 30, 40 }, { 15, 25, 35, 45 }, { 27, 29, 37, 48 }, { 32, 33, 39, 50 } };
		System.out.println(findElement(A, 28));
		System.out.println(findElement(A, 35));
		System.out.println(findElement(A, 30));
		System.out.println(findElement(A, 52));
		System.out.println(findElement(A, 5));
		System.out.println(findElement(A, 39));
	}

//	private static boolean findElement(int[][] A, int elem) {
//		if (A == null)
//			return false;
//		if (elem < A[0][0] || elem > A[A.length - 1][A[0].length - 1])
//			return false;
//		int rows = A.length, cols = A[0].length;
//		int j = cols - 1;
//		int i = 0;
//		while (i < rows && j >= 0) {
//			if (elem < A[i][j])
//				j--;
//			else if (elem > A[i][j])
//				i++;
//			else
//				return true;
//		}
//		return false;
//	}

	private static boolean findElement(int[][] A, int num) {
		if (A == null || A.length == 0 || A[0][0] > num || A[A.length - 1][A[0].length - 1] < num)
			return false;
		int i = 0, j = A[0].length - 1;
		while (i <= A.length - 1 && j >= 0) {
			if (A[i][j] > num)
				j--;
			else if (A[i][j] < num)
				i++;
			else
				return true;
		}
		return false;
	}
}
