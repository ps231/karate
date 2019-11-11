package karate.chops.test;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle {
    public static void main(String[] args) {
        print(pascalsTriangle(1));
        print(pascalsTriangle(2));
        print(pascalsTriangle(3));
        print(pascalsTriangle(4));
        print(pascalsTriangle(5));
        print(pascalsTriangle(6));
        print(pascalsTriangle(0));
    }

    private static List<List<Integer>> pascalsTriangle(int rows) {
        if (rows <= 0 || rows > 100)
            throw new IllegalArgumentException("invalid input");
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            List<Integer> intermediate = new ArrayList<>();
            if (i == 0) {
                intermediate.add(1);
                result.add(intermediate);
                continue;
            } else if (i == 1) {
                intermediate.add(1);
                intermediate.add(1);
                result.add(intermediate);
                continue;
            } else {
                intermediate.add(1);
                for (int j = 0; j < i - 1; j++)
                    intermediate.add(result.get(i - 1).get(j) + result.get(i - 1).get(j + 1));
                intermediate.add(1);
                result.add(intermediate);
            }
        }
        return result;
    }

    private static void print(List<List<Integer>> result) {
        for (List<Integer> intermediate : result) {
            for (int i : intermediate)
                System.out.print(i + " ");
            System.out.println();
        }
    }
}
