package karate.chops.searching;

public class FindElemInSortedArray {
    public static void main(String[] args) {
        System.out.println(FindElemInSortedArray.getIndex(new int[]{5, 10, 12, 13, 17, 21}, 0));
        System.out.println(FindElemInSortedArray.getIndex(new int[]{5, 10, 12, 13, 17, 21}, 22));
        System.out.println(FindElemInSortedArray.getIndex(new int[]{5, 10, 12, 13, 17, 21}, 10));
        System.out.println(FindElemInSortedArray.getIndex(new int[]{5, 10, 12, 13, 17, 21}, 15));
        System.out.println(FindElemInSortedArray.getIndex(new int[]{5, 10, 12, 13, 17, 21}, 21));
        System.out.println(FindElemInSortedArray.getIndex(new int[]{5, 10, 12, 13, 17, 21}, 5));
    }

    private static int getIndex(int[] A, int num) {
        if (A == null || A.length == 0)
            throw new IllegalArgumentException("invalid input");

        int low = 0;
        int high = A.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (A[mid] == num)
                return mid;
            if (A[mid] < num)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }
}
