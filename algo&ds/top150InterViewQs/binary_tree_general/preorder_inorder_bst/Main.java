public class Main {

    static public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String args[]) {
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = buildTree(preorder, inorder);
    }


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    /*

    Say we have 2 arrays, PRE and IN.
    Preorder traversing implies that PRE[0] is the root node.
    Then we can find this PRE[0] in IN, say it's IN[5].
    Now we know that IN[5] is root, so we know that IN[0] - IN[4] is on the left side, IN[6] to the end is on the right side.
    Recursively doing this on subarrays, we can build a tree out of it :)

     */

    public static TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for(int i = inStart; i <= inEnd; i++) {
            if(inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.right = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return root;
    }

}
