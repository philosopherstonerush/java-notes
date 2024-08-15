import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        HashSet<ArrayList<Integer>> set = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            int num1 = nums[i];
            while(left < right) {
                int target = num1 + nums[left] + nums[right];
                if(target == 0) {
                    set.add(new ArrayList<>(List.of(num1, nums[left], nums[right])));
                    left+=1;
                } else if(target < 0) {
                    left += 1;
                } else {
                    right -= 1;
                }
            }
        }

        return new ArrayList<>(set);
    }


}
