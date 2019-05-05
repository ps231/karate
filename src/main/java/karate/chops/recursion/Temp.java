package karate.chops.recursion;

import java.util.*;

public class Temp {
//	keypad permutations
//	public static void main(String... strings) {
//		generatePermutations("234", null);
//	}
//
//	private static void generatePermutations(String phoneNumber, Set<String> dictionary) {
//		List<String> combinations = new ArrayList<>();
//		Map<Character, String> keypad = new HashMap<Character, String>();
//		keypad.put('2', "abc");
//		keypad.put('3', "def");
//		keypad.put('4', "ghi");
//
//		permutationHelper(phoneNumber, keypad, "", 0, combinations, dictionary);
//		combinations.stream().forEach(System.out::println);
//	}
//
//	private static void permutationHelper(String phNo, Map<Character, String> keypad, String intermediate, int level,
//			List<String> combinations, Set<String> dictionary) {
//		if (phNo.length() == level) {
//				combinations.add(intermediate);
//				return;
//		}
//		
//			for (int i = 0; i < keypad.get(phNo.charAt(level)).length(); i++) {
//				permutationHelper(phNo, keypad, intermediate + keypad.get(phNo.charAt(level)).charAt(i), level + 1, combinations, dictionary);
//			}
//		
//	}

//	string combinations
//	public static void main(String[] args) {
//		printAllPermutations("abc")
//			.stream()
//			.forEach(System.out::println);
//	}
//
//	private static List<String> printAllPermutations(String src) {
//		List<String> permutations = new ArrayList<String>();
//		boolean[] visited = new boolean[src.length()];
//		helper(permutations, src, "", 0, visited);
//		return permutations;
//	}
//
//	private static void helper(List<String> permutations, String src, String intermediate, int level, boolean[] visited) {
//		if(level == src.length()) {
//			permutations.add(intermediate);
//			return;
//		}
//
//		for(int i=0;i<src.length();i++) {
//			if(visited[i])
//				continue;
//
//			visited[i]=true;
//			helper(permutations, src, intermediate + src.charAt(i), level+1, visited);
//			visited[i]=false;
//		}
//	}

//	print power set
	public static void main(String[] args) {
		printPowerSet("abc").stream().forEach(System.out::println);
	}

	private static List<String> printPowerSet(String src) {
		List<String> powerSet = new ArrayList<String>();
		boolean[] visited = new boolean[src.length()];
		helper(powerSet, src, visited, "",0);
		return powerSet;
	}

	private static void helper(List<String> powerSet, String src, boolean[] visited, String s,int level) {
		if(level>src.length())
			return;

		powerSet.add(s);

		for(int i=level;i<src.length();i++){
			if (visited[i])
				continue;
			visited[i]=true;
			helper(powerSet,src,visited,s+src.charAt(i),i+1);
			visited[i]=false;
		}

	}

	// print all combinations
//	public static void main(String[] args) {
//		List<List<Integer>> input = new ArrayList<List<Integer>>();
//		List<Integer> list = new ArrayList<Integer>();
//		list.add(2);
//		list.add(3);
//		input.add(list);
//
//		list = new ArrayList<Integer>();
//		list.add(4);
//		list.add(8);
//		list.add(9);
//		input.add(list);
//
//		list = new ArrayList<Integer>();
//		list.add(5);
//		list.add(7);
//		input.add(list);
//
//		printCombinations(input);
//	}
//
//	private static void printCombinations(List<List<Integer>> input) {
//		List<String> combinations = new ArrayList<String>();
//		helper(input, combinations, "", 0);
//		combinations.stream().forEach(System.out::println);
//	}
//
//	private static void helper(List<List<Integer>> input, List<String> combinations, String intermediate, int level) {
//		if (level == input.size()) {
//			combinations.add(intermediate);
//			return;
//		}
//
//		for (int i = 0; i < input.get(level).size(); i++) {
////			intermediate += input.get(level).get(i);
////			helper(input, combinations, intermediate, level+1);
////			intermediate = intermediate.substring(0, intermediate.length()-1);
//
//			helper(input, combinations, intermediate + input.get(level).get(i), level + 1);
//		}
//	}

}
