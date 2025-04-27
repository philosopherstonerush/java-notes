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

    public static void main(String[] args) {
        var n1 = new TreeNode(0);
        var n2 = new TreeNode(1);
        var n3 = new TreeNode(1);
//        var n4 = new TreeNode(15);
//        var n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
//        n3.left = n4;
//        n3.right = n5;

        Test t = new Test();
        System.out.println(t.maxPathSum(n1));
    }


}
