package karate.chops.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PermutationGenerator {
    public static void main(String... strings) {
        PermutationGenerator.generatePermutations("237");
    }

    private static void generatePermutations(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.length() == 0)
            throw new IllegalArgumentException("invalid input");
        List<String> permutations = new ArrayList<>();
        permutationsHelper(phoneNumber, initializeKeypad(), permutations, 0, "");
        permutations.stream().forEach(System.out::println);
    }

    private static Map<Character, String> initializeKeypad() {
        Map<Character, String> keypad = new HashMap<>();
        keypad.put('2', "abc");
        keypad.put('3', "def");
        keypad.put('4', "ghi");
        keypad.put('7', "pqrs");
        return keypad;
    }

    private static void permutationsHelper(String phoneNumber, Map<Character, String> keypad, List<String> permutations, int level, String intermediate) {
        if (level == phoneNumber.length()) {
            permutations.add(intermediate);
            return;
        }

        for (int i = 0; i < keypad.get(phoneNumber.charAt(level)).length(); i++) {
            permutationsHelper(phoneNumber, keypad, permutations, level + 1, intermediate + keypad.get(phoneNumber.charAt(level)).charAt(i));
        }
    }
}