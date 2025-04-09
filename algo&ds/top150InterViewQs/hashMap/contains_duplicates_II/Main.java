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

    /*
        I just coded the thing below but I'm not sure how I got it right :O
     */
    public static boolean containsNearbyDuplicate2(int[] nums, int k) {
        if(k == 0) return false;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if(set.size() == k) {
                if(set.contains(num)) {
                    return true;
                } else {
                    set.remove(nums[i-k]);
                    set.add(num);
                }
            } else {
                if(set.contains(num)) {
                    return true;
                } else {
                    set.add(num);
                }
            }
        }

        return false;
    }

}
