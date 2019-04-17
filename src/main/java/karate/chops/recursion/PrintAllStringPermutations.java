package karate.chops.recursion;

import java.util.*;

public class PrintAllStringPermutations {
    public static void main(String[] args) {
        printAllPermutations("abc")
                .stream()
                .forEach(System.out::println);
    }

    private static List<String> printAllPermutations(String src) {
        List<String> permutations = new ArrayList<>();
        helper(src, permutations, 0, "", new boolean[src.length()]);
        return permutations;
    }

    private static void helper(String src, List<String> permutations, int level, String intermediate, boolean[] visited) {
        if (level == src.length()) {
            permutations.add(intermediate);
            return;
        }
        for (int i = 0; i < src.length(); i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            helper(src, permutations, level + 1, intermediate + src.charAt(i), visited);
            visited[i] = false;
        }
    }
}