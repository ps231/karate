package karate.chops.strings;

import java.util.*;

public class RemoveConsecutiveVowels {
	public static void main(String[] arsg) {
		System.out.println(removeConsecutiveVowels("geeks for geeks"));
		System.out.println(removeConsecutiveVowels("heeeelloooo how areeee yoooouuuu?"));
		System.out.println(removeConsecutiveVowels("queue"));
		System.out.println(removeConsecutiveVowels(""));
	}

	private static String removeConsecutiveVowels(String s) {
		if (s == null || s.isEmpty())
			return s;
		StringBuilder sb = new StringBuilder(s);
		Set<Character> vowels = new HashSet<Character>();
		vowels.add('a');
		vowels.add('e');
		vowels.add('i');
		vowels.add('o');
		vowels.add('u');
		int swapIndex = 0;
		boolean prevVowel = false;
		int i = 0;
		for (; i < sb.length(); i++) {
			if (vowels.contains(sb.charAt(i))) {
				if (prevVowel)
					swapIndex++;
				else {
					prevVowel = true;
					sb.setCharAt(i - swapIndex, sb.charAt(i));
				}
			} else {
				prevVowel = false;
				sb.setCharAt(i - swapIndex, sb.charAt(i));
			}
		}
		return sb.substring(0, i - swapIndex);
	}
}
