import com.sun.source.tree.Tree;

import java.util.*;

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

    // Convert to primitives
    // https://leetcode.com/problems/binary-tree-maximum-path-sum/?envType=study-plan-v2&envId=top-interview-150

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
        System.out.println(maxPathSum(n1));
    }

    static int max_path = Integer.MAX_VALUE;

    public static int getMaxGain(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int gain_on_left = Math.max(getMaxGain(root.left), 0);
        int gain_on_right = Math.max(getMaxGain(root.right), 0);

        max_path = Math.max(root.val + gain_on_left + gain_on_right, max_path);

        return root.val + Math.max(gain_on_left, gain_on_right);

    }

    public static int maxPathSum(TreeNode root) {
        getMaxGain(root);
        return max_path;
    }
}
