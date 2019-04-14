package karate.chops.strings;

import java.util.*;

public class FindExtraCharacter {
	public static void main(String[] args) {
		System.out.println(findExtraCharacter("abcd", "abc"));
		System.out.println(findExtraCharacter("aabbccd", "aabbccdzyz"));
		System.out.println(findExtraCharacter("aaccdddddef", "aaccdddddef"));
		System.out.println(findExtraCharacter("jkllm", "jklllm"));
		System.out.println(findExtraCharacter("abc", "xyzl"));
		System.out.println(findExtraCharacter("a", "ab"));
	}

	private static Character findExtraCharacter(String s1, String s2) {
		if (s1 == null || s1.length() == 0 || s2 == null || s2.length() == 0
				|| Math.abs(s1.length() - s2.length()) != 1)
			return null;

		if (s1.length() > s2.length()) {
			String temp = s1;
			s1 = s2;
			s2 = temp;
		}

		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();

		Map<Character, Integer> charFreq = new HashMap<Character, Integer>();
		for (int i = 0; i < s2.length(); i++) {
			if (!charFreq.containsKey(s2.charAt(i))) {
				charFreq.put(s2.charAt(i), 1);
			} else {
				charFreq.put(s2.charAt(i), charFreq.get(s2.charAt(i)) + 1);
			}
		}

		for (int i = 0; i < s1.length() && !charFreq.isEmpty(); i++) {
			if (!charFreq.containsKey(s1.charAt(i)))
				return null;
			if (charFreq.get(s1.charAt(i)) == 1)
				charFreq.remove(s1.charAt(i));
			else
				charFreq.put(s1.charAt(i), charFreq.get(s1.charAt(i)) - 1);
		}

		if (charFreq.isEmpty())
			return null;
		else if (charFreq.entrySet().iterator().next().getValue() != 1)
			return null;
		else
			return charFreq.entrySet().iterator().next().getKey();

	}
}
