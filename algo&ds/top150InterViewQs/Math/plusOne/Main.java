import java.util.ArrayList;

/**
 *
 *
 * You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. The digits are ordered from most significant to least significant in left-to-right order. The large integer does not contain any leading 0's.
 *
 * Increment the large integer by one and return the resulting array of digits.
 *
 */

public class Main {
    public static void main(String[] args) {
        int[] test = {9};
        System.out.println(plusOneBest(test));
    }

    // BAD: Memory usage is quite good but awful runtime.
    public static int[] plusOne(int[] digits) {
        // ArrayList to have the ability to add in the places we want (in front of the list) and then replace as well
        ArrayList<Integer> arr = new ArrayList<>();
        for(int x: digits) {
            arr.add(x);
        }

        // 1) Get the current last element
        int last = arr.get(arr.size()-1);
        last += 1;

        // 2) If the incremented value is lesser than 10, then just replace the last value.
        if(last < 10) {
              arr.set(arr.size()-1, last);
        } else {

            // 3) if not then replace the last index to be 0
            arr.set(arr.size()-1, 0);
            // initialize i with 2 which gets the second last element from the back
            int i = 2;
            // greater is used to stop the while loop
            int greater = 1;
            while(greater == 1) {
                int num;
                // checks if the index pointed at by i is invalid.
                if (i >= arr.size() + 1) {
                    arr.add(0, 1);
                    arr.set(1, 0);
                    greater = 0;
                } else {
                    // if its a valid index, then get the ith element from the back, where you have to add the 1 carry over to.
                    num = arr.get(arr.size()-i);
                    num += 1;
                    // check if its less than 10
                    if(num < 10) {
                        // if invalid index, then just add the number to the front.
                        if (i >= arr.size() + 1) {
                            arr.add(0, num);
                        } else {
                            // if not then replace, the number with num.
                            arr.set(arr.size() - i, num);
                        }
                        // set the next number to zero
                        arr.set(arr.size() - i + 1, 0);
                        greater = 0;
                    } else {
                        // set the ith number to 0 since we have to add 1 to the i-1 number.
                        arr.set(arr.size() - i, 0);
                        i++;
                    }
                }
            }
        }

        // convert ArrayList<Integer> to int[]
        return arr.stream().mapToInt(i -> i).toArray();
    }

    // BEST: Awesome runtime (from leetcode solutions)
    public static int[] plusOneBest(int[] digits) {

        // iterate over the array starting from the back
        for(int i = digits.length - 1; i >= 0; i--) {
            // if its less than 9 then just increment and return the digits.
            if(digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // else just replace that index to zero.
            digits[i] = 0;
        }
        // This code only happens when all the digits in the array has been replaced by zero, and we need to append 1 in the front. This can be done easily by over-writing it with a new array with +1 number of elements compared to the previous array. Since when creating the new array the elements are by default initialized to zero.
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
