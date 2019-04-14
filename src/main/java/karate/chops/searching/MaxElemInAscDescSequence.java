package karate.chops.searching;

public class MaxElemInAscDescSequence {

	public static void main(String... strings) {
		System.out.println(maxElemInSeq(new int[] { 3, 6, 7, 3, 0, -2 }));
		System.out.println(maxElemInSeq(new int[] { 10, 25, 30, 28, 26, 23, 15, 5 }));
		System.out.println(maxElemInSeq(new int[] { 10, 25, 30, 35, 38, 40, 42, 5 }));
		System.out.println(maxElemInSeq(new int[] { 10, 25, 24, 23, 22, 21, 15, 5 }));
		System.out.println(maxElemInSeq(new int[] { 10, 9, 5 }));
	}

//	private static int maxElemInSeq(int[] sorted) {
//		// TODO Auto-generated method stub
//		int low = 0, high = sorted.length - 1, result = Integer.MIN_VALUE;
//		
//		while(low <= high) {
//			int mid = low + ((high-low)/2);
//			if(sorted[mid+1]>sorted[mid]) {
//				low = mid + 1;
//			} else if(sorted[mid+1]<sorted[mid]) {
//				result = Math.max(result, sorted[mid]);
//				high = mid - 1;
//			}
//		}
//		
//		return result;
//	}

//	private static int maxElemInSeq(int[] A) {
//		if (A == null || A.length == 0)
//			return -1;
//
//		int low = 0, high = A.length - 1;
//		while (low < high) {
//			int mid = low + (high - low) / 2;
//			if (mid < A.length - 1 && A[mid] > A[mid + 1])
//				high = mid;
//			else if (mid < A.length - 1 && A[mid] < A[mid + 1])
//				low = mid + 1;
//		}
//		return A[low];
//	}

//	private static int maxElemInSeq(int[] A) {
//		if (A == null || A.length == 0)
//			return Integer.MIN_VALUE;
//
//		int low = 0, high = A.length - 1;
//		while (low < high) {
//			int mid = low + (high - low) / 2;
//			if (mid < A.length - 1 && A[mid + 1] < A[mid])
//				high = mid;
//			else if (mid < A.length - 1 && A[mid + 1] > A[mid])
//				low = mid + 1;
//		}
//		return A[low];
//
//	}

	private static int maxElemInSeq(int[] A) {
		if (A == null || A.length == 0)
			return Integer.MIN_VALUE;

		int low = 0;
		int high = A.length - 1;

		while (low < high) {
			int mid = low + (high - low) / 2;
			if (A[mid] > A[mid + 1])
				high = mid;
			else if (A[mid] < A[mid + 1])
				low = mid + 1;
		}
		return A[low];
	}
}
