public class MainMyWrongAnswer {
    public int rob(int[] nums) {
        /*
            I thought of iterating from the back since I had to only take the numbers one after another and this would just add up.

            The problem would be when I have an array like [2,1,1,2]
            In this case I will have to take the first and the last.
         */

        int[] arr = new int[2];

        for(int i = nums.length -1; i >= 0; i--) {
            int index = i % 2;
            arr[index] += nums[i];
        }

        int specialCase = 0;
        if(nums.length > 2) {
            specialCase = nums[0] + nums[nums.length - 1];
        }

        return Math.max(arr[0], Math.max(specialCase, arr[1]));
    }
}
