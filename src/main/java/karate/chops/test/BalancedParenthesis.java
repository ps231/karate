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
        System.out.println(areParenthesisBalanced("{}a"));
    }

    private static boolean areParenthesisBalanced(String input) {
        if (input == null || input.length() == 0)
            throw new IllegalArgumentException("invalid input");

        Stack<Character> s = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '[' || c == '{' || c == '(')
                s.push(c);
            else if (c == ']' || c == '}' || c == ')') {
                switch (c) {
                    case ']':
                        if (s.isEmpty() || s.pop() != '[')
                            return false;
                        break;
                    case '}':
                        if (s.isEmpty() || s.pop() != '{')
                            return false;
                        break;
                    case ')':
                        if (s.isEmpty() || s.pop() != '(')
                            return false;
                        break;
                }
            } else
                throw new IllegalArgumentException("invalid input: " + c);
        }
        return s.isEmpty();
    }
}
