package karate.chops.recursion;

import java.util.*;

public class PrintAllStringPermutations {
	public static void main(String[] args) {
		printAllPermutations("abc")
			.stream()
			.forEach(System.out::println);
	}

	private static List<String> printAllPermutations(String src) {
		List<String> result = new ArrayList<String>();
		String intermediate = "";
		boolean[] visited = new boolean[src.length()];
		permutationsHelper(src, result, intermediate, visited, 0);
		return result;
	}

	private static void permutationsHelper(String src, List<String> result, String intermediate, boolean[] visited,
			int level) {
		if (src.length() == intermediate.length()) {
			result.add(intermediate);
			return;
		}

		for (int i = 0; i < src.length(); i++) {
			if (visited[i])
				continue;

			visited[i] = true;
			permutationsHelper(src, result, intermediate + src.charAt(i), visited, level + 1);
			visited[i] = false;
		}
	}
}
