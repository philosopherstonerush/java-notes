

/*

 inorder   = [4 2 5 1 6 3 7]
    postorder = [4 5 2 6 7 3 1]

    So root would be 1 here and Left array which lay left of 1 is [4 2 5] and Right of 1 is [6 3 7]
    so left_inorder_array =  [4 2 5] and right_inorder_arry = [6 3 7]

    using 6 [ which is just rigth of 1] we are going to devide Postorder_array into two part
    [4 5 2] and [6 7 3]


    1st Phase=>
	                   1

                   /        \

                [4 2 5]   [6 3 7]       <= inorder array
                [4 5 2]   [6 7 3]       <= postorder array

Now we have new freash problem like need to make tree by using inorder = [4 2 5] && postorder =  [4 5 2] for left subtree
AND inorder = [6 3 7] && postorder = [6 7 3] for right  subtree
**now same process we need to do again and again  until One Of the array dose not got empty
Rest of the Process show in a diagram Form :)

    2nd Phase =>
                           1

                      /        \
                     2          3
                [4]    [5]   [6]   [7]       <= inorder array
                [4]    [5]   [6]   [7]       <= postorder array


3rd Phase =>
	             1

               /    \
              2      3

            /  \    /  \             <==== Answer

           4    5  6    7


 */


import java.util.HashMap;
import java.util.Map;

public class Main {
    static public class TreeNode {
        int val;
        Main.TreeNode left;
        Main.TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, Main.TreeNode left, Main.TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String args[]) {
        int[] postorder = new int[]{9,15,7,20,3};
        int[] inorder = new int[]{9,3,15,20,7};
        Main.TreeNode root = buildTree(inorder, postorder);
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length == 0 || postorder.length == 0) return null;

        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return buildTreeHelper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    public static TreeNode buildTreeHelper(int[] inorder, int inStart, int inEnd, int[] postorder, int poStart, int poEnd) {

        if(inStart > inEnd || poStart > poEnd) return null;
        TreeNode root = new TreeNode(postorder[poEnd]);


        // this can be optimized by hashing
//        int inIndex = inStart;
//        while(root.val != inorder[inIndex]) {
//            inIndex++;
//        }

        int inIndex = map.get(root.val);

        root.left = buildTreeHelper(inorder, inStart, inIndex -1, postorder, poStart, poStart + inIndex - inStart - 1);

        // poEnd -1 --> to prevent reaching the last root node again!
        root.right = buildTreeHelper(inorder, inIndex + 1, inEnd, postorder, poStart + inIndex - inStart, poEnd - 1);

        return root;

    }

}
