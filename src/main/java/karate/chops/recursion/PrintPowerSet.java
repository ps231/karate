package karate.chops.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintPowerSet {
    public static void main(String[] args) {
        PrintPowerSet.printPowerSet("abc");
    }

    private static void printPowerSet(String src) {
        if (src == null || src.length() == 0)
            throw new IllegalArgumentException("invalid input");
        List<String> powerSet = new ArrayList<>();
        helper(src, powerSet, new boolean[src.length()], "", 0);
        powerSet.stream().forEach(System.out::println);
    }

    private static void helper(String src, List<String> powerSet, boolean[] visited, String intermediate, int level) {
        if (level > src.length())
            return;
        powerSet.add(intermediate);
        for (int i = level; i < src.length(); i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            helper(src, powerSet, visited, intermediate + src.charAt(i), i);
            visited[i] = false;
        }
    }
}