package karate.chops.recursion;

import java.util.*;

public class FindPermutationsFromDictionary {
	private Map<Character, String> keypad = new HashMap<Character, String>();

	public static void main(String... strings) {
		FindPermutationsFromDictionary g = new FindPermutationsFromDictionary();
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
		g.generatePermutations("234", dictionary);
	}

	private void generatePermutations(String phoneNumber, Set<String> dictionary) {
		List<String> combinations = new ArrayList<>();
		keypad.put('2', "abc");
		keypad.put('3', "def");
		keypad.put('4', "ghi");

		permutationHelper(phoneNumber, keypad, new char[phoneNumber.length()], 0, combinations, dictionary);
		combinations.stream().forEach(System.out::println);
	}

	private void permutationHelper(String phNo, Map<Character, String> keypad, char[] temp, int level,
			List<String> combinations, Set<String> dictionary) {
		if (phNo.length() == level) {
			if(dictionary.contains(String.valueOf(temp)))
				combinations.add(String.valueOf(temp));
		} else {
			for (int i = 0; i < keypad.get(phNo.charAt(level)).length(); i++) {
				temp[level] = keypad.get(phNo.charAt(level)).charAt(i);
				permutationHelper(phNo, keypad, temp, level + 1, combinations, dictionary);
			}
		}
	}
}
