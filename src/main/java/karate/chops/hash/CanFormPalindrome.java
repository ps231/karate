package karate.chops.hash;

import java.util.*;

public class CanFormPalindrome {
	public static void main(String[] args) {
		System.out.println(canFormPalindrome("baaaba"));
		System.out.println(canFormPalindrome("ab"));
		System.out.println(canFormPalindrome("bbbbaac"));
		System.out.println(canFormPalindrome("aabbccdddde"));
		System.out.println(canFormPalindrome(""));
	}

	private static boolean canFormPalindrome(String s) {
		if (s == null || s.length() == 0)
			return false;
		if (s.length() == 1)
			return true;

		Map<Character, Integer> charFreq = new HashMap<Character, Integer>();
		for (int i = 0; i < s.length(); i++) {
			if (charFreq.containsKey(s.charAt(i))) {
				charFreq.put(s.charAt(i), charFreq.get(s.charAt(i)) + 1);
			} else {
				charFreq.put(s.charAt(i), 1);
			}
		}

		int noOfOdds = 0;
		for (int value : charFreq.values()) {
			if (value % 2 != 0)
				noOfOdds++;
		}

		return noOfOdds <= 1 ? true : false;
	}

}
