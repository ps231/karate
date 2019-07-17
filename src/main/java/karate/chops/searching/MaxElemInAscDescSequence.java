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
        if (A == null || A.length == 0)
            throw new IllegalArgumentException("invalid input");

        int low = 0;
        int high = A.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int prev = (mid + A.length - 1) % A.length;
            int next = (mid + 1) % A.length;

            if (A[mid] > A[next] && A[mid] > A[prev])
                return A[mid];
            if (A[mid] > A[next])
                high = mid;
            else
                low = mid;
        }
        return -1;
    }
}