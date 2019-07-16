package karate.chops.searching;

public class FindFirstOccurrenceOfElem {
    public static void main(String... strings) {
        int[] sorted = new int[]{-14, -10, 2, 108, 108, 243, 285, 285, 285, 401};
        System.out.println(binarySearchFirstElem(sorted, 108));
        System.out.println(binarySearchFirstElem(sorted, 285));
        System.out.println(binarySearchFirstElem(sorted, 401));
        System.out.println(binarySearchFirstElem(sorted, -14));
        System.out.println(binarySearchFirstElem(sorted, -13));
        System.out.println(binarySearchFirstElem(sorted, 402));
        System.out.println(binarySearchFirstElem(sorted, 250));
    }

    private static int binarySearchFirstElem(int[] A, int num) {
        if (A == null || A.length == 0)
            throw new IllegalArgumentException("invalid input");

        int low = 0;
        int high = A.length - 1;
        int firstIndex = -1;
        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (A[mid] == num) {
                firstIndex = mid;
                high = mid - 1;
            } else if (A[mid] > num)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return firstIndex;
    }
}