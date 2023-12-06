/**
 *
 *
 * You are given an integer array nums. You are initially positioned at the array's first index, and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 *
 */


public class Main {
    public static void main(String[] args) {

        int[] nums = new int[]{2,0,0};
        System.out.println(canJump(nums));

    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }

        // iterate through all elements in the list
        for(int i = 0; i < nums.length; i++) {
            // if the element is not a zero then skip
            if(nums[i] != 0) {
                continue;
            } else {
                // if its a zero and the last element, it doesn't matter since the goal is to reach the last element, nothing to jump over
                if(i == nums.length -1) {
                    return true;
                }
                // see if you can jump the zero
                Boolean opt = canJumpZero(nums,i);
                if(!opt) {
                    return false;
                }
            }
        }
        return true;
    }

    private static Boolean canJumpZero(int[] nums, int index) {
        // the number of places to jump
        int numbersToHop = 1;
        // go backwards from that index
        int tempIndex = --index;
        while(tempIndex >= 0) {
            // if you can jump zero then return true
            if(nums[tempIndex] > numbersToHop) {
                return true;
            }
            numbersToHop++;
            tempIndex--;
        }
        // if zero is reached
        return false;
    }
}
