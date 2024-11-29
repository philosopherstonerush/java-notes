public class Test {
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
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(1);
        TreeNode node1_2 = new TreeNode(2);
        TreeNode node1_3 = new TreeNode(3);

        root1.left = node1_2;
        root1.right = node1_3;

        TreeNode node2_2 = new TreeNode(2);
        TreeNode node2_3 = new TreeNode(3);

        root2.left = node2_2;
        root2.right = node2_3;

        System.out.println(isSameTree(root1, root2));

    }

    public static boolean isSameTree(TreeNode p, TreeNode q) {


    }
}
