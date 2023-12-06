import java.lang.reflect.Array;
import java.util.Arrays;

/**
 *
 *
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 *
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 *
 * Return k after placing the final result in the first k slots of nums.
 *
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 *
 *
 */

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,1,2,2,3};
        System.out.println(removeDuplicates(nums));
    }


    // It is not similar to remove_duplicate_from_sorted-array but this is the base, you can scale it up or down by replacing 2 to 3.. so on or 2 to 1 etc.
    public static int removeDuplicates(int[] nums) {
        int j = 2;

        // For every element in the array. like for(elem: nums)
        for(int i = 2; i < nums.length; i++) {

            // if that element is not equal to the element two places back then replace.
            if(nums[j-2] != nums[i]) {
                nums[j] = nums[i];
                j = j + 1;
            }

        }
        System.out.println(Arrays.toString(nums));
        return j;
    }

}
