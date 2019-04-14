package karate.chops.recursion;

public class GenerateMatchingParenthesis {

	public static void main(String... args) {
		printParenthesis(3);
	}

	private static void printParenthesis(int noOfPairs) {
		helper(noOfPairs, noOfPairs, "");
	}

	private static void helper(int left, int right, String intermediate) {
		if (left == 0 && right == 0) {
			System.out.println(intermediate);
			return;
		}

		if (left > 0)
			helper(left - 1, right, intermediate + "(");

		if (right > left)
			helper(left, right - 1, intermediate + ")");
	}
}