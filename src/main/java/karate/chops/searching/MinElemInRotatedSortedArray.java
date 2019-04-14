package karate.chops.searching;

public class MinElemInRotatedSortedArray {
	public static void main(String[] args) {
		System.out.println(findMinInCyclicSortedArray(new int[] { -14, -10, 2, 108, 108, 243, 285, 285, 285, 401 }));
		System.out.println(findMinInCyclicSortedArray(new int[] { -14, -10, 2, 108, 243, 285, 401 }));
		System.out.println(findMinInCyclicSortedArray(new int[] { 243, 285, 401, -14, -10, 2, 108 }));
		System.out.println(findMinInCyclicSortedArray(new int[] { 2, 108, 243, 285, 401, -14, -10 }));
		System.out.println(findMinInCyclicSortedArray(new int[] { -10, 2, 108, 243, 285, 401, -14 }));
		System.out.println(findMinInCyclicSortedArray(null));

	}

//	private static int findMinInCyclicSortedArray(int[] A) {
//		int minElem = Integer.MAX_VALUE;
//		if (A == null || A.length == 0)
//			return minElem;
//
//		int low = 0, high = A.length - 1;
//		while (low < high) {
//			int mid = low + (high - low) / 2;
//			if (A[mid] < A[high])
//				high = mid;
//			else
//				low = mid + 1;
//		}
//
//		return A[low];
//
//	}

	private static int findMinInCyclicSortedArray(int[] A) {
		if (A == null || A.length == 0)
			return -1;

		int low = 0, high = A.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (A[mid] < A[high])
				high = mid;
			else if (A[mid] > A[high])
				low = mid + 1;
		}
		return A[low];

	}

}
