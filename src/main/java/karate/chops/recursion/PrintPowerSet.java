package karate.chops.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintPowerSet {
    public static void main(String[] args) {
        printPowerSet("abc");
    }

    private static void printPowerSet(String src) {
        List<String> powerSet = new ArrayList<>();
        helper(src, powerSet, 0, "", new boolean[src.length()]);
        powerSet.stream().forEach(System.out::println);
    }

    private static void helper(String src, List<String> powerSet, int level, String intermediate, boolean[] visited) {
        if (level <= src.length()) {
            powerSet.add(intermediate);
        } else
            return;

        for (int i = level; i < src.length(); i++) {
            if (visited[i])
                continue;
            visited[i] = true;
            helper(src, powerSet, i, intermediate + src.charAt(i), visited);
            visited[i] = false;
        }
    }
}