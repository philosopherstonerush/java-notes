



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
        TreeNode n5 = new TreeNode(5);
        TreeNode n4 = new TreeNode(4);
        TreeNode n11 = new TreeNode(11);
        TreeNode n7 = new TreeNode(7);
        TreeNode n2 = new TreeNode(2);
        TreeNode n8 = new TreeNode(8);
        TreeNode n13 = new TreeNode(13);
        TreeNode n41 = new TreeNode(4);
        TreeNode n1 = new TreeNode(1);

        n5.left = n4;
        n4.left = n11;
        n11.left = n7;
        n11.right = n2;
        n8.left = n13;
        n8.right = n41;
        n4.right = n1;

        Boolean root = hasPathSum(n5, 22);

    }

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        return hasPathSumHelper(root, targetSum, 0);
    }


    // solved by myself - *pats*
    public static boolean hasPathSumHelper(TreeNode root, int targetSum, int currSum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) {
            return targetSum == root.val + currSum;
        }

        boolean leftBool = false;
        boolean rightBool = false;

        if(root.left != null) {
             leftBool = hasPathSumHelper(root.left, targetSum, currSum + root.val);
        }
        if(root.right != null) {
             rightBool = hasPathSumHelper(root.right, targetSum, currSum + root.val);
        }

        return leftBool || rightBool;

    }



}
