package karate.chops.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintPowerSet {
	public static void main(String[] args) {
//		printPowerSet("abc").stream().forEach(System.out::println);
		printPowerSet("abc");
	}

//	private static List<String> printPowerSet(String src) {
//		List<String> result = new ArrayList<String>();
//		String intermediate = "";
//		boolean[] visited = new boolean[src.length()];
//		powerSetHelper(src, result, intermediate, visited, 0);
//		return result;
//	}
//
//	private static void powerSetHelper(String src, List<String> result, String intermediate, boolean[] visited,
//			int level) {
//		if (level <= src.length()) {
//			result.add(level + ", " + intermediate);
//		} else
//			return;
//
//		for (int i = level; i < src.length(); i++) {
//			if (visited[i])
//				continue;
//
//			visited[i] = true;
//			powerSetHelper(src, result, intermediate + src.charAt(i), visited, i);
//			visited[i] = false;
//		}
//	}
	private static void printPowerSet(String s) {

		if (s == null || s.length() == 0)
			return;
		boolean[] visited = new boolean[s.length()];
		helper(s, "", 0, visited);
	}

	private static void helper(String s, String intermediate, int level, boolean[] visited) {
		if (level > s.length())
			return;

		System.out.println(intermediate);
		for (int i = level; i < s.length(); i++) {
			if (visited[i])
				continue;
			visited[i] = true;
			helper(s, intermediate + s.charAt(i), i, visited);
			visited[i] = false;
		}
	}
}
