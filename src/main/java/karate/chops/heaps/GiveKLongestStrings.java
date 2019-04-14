package karate.chops.heaps;

import java.util.*;

public class GiveKLongestStrings {
	public static void main(String[] args) {
		List<String> input = new ArrayList<String>();
		input.add("abcdef");
		input.add("abcd");
		input.add("ab");
		input.add("cde");
		input.add("afhgi");

		kLongest(input, 2).stream().forEach(System.out::println);
	}

	private static List<String> kLongest(List<String> input, int k) {
		if (input.isEmpty() || k <= 0)
			return input;

		List<String> result = new ArrayList<String>();
		PriorityQueue<String> minHeap = new PriorityQueue<String>(new Comparator<String>() {
			public int compare(String s1, String s2) {
				return Integer.compare(s1.length(), s2.length());
			}
		});

		for (String s : input) {
			if (minHeap.size() != k) {
				minHeap.offer(s);
			} else {
				if (s.length() > minHeap.peek().length()) {
					minHeap.poll();
					minHeap.offer(s);
				}
			}
		}

		result.addAll(minHeap);
		return result;
	}
}
