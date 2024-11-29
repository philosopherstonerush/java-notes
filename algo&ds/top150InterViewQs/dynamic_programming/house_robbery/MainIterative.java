import java.util.Arrays;

public class MainIterative {
    public static void main(String[] args) {
        int[] test = new int[]{2,1,1,2};
        System.out.println(rob(test));
    }

    public static int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        }

        int prev1 = 0;
        int prev2 = 0;

        for(int num: nums) {
            int tmp = prev1;
            prev1 = Math.max(prev1, prev2 + num);
            prev2 = tmp;
        }

        return prev1;
    }
}
