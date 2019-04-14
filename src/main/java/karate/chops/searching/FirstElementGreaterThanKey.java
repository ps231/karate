package karate.chops.searching;

public class FirstElementGreaterThanKey {

	public static void main(String... strings) {
		int[] sorted = new int[] { -14, -10, 2, 108, 108, 243, 285, 285, 285, 401 };

		System.out.println(firstGreaterElemThanKey(sorted, 108));
		System.out.println(firstGreaterElemThanKey(sorted, 285));
		System.out.println(firstGreaterElemThanKey(sorted, 401));
		System.out.println(firstGreaterElemThanKey(sorted, -14));
		System.out.println(firstGreaterElemThanKey(sorted, -13));
	}

//	private static int firstGreaterElemThanKey(int[] sorted, int elem) {
//		int low = 0, high = sorted.length - 1, result = -1;
//		
//		while(low <= high) {
//			int mid = low + ((high-low)/2);
//			if(sorted[mid]==elem) {
//				result = mid;
//				low = mid +1;
//			} else if(sorted[mid]<elem)
//				low = mid + 1;
//			else
//				high = mid -1;
//		}
//		
//		if(result > -1 && result < sorted.length-1)
//			return result + 1;
//		
//		if(result == sorted.length -1)
//			result = -1;
//		return result;
//	}

	private static int firstGreaterElemThanKey(int[] A, int num) {
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
				low = mid + 1;
			}
		}
		return index == A.length - 1 ? -1 : index + 1;
	}
}
