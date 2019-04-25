package karate.chops.recursion;

public class GenerateMatchingParenthesis {

    public static void main(String... args) {
        printParenthesis(3);
    }

    private static void printParenthesis(int noOfPairs) {
        helper(noOfPairs, noOfPairs, "");
    }

    private static void helper(int leftCount, int rightCount, String intermediate) {
        if (leftCount < 0 || rightCount < 0)
            return;
        if (leftCount == 0 && rightCount == 0) {
            System.out.println(intermediate);
            return;
        }
        helper(leftCount - 1, rightCount, intermediate + "(");
        if (rightCount > leftCount)
            helper(leftCount, rightCount - 1, intermediate + ")");
    }
}