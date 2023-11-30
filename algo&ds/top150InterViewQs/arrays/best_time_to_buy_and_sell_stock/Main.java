/**
 *
 *
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 *
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 *
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 */

public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{7,1,5,3,6,4};
        System.out.println(maxBestProfit(nums));
    }

    // Best way to solve it
    public static int maxBestProfit(int[] prices) {
        int max_profit = 0;
        int left = 0; // the day you buy
        int right = 1; // the day you sell

        // iterate over the entire duration
        while (right < prices.length) {
            int curr_profit = prices[right] - prices[left];
            // if curr profit is positive, meaning is some profit then
            if(prices[left] < prices[right]) {
                max_profit = Math.max(max_profit, curr_profit);
            }
            // jump to lowest price day so far
            else {
                left = right;
            }
            right++;
        }
        return max_profit;
    }

    // Time limit exceeded but works :(
    public static int maxProfit(int[] prices) {
        int max_profit = 0;
        for(int i = 0; i < prices.length; i++) {
            for(int j = i + 1; j < prices.length; j++) {
                int temp = - (prices[i] - prices[j]);
                if(temp > max_profit) {
                    max_profit = temp;
                }
            }
        }
        return max_profit;
    }
}
