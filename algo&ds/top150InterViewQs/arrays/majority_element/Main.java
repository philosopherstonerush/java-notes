import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/*


Given an array nums of size n, return the majority element.

The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.


 */

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,8,7,6,4,5};
        System.out.println(majorityElementBest(nums));
    }

    // best runtime - leetcode solution
    public static int majorityElementBest(int[] nums) {

        // The majority element is always in the n/2 position once sorted

        Arrays.sort(nums);
        return nums[nums.length/2];

    }

    // trivial - bad runtime - my first attempt - did this on the assumption that majority meant most frequent element.
    public static int majorityElement(int[] nums) {

        // count keeps track of curr_max element's frequency

        int count = 1;

        // temp_count keeps track of current looping element's frequency

        int temp_count = 1;

        // Sorting to ensure that similar elements appear one after another
        Arrays.sort(nums);

        // start with the first element as the curr_max
        int curr_max = nums[0];


        for(int i = 1; i < nums.length; i++) {

            // if the previous element is same then increase count
            if(nums[i] == nums[i-1]) {
                temp_count++;

                // if its the last element, then check again for the curr_max condition
                if(i+1 == nums.length) {
                    if(count < temp_count) {
                        count = temp_count;
                        curr_max = nums[i-1];
                        temp_count = 1;
                    }
                }
            } else {

                // If not then check for curr_max and reset
                if(count < temp_count) {
                    count = temp_count;
                    curr_max = nums[i-1];
                    temp_count = 1;
                } else {
                    temp_count = 1;
                }
            }
        }
        return curr_max;
    }

    public static int majorityElementBest2(int[] nums) {
        // JAVA 8 STREAM API WAY TO DO IT
        Map<Integer, Long> numbers = Arrays.stream(nums)
                .boxed()
                .collect(
                        groupingBy(p -> p, counting())
                );

        Integer maxElem = Collections
                .max(numbers.entrySet(), Map.Entry.comparingByValue())
                .getKey();

        return maxElem;

        // Another way
//        Map<Integer, Long> numFreq = Arrays.stream(nums)
//                .boxed()
//                .collect(
//                        Collectors.groupingBy(p-> p, Collectors.counting())
//                );
//
//        return numFreq.entrySet().stream()
//                .max(Map.Entry.comparingByValue())
//                .get().getKey();

    }

}




