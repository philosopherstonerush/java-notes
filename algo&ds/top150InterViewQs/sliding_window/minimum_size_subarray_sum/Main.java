import java.util.Arrays;

/**
 *
 *Given an array of positive integers nums and a positive integer target, return the minimal length of a
 * subarray
 *  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.
 *
 *
 */

public class Main {
    public static void main(String[] args) {
       int target = 7;
       int[] nums = new int[]{2,3,1,2,4,3};
       System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int i = 0;
        int j = 0;
        // ans contains the length of the minimum number of elements required
        int ans = nums.length + 1;
        // sum contains the current window element's sum
        int sum = 0;
        int N = nums.length;

        // refer to the sliding window theory and template if you cant solve this

        while(j < N) {
            // increase the window size
            while(j < N && sum < target) sum += nums[j++];
            // break if there's no solvable solution
            if(sum < target) break;
            // reduce window from the left
            while(i < N && sum >= target) sum -= nums[i++];
            // update the length
            ans = Math.min(ans, j-i+1);
        }

        return (ans == nums.length + 1) ? 0: ans;
    }
}
