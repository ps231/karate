package karate.chops.searching;

public class SearchASorted2DMatrix {
    public static void main(String[] arsg) {
        int[][] A = new int[][]{
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {27, 29, 37, 48},
                {32, 33, 39, 50}
        };
        System.out.println(hasNumber(A, 28));
        System.out.println(hasNumber(A, 35));
        System.out.println(hasNumber(A, 30));
        System.out.println(hasNumber(A, 52));
        System.out.println(hasNumber(A, 5));
        System.out.println(hasNumber(A, 39));
        System.out.println(hasNumber(A, 50));
        System.out.println(hasNumber(A, 10));
    }

    private static boolean hasNumber(int[][] matrix, int num) {
        if (matrix == null || (matrix.length == 0 && matrix[0].length == 0))
            throw new IllegalArgumentException("invalid input");

        if (num < matrix[0][0] || num > matrix[matrix.length - 1][matrix[0].length - 1])
            return false;

        int row = 0;
        int col = matrix[0].length - 1;
        while (row >= 0 && row < matrix.length && col >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == num)
                return true;
            if (matrix[row][col] > num)
                col--;
            else
                row++;
        }
        return false;
    }
}