

/*//

    Recursive Binary Search Trees employ recursion over loops.

    Brush up your knowledge on base and recursive conditions under recursion folder

 */

public class recursiveBST {
    private  Node root;

    private class Node {
        private int value;
        private Node left;
        private Node right;

        Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }

    // To see if the tree contains a certain node.

    public Boolean rContains(int value, Node currNode) {

        // base condition

        if(currNode == null) return false;
        if(currNode.value == value) return true;

        // recursive case

        if(currNode.value > value) {
            return rContains(value, currNode.left);
        } else {
            return rContains(value, currNode.right);
        }
    }

    // Add root and call the rContains function.

    public Boolean rContains(int value) {
        return rContains(value, root);
    }

    // Inserting values into the tree

    public Node rInsert(int value, Node currNode) {

        // base condition

        if(currNode == null) return new Node(value);

        // recursive condition

        if(currNode.value > value) {

            // consider drawing a BST tree and then traverse with a stack function call. With each call sending their return to the previous call.

            currNode.left = rInsert(value, currNode.left);
        } else if(currNode.value < value) {
            currNode.right = rInsert(value, currNode.right);
        }

        return currNode;
    }

    // Add root to the function call.

    public void rInsert(int value) {

        if(root == null) {
            root = new Node(value);
        } else {
            rInsert(value, root);
        }
    }

    public Node rDelete(int value, Node currNode) {

        // Base condition - if nothing points to it then it gets garbage collected, it doesn't matter if it points to something.

        if(currNode == null) return null;

        // recursive condition

        if(currNode.value < value) {
            currNode.right = rDelete(value, currNode.right);
        } else if(currNode.value > value) {
            currNode.left = rDelete(value, currNode.left);
        } else {

            // if its a leaf node with no children

            if(currNode.left == null && currNode.right == null) {
                currNode = null;
            }

            // if its a leaf node with 1 children

            else if(currNode.left == null) {
                currNode =  currNode.right;
            } else if(currNode.right == null) {
                currNode =  currNode.right;
            }

            // The node is in between levels : find minimum value of the subtree to the right of the current Node, overwrite the currnode value to the one found out by minValue and then delete the right subtree minValue. I remember studying this has percolate up deletion

            else {
                int subTreeMin = minValue(currNode.right);
                currNode.value = subTreeMin;
                currNode.right = rDelete(subTreeMin, currNode.right);
            }
        }

        return currNode;
    }

    // Add root to the function call.

    public void rDelete(int value) {
        rDelete(value, root);
    }

    // finds the minimum value FROM a given node

    public int minValue(Node currNode) {
        while(currNode.left != null) {
            currNode = currNode.left;
        }

        return currNode.value;
    }
}
