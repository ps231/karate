package karate.chops.test;

import java.util.ArrayList;
import java.util.List;

public class PermuteAnArrayAsPerGivenPermutation {

	public static void main(String[] args) {
		List<Integer> P = new ArrayList<Integer>();
		P.add(2);
		P.add(0);
		P.add(1);
		P.add(3);

		List<Integer> A = new ArrayList<Integer>();
		A.add(30);
		A.add(10);
		A.add(20);
		A.add(5);

		permute(P, A);

		A.stream().forEach(System.out::println);
		P = new ArrayList<Integer>();
		P.add(2);
		P.add(0);
		P.add(1);
		P.add(4);
		P.add(3);

		A = new ArrayList<Integer>();
		A.add(30);
		A.add(10);
		A.add(20);
		A.add(5);
		A.add(18);

		permute(P, A);
		A.stream().forEach(System.out::println);
	}

	private static void permute(List<Integer> P, List<Integer> A) {
		for (int i = 0; i < A.size(); i++) {
			int temp = 0;
			int j = i;
			int earlier = A.get(i);
			int nextIndex = 0;
			while (P.get(j) != -1) {
				temp = A.get(P.get(j));
				A.set(P.get(j), earlier);
				nextIndex = P.get(j);
				P.set(j, -1);
				j = nextIndex;
				earlier = temp;
			}
		}
	}
}
