package karate.chops.sorting;

import java.util.*;

public class Intersection {
	public static void main(String... strings) {
		List<Integer> intersection = intersection(Arrays.asList(new Integer[] { 2, 3, 3, 5, 5, 6, 7, 7, 8, 12 }),
				Arrays.asList(new Integer[] { 5, 5, 6, 8, 8, 9, 10, 10 }));
		intersection.stream().forEach(System.out::println);
	}

//	private static List<Integer> intersection(List<Integer>A, List<Integer>B){
//		Set<Integer> set = new HashSet<Integer>();
//		int i=0, j=0;
//		
//		while(i<A.size() && j<B.size()) {
//			if(A.get(i) == B.get(j)) {
//				set.add(A.get(i));
//				i++;
//				j++;
//			} else if(A.get(i)<B.get(j))
//				i++;
//			else
//				j++;
//		}
//		
//		
//		return new ArrayList(set);
//	} 

	private static List<Integer> intersection(List<Integer> A, List<Integer> B) {
		List<Integer> intersection = new ArrayList<Integer>();

		if (A == null || B == null || A.isEmpty() || B.isEmpty())
			return intersection;

		int i = 0, j = 0, count = 0;
		while (i < A.size() && j < B.size()) {
			if (A.get(i) == B.get(j)) {
				if (intersection.isEmpty()) {
					intersection.add(A.get(i));
					count++;
				} else if (intersection.get(count - 1) != A.get(i)) {
					intersection.add(A.get(i));
					count++;
				}
				i++;
				j++;

			} else if (A.get(i) > B.get(j)) {
				j++;
			} else {
				i++;
			}
		}
		return intersection;
	}

}
