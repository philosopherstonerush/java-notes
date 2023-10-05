public class Main {

    public static void main(String[] args) {
        int[] num = {1,8,6,2,5,4,8,3,7};
        int result = maxAreaBest(num);
        System.out.println(result);
    }

    // trivial - O(N^2) exceeds our time limit.
    public static int maxArea(int[] height) {
        int result = 0;
        for(int i = 0; i < height.length; i++) {
            int right = height.length - 1;
            while(right > i) {
                int temp;
                int diff = right - i;
                int heightleft = height[i];
                int heightRight = height[right];
                if(heightleft > heightRight) {
                    temp = heightRight * diff;
                } else {
                    temp = heightleft * diff;
                }

                if(result < temp) {
                    result = temp;
                }
                right--;
            }
        }
        return result;
    }

    // OMFG I DID THIS MYSELF - O(N) [though doing twoSum sorted helped]
    public static int maxAreaBest(int[] height) {
        int result = 0;
        int left = 0;
        int right = height.length - 1;

        // we only change the pointer that points to the lower height since greater one can still be useful.

        while(left < right) {
            int diff = right - left;
            if(height[left] < height[right]) {
                int temp = diff * height[left];
                if(result < temp) {
                    result = temp;
                }
                left++;
            } else {
                int temp = diff * height[right];
                if(result < temp) {
                    result = temp;
                }
                right--;
            }
        }
        return result;
    }

}
