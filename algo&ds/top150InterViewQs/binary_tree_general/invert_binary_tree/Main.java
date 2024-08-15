import com.sun.source.tree.Tree;

public class Main {


    static public class TreeNode {
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
        TreeNode root = new TreeNode(4);
        TreeNode node2 = new TreeNode(2);
        TreeNode node7 = new TreeNode(7);
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node9 = new TreeNode(9);

        root.left = node2;
        root.right = node7;

        node2.left = node1;
        node2.right = node3;

        node7.left = node6;
        node7.right = node9;

        TreeNode invertedRoot = invertTree(root);

    }


    // solved it in the first try - way to go suvarna!
    public static TreeNode invertTree(TreeNode root) {

        if(root == null || (root.left == null && root.right == null)) return root;

        TreeNode leftNode = invertTree(root.left);
        TreeNode rightNode = invertTree(root.right);

        root.left = rightNode;
        root.right = leftNode;

        return root;
    }

}
