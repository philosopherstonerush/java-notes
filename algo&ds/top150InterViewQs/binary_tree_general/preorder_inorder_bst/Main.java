import java.util.HashMap;

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

    /*
        If you prefer an answer that is similar to the postorder, inorder traversal question then
     */

    private static HashMap<Integer, Integer> map = new HashMap<>();

    public static Test.TreeNode buildTreee(int[] preorder, int[] inorder) {

        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public static Test.TreeNode buildTreeHelper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }

        Test.TreeNode root = new Test.TreeNode(preorder[preStart]);
        int index = map.get(root.val);

        root.left = buildTreeHelper(preorder, preStart + 1, preStart + index - inStart, inorder, inStart, index);
        root.right = buildTreeHelper(preorder, preStart + index - inStart + 1, preEnd, inorder, index + 1, inEnd);

        return root;
    }
}
