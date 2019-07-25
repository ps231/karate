package karate.chops.recursion;

import java.util.ArrayList;
import java.util.List;

// "ab" -> "ab" "aB" "Ab" "AB"
public class PrintAllStringCombinationsWithBothCases {

    public static void main(String[] args) {
        printCombinations(getCombinationsInAllCase(null));
        printCombinations(getCombinationsInAllCase("ab"));
        printCombinations(getCombinationsInAllCase("abc"));
    }

    private static void printCombinations(List<String> combinations) {
        if (combinations == null || combinations.isEmpty()) {
            System.out.println("Invalid input");
            return;
        }
        combinations.stream().forEach(System.out::println);
        System.out.println();
    }

    private static List<String> getCombinationsInAllCase(String s) {
        if (s == null || s.length() == 0)
            return null;

        List<String> combinations = helper(s, 0);
        return combinations;
    }

    private static List<String> helper(String s, int level) {
        if (level == s.length() - 1) {
            List<String> combinations = new ArrayList<>();
            Character c = s.charAt(level);
            combinations.add("" + c);
            combinations.add("" + Character.toUpperCase(c));
            return combinations;
        }

        List<String> interimCombinations = helper(s, level + 1);
        Character c = s.charAt(level);
        List<String> combinations = new ArrayList<>();
        for (String temp : interimCombinations) {
            combinations.add(c + temp);
            combinations.add(Character.toUpperCase(c) + temp);
        }
        return combinations;
    }
}