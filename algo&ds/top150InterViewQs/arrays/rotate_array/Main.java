import java.util.Arrays;

/**
 *
 * Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
 *
 */

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3,4,5,6,7};
        rotateBest(nums, 3);
    }

    // Works but time limit exceeded

    public static void rotate(int[] nums, int k) {
        if (nums.length == 1) {
            return;
        }
        if(nums.length == 2) {
            while(k-- > 0) {
                int temp = nums[1];
                nums[1] = nums[0];
                nums[0] = temp;
            }
            return;
        }
        k = k % nums.length;
        int temp = nums[0];
        int temp1;
        while(k-- > 0) {
            for(int i = 1; i < nums.length;i++) {
                temp1 = nums[i];
                nums[i] = temp;
                temp = temp1;
            }
            nums[0] = temp;
        }
    }

    // Works, but still terrible runtime (passes though) - considering using it since I understand how it works

    /**
     *  Find the minimum amount of rotations needed, then
     *
     *  1) Reverse the entire array
     *  2) Reverse the first k elements
     *  3) Reverse the remaining elements
     *
     *  This is for right rotation
     */

    public static void rotateBest(int[] nums, int k) {
        k = k % nums.length;
        nums = reverse(nums, 0, nums.length -1);
        nums = reverse(nums, 0, k-1);
        nums = reverse(nums, k, nums.length - 1);
        System.out.println(Arrays.toString(nums));

        /**
         *
         * For left rotation, do this
         *
         * reverse(nums, 0, k-1)
         * reverse(nums, k, nums.length-1)
         * reverse(nums, 0, nums.length-1)
         *
         */
    }

    public static int[] reverse(int[] nums, int start, int end) {
        while(start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }
}