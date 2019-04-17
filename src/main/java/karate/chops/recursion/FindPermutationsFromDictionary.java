package karate.chops.recursion;

import java.util.*;

public class FindPermutationsFromDictionary {

    public static void main(String... strings) {
        FindPermutationsFromDictionary g = new FindPermutationsFromDictionary();
        Set<String> dictionary = getDictionary();
        g.generatePermutations("234", dictionary);
    }

    private void generatePermutations(String phoneNumber, Set<String> dictionary) {
        List<String> foundPermutations = new ArrayList<>();
        permutationHelper(phoneNumber, initializeKeypad(), dictionary, foundPermutations, 0, "");
        foundPermutations.stream().forEach(System.out::println);
    }

    private void permutationHelper(String phoneNumber, Map<Character, String> keypad, Set<String> dictionary, List<String> foundPermutations, int level, String intermediate) {
        if (level == phoneNumber.length()) {
            if (dictionary.contains(intermediate)) {
                foundPermutations.add(intermediate);
            }
            return;
        }
        for (int i = 0; i < phoneNumber.length(); i++) {
            permutationHelper(phoneNumber, keypad, dictionary, foundPermutations, level + 1, intermediate + keypad.get(phoneNumber.charAt(level)).charAt(i));
        }
    }

    private Map<Character, String> initializeKeypad() {
        Map<Character, String> keypad = new HashMap<Character, String>();
        keypad.put('2', "abc");
        keypad.put('3', "def");
        keypad.put('4', "ghi");
        return keypad;
    }

    private static Set<String> getDictionary() {
        Set<String> dictionary = new HashSet<String>();
        dictionary.add("afi");
        dictionary.add("ceh");
        dictionary.add("bei");
        dictionary.add("adi");
        dictionary.add("bdg");
        dictionary.add("a");
        dictionary.add("be");
        dictionary.add("cfh");
        dictionary.add("cf");
        return dictionary;
    }
}