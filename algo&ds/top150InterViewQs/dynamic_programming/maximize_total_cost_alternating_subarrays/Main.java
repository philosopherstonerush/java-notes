
/*

You are given an integer array nums with length n.

The cost of a
subarray
 nums[l..r], where 0 <= l <= r < n, is defined as:

cost(l, r) = nums[l] - nums[l + 1] + ... + nums[r] * (−1)r − l

Your task is to split nums into subarrays such that the total cost of the subarrays is maximized, ensuring each element belongs to exactly one subarray.

Formally, if nums is split into k subarrays, where k > 1, at indices i1, i2, ..., ik − 1, where 0 <= i1 < i2 < ... < ik - 1 < n - 1, then the total cost will be:

cost(0, i1) + cost(i1 + 1, i2) + ... + cost(ik − 1 + 1, n − 1)

Return an integer denoting the maximum total cost of the subarrays after splitting the array optimally.

Note: If nums is not split into subarrays, i.e. k = 1, the total cost is simply cost(0, n - 1).


 */


// CHECK OUT README

public class Main {

    public static void main(String args[]) {

        int[] test = new int[]{1,-1};
        System.out.println(maximumTotalCost(test));

    }

    public static long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long addResult = nums[0];
        long subResult = nums[0];

        for(int i = 1; i < n; i++) {
            // creating a new sub array
            // the previous result doesn't matter anymore
            long tempAdd = Math.max(addResult, subResult) + nums[i];

            // adding to the current subarray
            long tempSub = addResult - nums[i];

            addResult = tempAdd;
            subResult = tempSub;
        }

        return Math.max(addResult, subResult);
    }

}
