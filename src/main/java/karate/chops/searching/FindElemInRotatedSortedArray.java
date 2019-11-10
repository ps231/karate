package karate.chops.searching;

public class FindElemInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(findElemInRotatedSortedArray(new int[]{35, 38, 43, 5, 12, 17, 19}, 19));
        System.out.println(findElemInRotatedSortedArray(new int[]{19, 35, 38, 43, 5, 12, 17}, 19));
        System.out.println(findElemInRotatedSortedArray(new int[]{17, 19, 35, 38, 43, 5, 12}, 19));
        System.out.println(findElemInRotatedSortedArray(new int[]{12, 17, 19, 35, 38, 43, 5}, 19));
        System.out.println(findElemInRotatedSortedArray(new int[]{5, 12, 17, 19, 35, 38, 43}, 19));
        System.out.println(findElemInRotatedSortedArray(new int[]{43, 5, 12, 17, 19, 35, 38}, 19));
        System.out.println(findElemInRotatedSortedArray(new int[]{38, 43, 5, 12, 17, 19, 35}, 19));
        System.out.println(findElemInRotatedSortedArray(new int[]{35, 38, 43, 5, 12, 17, 19}, 18));
        System.out.println(findElemInRotatedSortedArray(new int[]{19, 35, 38, 43, 5, 12, 17}, 18));
        System.out.println(findElemInRotatedSortedArray(new int[]{17, 19, 35, 38, 43, 5, 12}, 18));
        System.out.println(findElemInRotatedSortedArray(new int[]{12, 17, 19, 35, 38, 43, 5}, 18));
        System.out.println(findElemInRotatedSortedArray(new int[]{5, 12, 17, 19, 35, 38, 43}, 18));
        System.out.println(findElemInRotatedSortedArray(new int[]{43, 5, 12, 17, 19, 35, 39}, 18));
        System.out.println(findElemInRotatedSortedArray(new int[]{38, 43, 5, 12, 17, 19, 35}, 18));
    }

    private static boolean findElemInRotatedSortedArray(int[] A, int num) {
        if (A == null || A.length == 0)
            return false;

        int low = 0;
        int high = A.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);

            if (A[mid] == num)
                return true;

            if (A[high] > A[mid]) {
                if (A[mid] < num && A[high] >= num)
                    low = mid + 1;
                else
                    high = mid - 1;
            } else {
                if (A[mid] > num && A[low] <= num)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }
        return false;
    }
}
