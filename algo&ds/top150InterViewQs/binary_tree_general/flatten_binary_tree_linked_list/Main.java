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
         TreeNode n1 = new TreeNode(1);
         TreeNode n2 = new TreeNode(2);
         TreeNode n3 = new TreeNode(3);
         TreeNode n4 = new TreeNode(4);
         TreeNode n5 = new TreeNode(5);
         TreeNode n6 = new TreeNode(6);

         n1.left = n2;
         n1.right = n5;
         n2.left = n3;
         n2.right = n4;
         n5.right = n6;

         TreeNode root = flatten(n1);

     }

    static private TreeNode prev = null;
    public static TreeNode flatten(TreeNode root) {

        if(root == null) {
            return null;
        }
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;

        return root;
    }


}
