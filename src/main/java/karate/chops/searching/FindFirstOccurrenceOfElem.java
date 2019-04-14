package karate.chops.searching;

public class FindFirstOccurrenceOfElem {

	public static void main(String... strings) {
		int[] sorted = new int[] { -14, -10, 2, 108, 108, 243, 285, 285, 285, 401 };

		System.out.println(binarySearchFirstElem(sorted, 108));
		System.out.println(binarySearchFirstElem(sorted, 285));
		System.out.println(binarySearchFirstElem(sorted, 401));
		System.out.println(binarySearchFirstElem(sorted, -14));
		System.out.println(binarySearchFirstElem(sorted, -13));
	}

//	private static int binarySearchFirstElem(int[] sorted, int elem) {
//		int low = 0, high = sorted.length - 1, result = -1;
//		
//		while(low <= high) {
//			int mid = low + ((high-low)/2);
//			if(sorted[mid]==elem) {
//				result = mid;
//				high = mid -1;
//			} else if(sorted[mid]<elem)
//				low = mid + 1;
//			else
//				high = mid -1;
//		}
//		return result;
//	}

	private static int binarySearchFirstElem(int[] A, int num) {
		int index = -1;
		if (A == null || A.length == 0)
			return index;

		int low = 0;
		int high = A.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;

			if (A[mid] > num)
				high = mid - 1;
			else if (A[mid] < num)
				low = mid + 1;
			else {
				index = mid;
				high = mid - 1;
			}
		}
		return index;
	}
}
