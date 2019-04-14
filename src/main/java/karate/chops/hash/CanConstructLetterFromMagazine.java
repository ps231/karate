package karate.chops.hash;

import java.util.*;

public class CanConstructLetterFromMagazine {

	public static void main(String[] args) {
		System.out.println(canConstructLetterFromMagazine("cdeff", "aabbccddddeff"));
		System.out.println(canConstructLetterFromMagazine("cdeffg", "aabbccddddeff"));
		System.out.println(canConstructLetterFromMagazine("abc", "ab"));
	}

	private static boolean canConstructLetterFromMagazine(String letter, String magazine) {
		if (letter == null || letter.length() == 0 || magazine == null || magazine.length() == 0
				|| letter.length() > magazine.length())
			return false;

		Map<Character, Integer> letterFreq = new HashMap<Character, Integer>();

		for (int i = 0; i < letter.length(); i++) {
			if (letterFreq.containsKey(letter.charAt(i)))
				letterFreq.put(letter.charAt(i), letterFreq.get(letter.charAt(i)) + 1);
			else
				letterFreq.put(letter.charAt(i), 1);
		}

		for (int i = 0; i < magazine.length(); i++) {
			if (letterFreq.containsKey(magazine.charAt(i))) {
				if (letterFreq.get(magazine.charAt(i)) == 1)
					letterFreq.remove(magazine.charAt(i));
				else
					letterFreq.put(magazine.charAt(i), letterFreq.get(magazine.charAt(i)) - 1);
			}
			if (letterFreq.isEmpty())
				return true;
		}

		return false;
	}
}
