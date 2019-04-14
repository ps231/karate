package karate.chops.heaps;

import java.util.*;

import karate.chops.linkedlist.ListNodeHelper;
import karate.chops.linkedlist.ListNode;

public class SortKIncreasingDecreasingList {
	public static void main(String[] rags) {
		Integer[] inputArray = new Integer[] { 57, 131, 493, 294, 221, 339, 418, 452, 442, 190 };
		List<Integer> input = Arrays.asList(inputArray);
		sortKIncreasingDecreasing(input).stream().forEach(System.out::println);
	}

	private static List<Integer> sortKIncreasingDecreasing(List<Integer> input) {
		if (input.isEmpty())
			return null;
		if (input.size() == 1)
			return input;
		boolean isIncreasing = true;
		int start = 0;
		List<List<Integer>> sortedSublists = new ArrayList<List<Integer>>();
		for (int i = 1; i < input.size(); i++) {
			while (i < input.size() && input.get(i) > input.get(i - 1) && isIncreasing)
				i++;
			sortedSublists.add(input.subList(start, i));
			isIncreasing = false;
			start = i;
			i++;
			while (i < input.size() && input.get(i) < input.get(i - 1) && !isIncreasing)
				i++;
			List<Integer> reversed = input.subList(start, i);
			Collections.reverse(reversed);
			sortedSublists.add(reversed);
			isIncreasing = true;
			start = i;
		}

		List<ListNode> linkedInputs = ListNodeHelper.createList(sortedSublists);

		return MergeKSortedLists.mergeKSortedLists(linkedInputs);
	}
}
