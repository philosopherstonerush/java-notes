import java.util.*;

/**
 *
 * Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
 *
 * Implement the LRUCache class:
 *
 * LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
 * int get(int key) Return the value of the key if the key exists, otherwise return -1.
 * void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
 * The functions get and put must each run in O(1) average time complexity.
 *
 */

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

/**
 *
 * Another one that I happened to do on my own.
 *
 */



public class LRUCache {

    private HashMap<Integer, Integer> LList;
    private int currCapacity = 0;
    private int maxCapacity;
    private Deque<Integer> leastRecentlyUsed = new LinkedList<>();

    public LRUCache(int capacity) {
        this.LList = new HashMap<>();
        this.maxCapacity = capacity;
    }

    // Unnecessary contains key check makes it run slower!

    public int get(int key) {
        int val;
        if(LList.containsKey(key)) {
            val = LList.get(key);
            leastRecentlyUsed.remove(key);
            leastRecentlyUsed.addFirst(key);
            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if(LList.containsKey(key)) {
            LList.put(key, value);
            leastRecentlyUsed.remove(key);
            leastRecentlyUsed.addFirst(key);
        } else {
            if(currCapacity >= maxCapacity) {
                int flag = 0;
                do {
                    int LRUkey = leastRecentlyUsed.removeLast();
                    if(LList.containsKey(LRUkey)) {
                        LList.remove(LRUkey);
                        LList.put(key ,value);
                        leastRecentlyUsed.addFirst(key);
                        flag = 1;
                    }
                } while(flag == 0 && leastRecentlyUsed.size() != 0);
            } else {
                leastRecentlyUsed.remove(key);
                LList.put(key, value);
                leastRecentlyUsed.addFirst(key);
                currCapacity++;
            }
        }
    }
}
