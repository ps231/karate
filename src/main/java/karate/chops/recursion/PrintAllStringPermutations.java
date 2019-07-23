package karate.chops.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintAllStringPermutations {
    public static void main(String[] args) {
        PrintAllStringPermutations.printAllPermutations("agsbc")
                .stream()
                .forEach(System.out::println);
    }

    private static List<String> printAllPermutations(String s) {
        if (s == null || s.length() == 0)
            throw new IllegalArgumentException("invalid input");
        List<String> combinations = new ArrayList<>();
        helper(s, combinations, new boolean[s.length()], "", 0);
        return combinations;
    }

    private static void helper(String s, List<String> combinations, boolean[] visited, String intermediate, int level) {
        if (level == s.length()) {
            combinations.add(intermediate);
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            helper(s, combinations, visited, intermediate + s.charAt(i), level + 1);
            visited[i] = false;
        }
    }
}