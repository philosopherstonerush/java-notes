import java.util.Arrays;

/**
 *
 *Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 *
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 *
 */

/**
 *
 * Explanation:
 * Sort the array of citations in descending order and iterate through the sorted array. For each paper, check if its citation count is greater than or equal to its position in the sorted array. Keep track of the maximum h-index encountered. This approach has a time complexity of O(n log n) due to the sorting step.
 *
 * It is sorted in ascending order so when you go from lowers indexes to higher indexes, the citations are naturally higher.
 *
 * So your max hindex can only occur at lower indexes.
 *
 * n - i goes from its highest value to lowest value as you travel the array.
 *
 */

public class HIndex {

    public static void main(String[] args) {
        int[] numbers = new int[]{1,3,1};
        System.out.println(hIndex(numbers));
    }

    public static int hIndex(int[] citations) {
        int hindex = 0;
        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        int n = citations.length;
        for(int i = 0; i < citations.length; i++) {
            if(citations[i] >= n-i) {
                System.out.println("citations[i] = "+citations[i] + " / n-i = " + (n-i));
                hindex = Math.max(hindex, n-i);
            }
        }
        return hindex;
    }

}
