import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 *  Implement the RandomizedSet class:
 *
 * RandomizedSet() Initializes the RandomizedSet object.
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.
 * You must implement the functions of the class such that each function works in average O(1) time complexity.
 *
 *
 */

class RandomizedSet {

    // This stores the val (which is key) and the index (which is the value) of the val in the arr.
    HashMap<Integer, Integer> random_set;
    // We can the arr to randomly return a val.
    ArrayList<Integer> arr;

    public RandomizedSet() {
        random_set = new HashMap<>();
        arr = new ArrayList<>();
    }

    public boolean insert(int val) {
        // check if the value is already present
        int value = random_set.getOrDefault(val, -1);
        if (value != -1) {
            return false;
        }
        // add to the end of the array
        arr.add(val);
        // give the hashmap the value of the index which is the end of the array
        random_set.put(val, arr.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        // see if the value exists
        int value = random_set.getOrDefault(val, -1);

        if (value == -1) {
           return false;
        }

        // index of element in the array
        int index = random_set.get(val);

        // set the last val in the arr to occupy that index
        random_set.put(arr.get(arr.size()-1), index);

        // set the val from the last index in arr to that index in arr
        arr.set(index, arr.get(arr.size()-1));

        // remove the last index
        arr.remove(arr.size()-1);
        // remove the val in hashmap
        random_set.put(val, -1);

        return true;
    }

    public int getRandom() {
        // boilerplate random code
        Random random = new Random();
        return arr.get(random.nextInt(arr.size()));
    }
}