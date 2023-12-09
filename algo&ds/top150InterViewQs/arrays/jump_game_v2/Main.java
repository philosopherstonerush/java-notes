import java.util.Arrays;

/**
 *
 * QUESTION:
 *
 * You are given a 0-indexed array of integers nums of length n. You are initially positioned at nums[0].
 *
 * Each element nums[i] represents the maximum length of a forward jump from index i. In other words, if you are at nums[i], you can jump to any nums[i + j] where:
 *
 * 0 <= j <= nums[i] and
 * i + j < n
 *
 * Return the minimum number of jumps to reach nums[n - 1]. The test cases are generated such that you can reach nums[n - 1].
 *
 *
 */



/**
 * EXPLANATION:
 *
 * To be precise, the first loop changes the values of the array so that index N becomes the maximum index to which we can jump if we are at the most “favorable” index from the index segment [M + 1, N], where M determines the last index the previous segment.
 *
 * nums[i-1] already contains maximum we can reach upto from i-1
 * for the ith element, we can go further if nums[i] + i > (modified)nums[i-1]
 * if not, we are better off by jumping from i-1 itself, and never reaching i
 *
 * The second loop simply accumlates the count of these maximised jumps.
 *
 */

public class Main {

    public static void main(String[] args) {
        int[] numbers = new int[]{2,3,0,1,4};
        System.out.println(jump(numbers));
    }

    // leetcode's best solution
    public static int jump(int[] nums) {
        for(int i = 1; i < nums.length; i++) {
            nums[i] = Math.max(nums[i]+i, nums[i-1]);
        }
        int ind = 0;
        int ans = 0;

        while(ind < nums.length - 1) {
            ans++;
            ind = nums[ind];
        }
        return ans;
    }
}

