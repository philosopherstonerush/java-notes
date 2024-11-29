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



    public static void main(String[] args) {
        var n1 = new TreeNode(-10);
        var n2 = new TreeNode(9);
        var n3 = new TreeNode(20);
        var n4 = new TreeNode(15);
        var n5 = new TreeNode(7);
        n1.left = n2;
        n1.right = n3;
        n3.left = n4;
        n3.right = n5;
        System.out.println(maxPathSum(n1));
    }

    private static HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
    public static int maxPathSum(TreeNode root) {

        traverseInOrder(root);

        return 0;

    }

    public static long computeBest(int val) {
        HashSet<Integer> temp = map.get(val);
        HashSet<Integer> alreadySeen = new HashSet<>();

        int maxVal = Collections.max(temp);



    }

    public static void traverseInOrder(TreeNode root) {

        if(root == null) {
            return;
        }
        HashSet<Integer> adjList = map.getOrDefault(root.val, new HashSet<>());
        if(root.left != null) {
            adjList.add(root.left.val);
        }
        if (root.right != null) {
            adjList.add(root.right.val);
        }
        map.put(root.val, adjList);
        for(Integer elem: adjList) {
            HashSet<Integer> temp = map.getOrDefault(elem, new HashSet<>());
            temp.add(root.val);
            map.put(elem, temp);
        }
        traverseInOrder(root.left);
        traverseInOrder(root.right);
    }

}
