import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        int[] A = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(A, target)));
    }
    public static int[] twoSum(int[] nums, int target) {

        // REMEMBER YOU CANT USE THE ELEMENT TWICE

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            // i != map.get(diff) ensures that you dont end up using the element in the same index.
            if(map.containsKey(diff) && i != map.get(diff)) {
                return new int[]{i, map.get(diff)};
            }
        }
        return null;
    }
}
