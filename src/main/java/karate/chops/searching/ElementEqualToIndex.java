package karate.chops.searching;

public class ElementEqualToIndex {

	public static void main(String... strings) {
		System.out.println(elemEqualToIndex(new int[] { -2, 0, 2, 3, 6, 7, 9 }));
		System.out.println(elemEqualToIndex(new int[] { -2, 0, 2, 6, 7, 9 }));
		System.out.println(elemEqualToIndex(new int[] { -2, 0, 6, 7, 9 }));
		System.out.println(elemEqualToIndex(new int[] { -2, -1, 1, 2, 3, 5 }));
	}

//	private static int elemEqualToIndex(int[] sorted) {
//		int low = 0, high = sorted.length - 1, result = -1;
//		
//		while(low <= high) {
//			int mid = low + ((high-low)/2);
//			if(mid==sorted[mid]) {
//				return mid;
//			} else if(mid > sorted[mid])
//				low = mid + 1;
//			else
//				high = mid -1;
//		}
//		
//		return -1;
//	}
	private static int elemEqualToIndex(int[] A) {
		if (A == null || A.length == 0)
			return -1;

		int low = 0, high = A.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (A[mid] > mid)
				high = mid - 1;
			else if (A[mid] < mid)
				low = mid + 1;
			else
				return mid;
		}
		return -1;
	}

}
