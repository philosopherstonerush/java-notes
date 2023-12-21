import java.util.Arrays;

/**
 *
 *
 * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
 *
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
 *
 * You must write an algorithm that runs in O(n) time and without using the division operation.
 *
 */

public class Main {

    public static void main(String args[]) {
        int[] numbers = new int[]{1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelfSuffixAndPrefix(numbers)));
    }


    // Best solution O(n) time complexity and O(1) space complexity
    // To understand this better, view the lower method first - concept same but space complexity is higher
    public static int[] productExceptSelf(int[] nums) {
        int[] ans_arr = new int[nums.length];
        int pre = 1;

        /**
         *
         * Following the same process as the array in the below method, we just store the pre array in the ans_arr itself instead of having to create new pre array
         *
         */

        for(int i = 0; i < nums.length ;i++) {
            ans_arr[i] = pre;
            pre *= nums[i];
        }

        pre = 1;
        for(int i = nums.length - 1; i >=0 ; i--) {
            ans_arr[i] *= pre;
            pre *= nums[i];
        }

        return ans_arr;
    }

    // To understand the above method easier - this higher space complexity algorithm is explained first
    public static int[] productExceptSelfSuffixAndPrefix(int[] nums) {
        int n = nums.length;
        // prefix array
        int pre[] = new int[n];
        // suffix array
        int suff[] = new int[n];
        pre[0] = 1; // starting element is 1, iterate left to right
        suff[n - 1] = 1; // starting element is 1, iterate right to left

        /**
         *
         * Example = [1,2,3,4,5]
         *
         * pre = [1, 1*1, 1*2, 1*2*3, 1*2*3*4]
         *
         * suff = [5*4*3*2, 5*4*3, 5*4, 1]
         *
         * The final answer just multiplies both.
         *
         */

        for(int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        for(int i = n - 2; i >= 0; i--) {
            suff[i] = suff[i + 1] * nums[i + 1];
        }

        System.out.println(Arrays.toString(pre));
        System.out.println(Arrays.toString(suff));
        int ans[] = new int[n];

        for(int i = 0; i < n; i++) {
            ans[i] = pre[i] * suff[i];
        }
        return ans;
    }



}
