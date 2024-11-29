import java.util.Arrays;

public class MainRecursive {
    public static void main(String[] args) {
        int[] test = new int[]{2,1,1,2};
        System.out.println(rob(test));
    }

    private static int[] memo;
    public static int rob(int[] nums) {
        memo = new int[nums.length + 1]; // this is because of i - 2
        Arrays.fill(memo, -1);
        return rob(nums, nums.length - 1);
    }

    public static int rob(int[] nums, int i) {
        if(i < 0) {
            return 0;
        }
        if(memo[i] >= 0) { // if a value is present;
            return memo[i];
        }
        int result = Math.max(rob(nums, i-2) + nums[i], rob(nums, i -1));
        memo[i] = result;
        return result;
    }

}
