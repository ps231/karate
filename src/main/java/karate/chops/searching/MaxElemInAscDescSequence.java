package karate.chops.searching;

public class MaxElemInAscDescSequence {
    public static void main(String... strings) {
        System.out.println(maxElemInSeq(new int[]{3, 6, 7, 3, 0, -2}));
        System.out.println(maxElemInSeq(new int[]{10, 25, 30, 28, 26, 23, 15, 5}));
        System.out.println(maxElemInSeq(new int[]{10, 25, 30, 35, 38, 40, 42, 5}));
        System.out.println(maxElemInSeq(new int[]{10, 25, 24, 23, 22, 21, 15, 5}));
        System.out.println(maxElemInSeq(new int[]{10, 9, 5}));
        System.out.println(maxElemInSeq(null));
        System.out.println(maxElemInSeq(new int[]{}));
    }

    private static int maxElemInSeq(int[] A) {
        int result = -1;
        if (A == null || A.length == 0)
            return result;

        int low = 0;
        int high = A.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (mid == 0 && A[mid] > A[mid + 1]) {
                result = A[mid];
                break;
            } else if (A[mid] > A[mid + 1] && A[mid] > A[mid - 1]) {
                result = A[mid];
                break;
            } else if (A[mid] < A[mid + 1])
                low = mid + 1;
            else high = mid;
        }

        return result;
    }

//	private static int maxElemInSeq(int[] A) {
//		if (A == null || A.length == 0)
//			return Integer.MIN_VALUE;
//
//		int low = 0;
//		int high = A.length - 1;
//
//		while (low < high) {
//			int mid = low + (high - low) / 2;
//			if (A[mid] > A[mid + 1])
//				high = mid;
//			else if (A[mid] < A[mid + 1])
//				low = mid + 1;
//		}
//		return A[low];
//	}
}