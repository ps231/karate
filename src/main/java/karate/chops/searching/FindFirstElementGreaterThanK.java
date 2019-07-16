package karate.chops.searching;

public class FindFirstElementGreaterThanK {
    public static void main(String... strings) {
        int[] sorted = new int[]{-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
        System.out.println(findFirstElementGreaterThanK(sorted, 108));
        System.out.println(findFirstElementGreaterThanK(sorted, 285));
        System.out.println(findFirstElementGreaterThanK(sorted, 401));
        System.out.println(findFirstElementGreaterThanK(sorted, -10));
        System.out.println(findFirstElementGreaterThanK(sorted, -18));
        System.out.println(findFirstElementGreaterThanK(sorted, 405));
        System.out.println(findFirstElementGreaterThanK(sorted, 295));
        System.out.println(findFirstElementGreaterThanK(sorted, 245));
    }

    private static int findFirstElementGreaterThanK(int[] A, int k) {
        if (A == null || A.length == 0)
            throw new IllegalArgumentException("invalid input");

        if (k < A[0])
            return A[0];
        if (k > A[A.length - 1])
            return -1;

        int lastIndex = getLastOccurrence(A, k);
        if (lastIndex == A.length - 1)
            return -1;
        return A[lastIndex + 1];
    }

    private static int getLastOccurrence(int[] A, int k) {
        int low = 0;
        int high = A.length - 1;
        int lastIndex = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (A[mid] == k) {
                lastIndex = mid;
                low = mid + 1;
            } else if (A[mid] < k)
                low = mid + 1;
            else
                high = mid - 1;
        }
        if (lastIndex == -1)
            return high;
        return lastIndex;
    }
}