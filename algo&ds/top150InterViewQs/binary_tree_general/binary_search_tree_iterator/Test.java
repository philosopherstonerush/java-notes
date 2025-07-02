import java.util.Stack;

public class Test {

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

    static class BSTIterator {


    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(7);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(9);
        TreeNode n5 = new TreeNode(20);

        n1.left = n2;
        n1.right = n3;
        n2.left = null;
        n2.right = null;
        n3.left = n4;
        n3.right = n5;

        BSTIterator b = new Test.BSTIterator(n1);
        b.next();
        b.next();
        b.hasNext();
        b.next();
        b.hasNext();
        b.next();
        b.hasNext();
        b.next();
        b.hasNext();
    }

}

