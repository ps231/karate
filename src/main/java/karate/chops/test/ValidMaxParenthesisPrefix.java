package karate.chops.test;

import java.util.*;

public class ValidMaxParenthesisPrefix {

	public static void main(String... strings) {
		System.out.println(validParenthesisPrefix("(()(()))()()"));
	}

//	private static int validParenthesisPrefix(String s) {
//		int result = Integer.MIN_VALUE;
//		if (s == null || s.length() == 0)
//			return result;
//
//		Stack<Character> stack = new Stack<Character>();
//		for (int i = 0; i < s.length(); i++) {
//			if (s.charAt(i) == '(')
//				stack.push(s.charAt(i));
//			else if (s.charAt(i) == ')') {
//				if (stack.isEmpty())
//					throw new IllegalArgumentException("invalid input");
//				stack.pop();
//				if (stack.isEmpty()) {
//					result = Math.max(result, i + 1);
//					break;
//				}
//			} else
//				throw new IllegalArgumentException("invalid input");
//		}
//		return result;
//	}

//	there is no need of a stack, a simple counter would suffice as well
	private static int validParenthesisPrefix(String s) {
		int result = Integer.MIN_VALUE;
		int counter = 0;
		if (s == null || s.length() == 0)
			return result;

		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(')
				counter++;
			else if (s.charAt(i) == ')') {
				if (counter == 0)
					throw new IllegalArgumentException("invalid input");
				counter--;
				if (counter == 0) {
					result = Math.max(result, i + 1);
					break;
				}
			} else
				throw new IllegalArgumentException("invalid input");
		}
		return result;
	}
}
