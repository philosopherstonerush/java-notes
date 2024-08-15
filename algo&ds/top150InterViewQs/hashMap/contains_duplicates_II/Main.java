import java.util.HashSet;
import java.util.Set;

/*

It iterates over the array using a sliding window. The front of the window is at i, the rear of the window is k steps back. The elements within that window are maintained using a Set. While adding new element to the set, if add() returns false, it means the element already exists in the set. At that point, we return true. If the control reaches out of for loop, it means that inner return true never executed, meaning no such duplicate element was found.

 */


public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums, k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i])) return true;
        }
        return false;
    }

}
