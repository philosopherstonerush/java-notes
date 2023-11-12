/**
 *
 *
 * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place. The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
 *
 * Consider the number of elements in nums which are not equal to val be k, to get accepted, you need to do the following things:
 *
 * Change the array nums such that the first k elements of nums contain the elements which are not equal to val. The remaining elements of nums are not important as well as the size of nums.
 * Return k.
 *
 */

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int val = 3;
        System.out.println(removeElement(nums, val));
    }

    public static int removeElement(int[] nums, int val) {

        // for every element in the nums
        for(int i = 0; i < nums.length; i++) {
            // execute only if nums == val
            if(nums[i] == val) {
                // find an element that is not val, swap places
                int j = i+1;
                while(j < nums.length) {
                    if(nums[j] != val) {
                        int temp = nums[i];
                        nums[i] = nums[j];
                        nums[j] = temp;
                        break;
                    } else {
                        j++;
                    }
                }
                // if such element cannot be found then return i
                if(j == nums.length) {
                    return i;
                }
            }
        }
        return nums.length;
    }

}
