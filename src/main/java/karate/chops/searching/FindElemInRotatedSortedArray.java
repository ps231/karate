package karate.chops.searching;

public class FindElemInRotatedSortedArray {
	public static void main(String[] args) {
		System.out.println(findElemInRotatedSortedArray(new int[] { 35, 38, 43, 5, 12, 17, 19 }, 19));
		System.out.println(findElemInRotatedSortedArray(new int[] { 35, 38, 43, 5, 12, 17, 19 }, 18));
		System.out.println(findElemInRotatedSortedArray(new int[] { 17, 19, 35, 38, 43, 5, 12 }, 19));
		System.out.println(findElemInRotatedSortedArray(new int[] { 17, 19, 35, 38, 43, 5, 12 }, 18));
		System.out.println(findElemInRotatedSortedArray(new int[] { 43, 5, 12, 17, 19, 35, 38 }, 19));
		System.out.println(findElemInRotatedSortedArray(new int[] { 43, 5, 12, 17, 19, 35, 38 }, 18));
		System.out.println(findElemInRotatedSortedArray(new int[] { 43, 5, 12, 17, 19, 35, 38 }, 43));
		System.out.println(findElemInRotatedSortedArray(new int[] { 43, 5, 12, 17, 19, 35, 38 }, 38));
	}

	private static boolean findElemInRotatedSortedArray(int[] A, int elem) {
		if (A == null || A.length == 0)
			return false;
		int low = 0, high = A.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (A[mid] > A[high])
				low = mid + 1;
			else
				high = mid;
		}
		int[] temp = null;
		if (low == 0)
			temp = A;
		else {
			int[] A1 = new int[low];
			System.arraycopy(A, 0, A1, 0, low);
			int[] A2 = new int[A.length - low];
			System.arraycopy(A, low, A2, 0, A.length - low);
			if (elem < A1[0])
				temp = A2;
			else
				temp = A1;
		}

		low = 0;
		high = temp.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (temp[mid] == elem)
				return true;
			else if (temp[mid] > elem)
				high = mid - 1;
			else
				low = mid + 1;
		}
		return false;
	}
}
