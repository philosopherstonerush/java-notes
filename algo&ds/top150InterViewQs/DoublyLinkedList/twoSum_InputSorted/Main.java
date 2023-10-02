import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


/**
 *
 * the input numbers array is guaranteed to be sorted in the ascending order and you have to find two numbers that add up to the target number.
 *
 */

public class Main {

    public static void main(String[] args) {
        int[] numbers = {2,7,11,15};
        int target = 9;
        System.out.println(
                Arrays.toString(twoSumBest(numbers, target))
        );
    }

    // Initial solution - passes test cases but O(N^2)
    public static int[] twoSum(int[] numbers, int target) {
        int[] arr = {0, 0};

        for(int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            if(target - x < x) {
                break;
            }
            for(int j = i+1; j < numbers.length; j++) {
                if(x + numbers[j] == target) {
                    arr[0] = i + 1;
                    arr[1] = j + 1;
                }
            }
        }
        return arr;
    }

    // got accepted but still bad runtime - O(almost N)  I guess?
    public static int[] twoSumH(int[] numbers, int target) {
        int[] arr = {0, 0};
        HashMap<Integer, Integer> hm = new HashMap<>();

        for(int i = 0; i < numbers.length; i++) {
            int x = numbers[i];
            int diff  = target - x;
            if(hm.containsKey(x)) {
                arr[0] = hm.get(x) + 1;
                arr[1] = i + 1;
            } else {
                hm.put(diff, i);
            }
        }

        return arr;
    }

    // We know that the input array is given in a sorted order, so using two pointers left and right we can find out the indexes which sums upto target.

    public static int[] twoSumBest(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while(left < right) {
            if(numbers[left] + numbers[right] == target) {
                return new int[] {left+1, right+1};
            }
            else if(numbers[left] + numbers[right] < target) {
                left++;
            }
            else {
                right--;
            }
        }
        return new int[] {};
    }
}
