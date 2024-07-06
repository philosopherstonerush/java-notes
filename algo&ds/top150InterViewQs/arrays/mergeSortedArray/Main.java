/**
 *
 *
 * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
 *
 * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 *
 * The final sorted array should not be returned by the function, but instead be stored inside the array nums1. To accommodate this, nums1 has a length of m + n, where the first m elements denote the elements that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a length of n.
 *
 */


public class Main {
    public static void main(String[] args) {
        int[] nums1 = new int[] {1,2,3,0,0,0};
        int[] nums2 = new int[] {2,5,6};
        int m = 3;
        int n = 3;
        merge(nums1, m, nums2, n);
    }

    // Runtime: O(n+m)
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        // three pointers ---> starting from the back because both the arrays are sorted and its easier to find greatest and put it in the back
        int x = m-1;
        int y = n-1;
        int z = m+n-1;

        // While the smaller array is greater than 0
        while( y >= 0 ) {
            // fill the last element based on the biggest element in the two arrays. z goes from last index to 0, gradually merging greater elements first.
            if(x >= 0 && nums1[x] >= nums2[y] ) {
                nums1[z--] = nums1[x--];
            } else {
                nums1[z--] = nums2[y--];
            }
        }

    }
}
