import java.util.LinkedList;

public class Test {
    static public class TreeNode {
        int val;
        Main.TreeNode left;
        Main.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, Main.TreeNode left, Main.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node2l = new TreeNode(2);
        TreeNode node2r = new TreeNode(2);
        TreeNode node3l = new TreeNode(3);
        TreeNode node3r = new TreeNode(3);
        TreeNode node4l = new TreeNode(4);
        TreeNode node4r = new TreeNode(4);

        root.left = node2l;
        root.right = node2r;

        node2l.left = node3l;
        node2l.right = node4l;

        node2r.left = node4r;
        node2r.right = node3r;

        isSymmetric(root);

    }

    public static boolean isSymmetric(TreeNode root) {

        return root == null || isSymmetricHelp(root.left, root.right);

    }

    // recursive solution

    public static boolean isSymmetricHelp(Main.TreeNode left, Main.TreeNode right) {

        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;

        return isSymmetricHelp(left.left, right.right) && isSymmetricHelp(left.right, right.left);

    }


    // stack based approach

    public static boolean isSymmetricButItsStack(Main.TreeNode root) {

        
    }
}
