package karate.chops.test;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        printResult(drawPascalsTriangle(0));
        printResult(drawPascalsTriangle(1));
        printResult(drawPascalsTriangle(2));
        printResult(drawPascalsTriangle(3));
        printResult(drawPascalsTriangle(4));
        printResult(drawPascalsTriangle(5));
        printResult(drawPascalsTriangle(6));
    }

    private static void printResult(List<List<Integer>> pascalsTriangle) {
        if (pascalsTriangle == null) {
            System.out.println("cannot draw the triangle");
        } else {
            for (List<Integer> row : pascalsTriangle) {
                for (int col : row)
                    System.out.print(col + " ");
                System.out.println("");
            }
        }
        System.out.println("--");
    }

    public static List<List<Integer>> drawPascalsTriangle(int n) {
        if (n <= 0)
            return null;

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<Integer> intermediate = new ArrayList<>();
            if (i == 0)
                intermediate.add(1);
            else {
                for (int j = 0; j <= i; j++) {
                    if (j == 0 || j == i) {
                        intermediate.add(1);
                    } else {
                        intermediate.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                    }
                }
            }
            result.add(intermediate);
        }
        return result;
    }
}