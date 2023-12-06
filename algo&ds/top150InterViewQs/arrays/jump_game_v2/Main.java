public class Main {

    public static void main(String[] args) {
        int[] numbers = new int[]{2,3,0,1,4};
        System.out.println(jump(numbers));
    }

    public static int jump(int[] nums) {
        int numbersToJump = nums.length-1;
        int jumpCount = 0;
        if(nums.length == 1) {
            return jumpCount;
        }
        int i = 0;
        while(i < nums.length) {
            if(nums[i] >= numbersToJump) {
                return ++jumpCount;
            } else {
                int temp = nums[i];
                i = nums[i];
                jumpCount++;
                numbersToJump = numbersToJump - temp;
            }
        }
        return jumpCount;
    }
}
