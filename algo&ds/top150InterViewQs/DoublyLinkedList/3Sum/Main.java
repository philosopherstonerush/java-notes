import java.util.*;

/**
 *
 *
 * Given an integer array nums,
 * return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k,
 * and
 * nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * For input and output example - refer readme
 *
 */

public class Main {

    public static void main(String[] args) {
        int[] nums = {-2,0,1,1,2};
        System.out.println(threeSum(nums));
    }


    public static List<List<Integer>> threeSum(int[] nums) {


        // This uses Dual pivot QuickSort algorithm to sort the numbers. Performance - O(nlogn)
        Arrays.sort(nums);

        // To ensure that there is no duplicate list of integers as our result.
        HashSet<List<Integer>> output = new HashSet<>();

        // if we take one number as constant for each iteration then the whole problem becomes twoSum_inputSorted.
        for(int i = 0; i < nums.length; i++) {
            int first = nums[i];
            int left = i+1;
            int right = nums.length - 1;
            while(left < right) {
                if(first + nums[left] + nums[right] == 0) {
                    output.add(Arrays.asList(first, nums[left], nums[right]));
                    left++;
                } else if (first + nums[left] + nums[right] < 0 ) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        List<List<Integer>> result = output.stream().toList();
        return result;
    }

}
