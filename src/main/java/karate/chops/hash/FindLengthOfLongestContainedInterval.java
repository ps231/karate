package karate.chops.hash;

import java.util.*;

public class FindLengthOfLongestContainedInterval {
	public static void main(String[] arsg) {
		Integer[] A = new Integer[] { 5, 3, -2, 7, 9, 8, 1, 2, 0, -1, 6, 12, 11, 10 };
		System.out.println(findLengthOfLongestContainedInterval(Arrays.asList(A)));
	}

	private static int findLengthOfLongestContainedInterval(List<Integer> A) {
		int len = Integer.MIN_VALUE;
		if (A == null || A.isEmpty())
			return len;

		Set<Integer> lookup = new HashSet<Integer>(A);
		int count = 0;
		for (int num : A) {
			if (lookup.contains(num)) {
				int upper = num, lower = num - 1;
				while (lookup.contains(upper)) {
					lookup.remove(upper);
					count++;
					upper++;
				}

				while (lookup.contains(lower)) {
					lookup.remove(lower);
					count++;
					lower--;
				}
				len = Math.max(len, count);
				count = 0;
			}
		}
		return len;
	}

}
