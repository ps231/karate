package karate.chops.graphs;

public class CountIslandsOfOnes {
    public static void main(String... args) {
        System.out.println(countIslandsOf1(new int[][]{{0, 1, 1}, {1, 0, 1}, {0, 0, 0}}));
        System.out.println(countIslandsOf1(new int[][]{{0, 1, 1, 0}, {1, 1, 1, 0}, {0, 0, 0, 0}, {1, 0, 0, 0}}));
    }

    private static int countIslandsOf1(int[][] matrix) {
        if (matrix == null)
            return -1;

        int count = 0;
        boolean[][] visited = new boolean[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 1 && !visited[i][j]) {
                    clubAdjoining1s(matrix, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    private static void clubAdjoining1s(int[][] matrix, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i >= matrix.length || j >= matrix[0].length || matrix[i][j] == 0 || visited[i][j])
            return;

        if (matrix[i][j] == 1 && !visited[i][j]) {
            visited[i][j] = true;
            clubAdjoining1s(matrix, i, j + 1, visited);
            clubAdjoining1s(matrix, i, j - 1, visited);
            clubAdjoining1s(matrix, i - 1, j, visited);
            clubAdjoining1s(matrix, i + 1, j, visited);
        }
    }
}
