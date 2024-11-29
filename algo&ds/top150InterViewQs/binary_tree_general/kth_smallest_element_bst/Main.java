import com.sun.source.tree.Tree;

import java.util.ArrayList;

public class Main {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(2);

        n1.left = n2;
        n1.right = n3;
        n2.right = n4;

        System.out.println(kthSmallest(n1, 1));

    }

    public static int kthSmallest(TreeNode root, int k) {
        helper(root);
        return tree.get(k-1).val;
    }

    private static ArrayList<TreeNode> tree = new ArrayList<>();

    public static void helper(TreeNode root) {
        if(root == null) return;
        helper(root.left);
        tree.add(root);
        helper(root.right);
    }
}
