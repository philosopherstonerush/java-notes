import com.sun.source.tree.Tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Test {
    static public class TreeNode {
        int val;
        Test.TreeNode left;
        Test.TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new Test.TreeNode(1);
        TreeNode node2l = new Test.TreeNode(2);
        TreeNode node2r = new Test.TreeNode(2);
        TreeNode node3l = new Test.TreeNode(3);
        TreeNode node3r = new Test.TreeNode(3);
        TreeNode node4l = new Test.TreeNode(4);
        TreeNode node4r = new Test.TreeNode(4);

        root.left = node2l;
        root.right = node2r;

        node2l.left = node3l;
        node2l.right = node4l;

        node2r.left = node4r;
        node2r.right = node3r;

        System.out.println(isSymmetricButItsStack(root));

    }

    public static boolean isSymmetric(Test.TreeNode root) {
        if(root == null) return true;
        return isSymmetricHelp(root.left, root.right);
    }

    // recursive solution

    public static boolean isSymmetricHelp(Test.TreeNode left, Test.TreeNode right) {
        
    }


    // stack based approach

    public static boolean isSymmetricButItsStack(TreeNode root) {


    }
}
