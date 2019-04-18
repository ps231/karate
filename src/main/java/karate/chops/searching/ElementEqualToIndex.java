package karate.chops.searching;

public class ElementEqualToIndex {
    public static void main(String... strings) {
        System.out.println(elemEqualToIndex(new int[]{-2, 0, 2, 3, 6, 7, 9}));
        System.out.println(elemEqualToIndex(new int[]{-2, 0, 2, 6, 7, 9}));
        System.out.println(elemEqualToIndex(new int[]{-2, 0, 6, 7, 9}));
        System.out.println(elemEqualToIndex(new int[]{-2, -1, 1, 2, 3, 5}));
    }

    private static int elemEqualToIndex(int[] A) {
        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (A[mid] == mid)
                return mid;
            else if (A[mid] > mid)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
    }
}
