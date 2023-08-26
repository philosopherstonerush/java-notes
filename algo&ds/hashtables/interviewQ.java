import java.util.HashMap;
import java.util.Optional;

/**
 * Interview question involving hashmap example - compare two lists for common elements effectively by inserting it into a dict or hashmap. It is kinda like how sieve of eratosthenes works.
 */

public class interviewQ {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3,};
        int[] arr2 = {8, 6, 7};

        interviewQ i = new interviewQ();
        System.out.println(i.hasCommon(arr1, arr2));

    }

    public boolean hasCommon(int[] arr1, int[] arr2) {

        HashMap<Integer, Boolean> hm = new HashMap<Integer, Boolean>();
        for(int i = 0; i < arr1.length; i++) {
            hm.put(arr1[i], Boolean.TRUE);
        }

        for(int i = 0; i < arr2.length; i++) {
            Boolean t = hm.get(arr2[i]);

            // check out notes on Optional class on java notes/basics
            if (Optional.ofNullable(t).orElse(false)) {
                return true;
            }
        }

        return false;
    }
}
