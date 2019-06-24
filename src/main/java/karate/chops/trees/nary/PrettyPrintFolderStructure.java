package karate.chops.trees.nary;

public class PrettyPrintFolderStructure {
    private static String WHITE_SPACE = "  ";

    public static void main(String[] args) {
        prettyPrint(NaryTreeHelper.createFolderStructure());
    }

    private static void prettyPrint(NaryNode root) {
        helper(root, 0);
    }

    private static void helper(NaryNode n, int level) {
        if (n == null)
            return;
        print(n.val, level);
        if (n.children != null && n.children.size() != 0)
            for (NaryNode child : n.children)
                helper(child, level + 1);
    }

    private static void print(String value, int level) {
        for (int i = 0; i < level; i++) {
            System.out.print(WHITE_SPACE);
        }
        System.out.println(value);
    }
}
