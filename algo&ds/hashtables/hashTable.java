import java.util.ArrayList;

/**
 * size - Usually takes a prime value to reduce collisions.
 *
 * Node[] - array of Nodes or basically head indices of singly linked list.
 *
 * Each node has three parameters - key, value and next pointer.
 */


public class hashTable {
    private int size = 7;
    private Node[] dataMap;

    class Node {
        private String key;
        private int value;
        private Node next;

        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    hashTable() {
        dataMap = new Node[size];
    }

    public void printTable() {
        Node temp;
        for(int i = 0; i < dataMap.length; i++) {
             temp = dataMap[i];
             System.out.println(i + ":");
             while(temp != null) {
                System.out.println("{" + temp.key + "=" + temp.value + "}" );
                temp = temp.next;
             }
        }
    }

    public int hash(String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();

        for (int asciiValue : keyChars) {

            // the number 23 is used to randomize the key allocation within the array.
            hash = (hash + asciiValue * 23) % dataMap.length;

        }

        return hash;
    }

    public void set(String key, int value) {
        int index = hash(key);
        Node newNode = new Node(key, value);

        if(dataMap[index] == null) {
            dataMap[index] = newNode;
        } else {
          Node temp = dataMap[index];
          while(temp.next != null) {
              temp = temp.next;
          }
          temp.next = newNode;
        }

    }

    public int get(String key) {
        int index = hash(key);
        Node temp = dataMap[index];
        while(temp != null) {
            if(temp.key.equals(key)) {
                return temp.value;
            }
            temp = temp.next;
        }
        return 0;
    }

    public ArrayList<String> keys() {
        ArrayList<String>  arr = new ArrayList<String>();
        for(int i = 0; i < dataMap.length; i++) {
            Node temp = dataMap[i];
            while(temp != null) {
                arr.add(temp.key);
                temp = temp.next;
            }
        }
        return arr;
    }

}
