import java.util.ArrayList;
import java.util.Arrays;

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
    public static void main(String args[]) {
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        n1.left = n2;
        n1.right = n3;

        int sum = sumNumbers(n1);
        System.out.println(sum);
    }

    private static ArrayList<String> sumRootNumbers = new ArrayList<>();

    public static int sumNumbers(TreeNode root) {
        if (root == null) return -1;
        sumNumbersHelper(root, "");
        int totalSum = 0;
        for(String i: sumRootNumbers) {
            int lol = Integer.parseInt(i);
            totalSum += lol;
        }
        return totalSum;
    }

    public static void sumNumbersHelper(TreeNode root, String numChain) {
        if(root.left == null && root.right == null) {
            numChain = numChain + Integer.toString(root.val);
            sumRootNumbers.add(numChain);
        }
        if (root.left != null) {
            sumNumbersHelper(root.left, numChain + Integer.toString(root.val));
        }
        if(root.right != null) {
            sumNumbersHelper(root.right, numChain + Integer.toString(root.val));
        }
    }

}
