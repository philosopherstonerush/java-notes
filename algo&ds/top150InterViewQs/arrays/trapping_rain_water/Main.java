
/**
 *
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
 *
 */


/**
 *
 *
 * We start with finding the left most height and the right most height and then we do left++ , right-- and continue. Now if the new left height is greater than max left height then we update the lmax height and similarly for the right side.
 *
 * When This is not the case the we proceed with the side with the minimum height , say it's left for the further understanding , now we take the difference b/w the left heights and add to the water stored i.ei.ei.e water += lmax - height[lpos]; or water += rmax - height[rpos]; according to the current scenario as explained above.
 *
 *
 * In the same way depicted above we further continue till the loop i.e ends while(lpos < rpos) then we would finally obtain the water which can be trapped during this process.
 *
 *
 *
 */

public class Main {
    public static void main(String[] args) {
        int[] heights = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(heights));
    }

    public static int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int trapped_water = 0;

        while(left < right) {
            if(leftMax < rightMax) {
                left++;
                if(leftMax < height[left]) {
                    leftMax = height[left];
                } else {
                    trapped_water += leftMax - height[left];
                }
            } else {
                right--;
                if(rightMax < height[right]) {
                    rightMax = height[right];
                } else {
                    trapped_water += rightMax - height[right];
                }
            }
        }

        return trapped_water;

    }
}
