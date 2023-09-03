import javax.management.QueryEval;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * This BST has no constructor because root defaults to false.
 */


public class binaryST {

    private Node root;

    class Node {
        private int value;
        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
        }
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);

        // if tree is empty then just add.
        if(root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;


        while (true) {

            // if value to be inserted is same as a node already there then false
            if(temp.value == value) {
                return false;
            }

            // if value is lesser then go left
            if (value < temp.value) {
                if (temp.left == null) {
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }

            // if value is higher then go right
            if (value > temp.value) {
                if (temp.right == null) {
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {

        // if the tree is empty then there is nothing to check for
        if (root == null) {
            return false;
        }

        Node temp = root;

        while (temp != null) {

            // if value is lesser go left
            if (value < temp.value) {
                temp = temp.left;
            }

            //if value is higher go right
            else if (value > temp.value) {
                temp = temp.right;
            }

            // if value is same as temp then return true
            else {
                return true;
            }
        }

        // the case when you reached the end of the tree and the item wasnt found
        return false;
    }

    public ArrayList<Integer> breadthFirstSearch() {

        // java built in queue data structure and it uses linked list
        Queue<Node> q = new LinkedList<>();

        ArrayList<Integer> results = new ArrayList<>();
        q.add(root);

        // while the queue isn't empty
        while(q.size() > 0) {

            // eject the FIFO node
            Node temp = q.remove();

            // if left node isnt null, add
            if(temp.left != null) {
                q.add(temp.left);
            }

            // if right node isnt null, add
            if(temp.right != null) {
                q.add(temp.right);
            }

            // add the popped node's value to the results
            results.add(temp.value);
        }

        return results;
    }
}
