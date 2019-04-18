package karate.chops.searching;

public class FindRange {
    public static void main(String[] args) {
        int[] sorted = new int[]{1, 2, 2, 4, 4, 4, 7, 11, 11, 11, 13};
        System.out.println("Range for 4 is: " + findRange(sorted, 4));
        System.out.println("Range for 11 is: " + findRange(sorted, 11));
        System.out.println("Range for 13 is: " + findRange(sorted, 13));
        System.out.println("Range for 1 is: " + findRange(sorted, 1));
        System.out.println("Range for 12 is: " + findRange(sorted, 12));
    }

    private static Pair findRange(int[] A, int key) {
        if (A == null || A.length == 0)
            return new Pair(-1, -1);
        return new Pair(findOccurrence(A, key, true), findOccurrence(A, key, false));
    }

    private static int findOccurrence(int[] A, int key, boolean findFirst) {
        int low = 0;
        int high = A.length - 1;
        int occurrence = -1;

        while (low <= high) {
            int mid = low + ((high - low) / 2);
            if (A[mid] == key) {
                occurrence = mid;
                if (findFirst)
                    high = mid - 1;
                else
                    low = mid + 1;
            } else if (A[mid] > key)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return occurrence;
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
