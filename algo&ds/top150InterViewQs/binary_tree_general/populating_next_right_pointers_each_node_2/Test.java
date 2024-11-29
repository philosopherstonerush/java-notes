public class Test {

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        Node n5 = new Node(5);
        Node n6 = null;
        Node n7 = new Node(7);

        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.right = n7;

        Node root = connect(n1);
    }

    public static Node connect(Node root) {


        Node head = null;
        Node prev = null;

        Node temp = root;

        while(temp != null) {
            while(temp != null) {
                if(temp.left != null) {
                    if(prev != null) {
                        prev.next = temp.left;
                    } else {
                        head = temp.left;
                    }
                    prev = temp.left;
                }
                if(temp.right != null) {
                    if(prev != null) {
                        prev.next = temp.right;
                    } else {
                        head = temp.right;
                    }
                    prev = temp.right;
                }
                temp = temp.next;
            }

            temp = head;
            prev = null;
            head = null;
        }


        return root;
    }

}
