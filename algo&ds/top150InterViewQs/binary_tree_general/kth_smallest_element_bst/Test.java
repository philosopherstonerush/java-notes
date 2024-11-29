import com.sun.source.tree.Tree;

import java.util.ArrayList;

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

    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(3);
        TreeNode n2 = new TreeNode(1);
        TreeNode n3 = new TreeNode(4);
        TreeNode n4 = new TreeNode(2);

        n1.left = n2;
        n1.right = n3;
        n2.right = n4;

        System.out.println(kthSmallest(n1, 1));

    }

    private static ArrayList<Integer> arr = new ArrayList<>();

    public static int kthSmallest(TreeNode root, int k) {
        kthSmallestHelper(root);
        return arr.get(k-1);
    }

    public static void kthSmallestHelper(TreeNode root) {
        if(root == null) {
            return;
        }

        kthSmallestHelper(root.left);
        arr.add(root.val);
        kthSmallestHelper(root.right);
    }

}
