package karate.chops.hash;

import java.util.*;

public class FindNearestRepitition {

	public static void main(String[] args) {
		String[] paragraph = new String[] { "a", "b", "c", "d", "a", "e", "d", "e" };
		System.out.println(findNearestRepitition(Arrays.asList(paragraph)));

		paragraph = new String[] { "a", "b", "c", "d", "a", "e", "d" };
		System.out.println(findNearestRepitition(Arrays.asList(paragraph)));

		System.out.println(findNearestRepitition(null));
	}

	private static int findNearestRepitition(List<String> paragraph) {
		int minDistance = Integer.MAX_VALUE;
		if (paragraph == null || paragraph.isEmpty())
			return minDistance;

		Map<String, Integer> wordIndexLookup = new HashMap<String, Integer>();
		for (int i = 0; i < paragraph.size(); i++) {
			if (wordIndexLookup.containsKey(paragraph.get(i))) {
				minDistance = Math.min(minDistance, i - wordIndexLookup.get(paragraph.get(i)) - 1);
				wordIndexLookup.put(paragraph.get(i), i);
			} else {
				wordIndexLookup.put(paragraph.get(i), i);
			}
		}
		return minDistance;
	}
}
