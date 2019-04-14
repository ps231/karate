package karate.chops.test;

import java.util.Stack;

public class BalancedParenthesis {

	public static void main(String[] args) {
		System.out.println(areParenthesisBalanced("[(])"));
		System.out.println(areParenthesisBalanced("[[[({{}})(){}[]]](({}[]))]"));
		System.out.println(areParenthesisBalanced("[[](){}"));
		System.out.println(areParenthesisBalanced("}}"));
		System.out.println(areParenthesisBalanced("{}"));
		System.out.println(areParenthesisBalanced("{)"));
	}

	private static boolean areParenthesisBalanced(String expression) {
		if (expression == null || expression.length() == 0)
			throw new IllegalArgumentException("Expression must be provided");

		Stack<Character> stack = new Stack<Character>();
		for (int i = 0; i < expression.length(); i++) {
			char c = expression.charAt(i);
			if (c == '(' || c == '[' || c == '{')
				stack.push(c);
			else if (c == ')' || c == ']' || c == '}') {
				switch (c) {
				case ')':
					if (stack.size() == 0 || stack.pop() != '(')
						return false;
					break;
				case ']':
					if (stack.size() == 0 || stack.pop() != '[')
						return false;
					break;
				case '}':
					if (stack.size() == 0 || stack.pop() != '{')
						return false;
					break;
				}
			} else
				return false;
		}
		return stack.size() == 0;
	}

}
