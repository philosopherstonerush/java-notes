import java.util.HashMap;
import java.util.Map;


/**
 *
 *
 * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such that each unique element appears only once. The relative order of the elements should be kept the same. Then return the number of unique elements in nums.
 *
 * Consider the number of unique elements of nums to be k, to get accepted, you need to do the following things:
 *
 * Change the array nums such that the first k elements of nums contain the unique elements in the order they were present in nums initially. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 *
 *
 */


public class Main {

    public static void main(String[] args) {

        int[] nums = new int[]{1,1,2};
        System.out.println(removeDuplicates(nums));

    }

    // leetcode best solution
    public static int removeDuplicates(int[] nums) {

        // Start from the second element
        int j = 1;
        for(int i = 1; i < nums.length; i++) {
            // iterate until i is not equal to its previous element.
           if(nums[i-1] != nums[i]) {
               // replace it at the index pointed by j and increment j
               nums[j] = nums[i];
               j++;
           }
        }
        return j;
    }

    // Awful runtime - got this by making a few changes to the remove_element problem's alogrithm. The hint is in the problem name itself, ITS SORTED
    public static int BadremoveDuplicates(int[] nums) {

        Map<Integer, Boolean> m = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(m.getOrDefault(nums[i], false)) {
                int j = i+1;
                while(j < nums.length) {
                    if(!m.getOrDefault(nums[j], false)) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        m.put(nums[i], true);
                        break;
                    } else {
                        j++;
                    }
                }
                if(j == nums.length) {
                    return i;
                }
            }
            m.put(nums[i], true);
        }
        return nums.length;

    }
}

