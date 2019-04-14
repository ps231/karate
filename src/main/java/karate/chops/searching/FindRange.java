package karate.chops.searching;

public class FindRange {
	public static void main(String[] args) {
		int[] sorted = new int[] { 1, 2, 2, 4, 4, 4, 7, 11, 11, 11, 13 };
		System.out.println(findRange(sorted, 4));
		System.out.println(findRange(sorted, 11));
		System.out.println(findRange(sorted, 13));
		System.out.println(findRange(sorted, 1));
		System.out.println(findRange(sorted, 12));
	}

//	private static Pair findRange(int[] A, int key) {
//		if (A == null || A.length == 0)
//			return null;
//
//		int first = findFirst(A, key);
//		if (first == -1)
//			return new Pair(first, first);
//		int last = findLast(A, key);
//		return new Pair(first, last);
//	}
//
//	private static int findFirst(int[] A, int key) {
//		int low = 0, high = A.length - 1, result = -1;
//		while (low <= high) {
//			int mid = low + (high - low) / 2;
//			if (A[mid] < key)
//				low = mid + 1;
//			else if (A[mid] > key)
//				high = mid - 1;
//			else {
//				result = mid;
//				high = mid - 1;
//			}
//		}
//
//		return result;
//	}
//
//	private static int findLast(int[] A, int key) {
//		int low = 0, high = A.length - 1, result = -1;
//		while (low <= high) {
//			int mid = low + (high - low) / 2;
//			if (A[mid] < key)
//				low = mid + 1;
//			else if (A[mid] > key)
//				high = mid - 1;
//			else {
//				result = mid;
//				low = mid + 1;
//			}
//		}
//
//		return result;
//	}
//
	
	private static Pair findRange(int[]A,int num) {
		Pair p = new Pair(-1,-1);
		if(A==null||A.length==0)
			return p;
		p.start = findFirst(A,num);
		p.end = findLast(A,num);
		return p;
	}
	
	private static int findFirst(int[]A, int num) {
		int low=0;
		int high = A.length-1;
		
		int index=-1;
		while(low<=high) {
			int mid = low + (high-low)/2;
			if(A[mid]<num)
				low=mid+1;
			else if (A[mid]>num)
				high=mid-1;
			else {
				index=mid;
				high=mid-1;
			}
				
		}
		return index;
	}
	
	private static int findLast(int[]A, int num) {
		int low=0;
		int high = A.length-1;
		
		int index=-1;
		while(low<=high) {
			int mid = low + (high-low)/2;
			if(A[mid]<num)
				low=mid+1;
			else if (A[mid]>num)
				high=mid-1;
			else {
				index=mid;
				low=mid+1;
			}
				
		}
		return index;
		
	}
}

class Pair {
	int start;
	int end;

	Pair(int s, int e) {
		start = s;
		end = e;
	}

	public String toString() {
		return "start: " + start + ", end: " + end;
	}
}
