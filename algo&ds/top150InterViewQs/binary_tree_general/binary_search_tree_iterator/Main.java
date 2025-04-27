import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

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


     // This is a good solution that I came up on my own but the problem is that it uses O(n) memory - meaning every node needs a extra copy but I will have to do it in O(h)

    static class BSTIterator {

        ArrayList<Integer> arrOfBST = new ArrayList<>();
        int elemPointer = -1;

        public BSTIterator(TreeNode root) {
            LinkedList<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            while(!queue.isEmpty()) {
                TreeNode temp = queue.peekFirst();
                if(temp.left != null) {
                    queue.addFirst(temp.left);
                    temp.left = null;
                } else {
                    arrOfBST.add(temp.val);
                    queue.removeFirst();
                    if(temp.right != null) {
                        queue.addFirst(temp.right);
                    }
                }
            }
        }

        public int next() {
            return this.arrOfBST.get(++this.elemPointer);
        }

        public boolean hasNext() {
            return !(this.elemPointer >= (this.arrOfBST.size() - 1));
        }
    }

    // This uses O(h) memory
    static class BSTIteratorStack {

        Stack<TreeNode> stack;

        public BSTIteratorStack(TreeNode root) {
            stack = new Stack<>();
            fillStack(root);
        }

        public int next() {
            TreeNode curNode = this.stack.pop();
            fillStack(curNode.right);
            return curNode.val;
        }

        public boolean hasNext() {
            return !this.stack.isEmpty();
        }

        private void fillStack(TreeNode root) {
            while(root != null) {
                stack.push(root);
                root = root.left;
            }
        }
    }


    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(7);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(15);
        TreeNode n4 = new TreeNode(9);
        TreeNode n5 = new TreeNode(20);

        n1.left = n2;
        n1.right = n3;
        n2.left = null;
        n2.right = null;
        n3.left = n4;
        n3.right = n5;

        BSTIterator b = new BSTIterator(n1);
    }

}
