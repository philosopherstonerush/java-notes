import java.util.ArrayList;
import java.util.Arrays;

public class Test {

    public static void main(String args[]) {
        int[] test = new int[]{1,2,2,4};
        System.out.println(Arrays.toString(jump(test)));
    }

    public static Long[] jump(int[] nums) {

        if(nums.length < 3) {
            return new Long[]{};
        }

        Long[] arr = new Long[nums.length - 2];

        int i = 2;
        int j = 0;
        int z = 0;

        while(i < nums.length) {
            arr[z] = helper(nums[j], nums[j+1], nums[i]);
            i++;
            j++;
            z++;
        }
        return arr;
    }

    public static long helper(long x, long y, long z) {
        if(x + y > z) {
            if(y + z > x) {
                if(x + z > y) {
                    return 1;
                }
            }
        }
        return 0;
    }

}
