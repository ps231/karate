package karate.chops.hash;

import java.util.*;

public class SmallestSubarrayCoveringAllValues {

	public static void main(String[] args) {
		String[] paragraph = new String[] { "a", "b", "c", "d", "e", "x", "l", "m", "y", "k", "x", "y", "g" };
		String[] keywords = new String[] { "x", "y" };
		System.out.println(smallestSubArrayCoveringAllValues(Arrays.asList(paragraph),
				new HashSet<String>(Arrays.asList(keywords))));

		paragraph = new String[] { "apple", "banana", "apple", "apple", "dog", "cat", "apple", "dog", "banana", "apple",
				"cat", "dog" };
		keywords = new String[] { "banana", "cat" };
		System.out.println(smallestSubArrayCoveringAllValues(Arrays.asList(paragraph),
				new HashSet<String>(Arrays.asList(keywords))));
	}

	private static int smallestSubArrayCoveringAllValues(List<String> paragraph, Set<String> keywords) {
		int minDistance = Integer.MAX_VALUE;
		if (paragraph == null || paragraph.size() == 0 || keywords == null || keywords.size() == 0
				|| keywords.size() > paragraph.size())
			return minDistance;

		Set<String> current = new HashSet<>(keywords);
		int start = 0, end = 0;
		boolean foundFirst = false;

		for (int i = 0; i < paragraph.size(); i++) {
			if (!current.isEmpty() && current.contains(paragraph.get(i))) {
				if (!foundFirst) {
					foundFirst = true;
					start = i;
				}
				current.remove(paragraph.get(i));
				if (current.isEmpty()) {
					end = i;
					minDistance = Math.min(minDistance, end - start - 1); 
					foundFirst = false;
					current = new HashSet<>(keywords);
					i--;
				}
			}
		}

		return minDistance;
	}
}
