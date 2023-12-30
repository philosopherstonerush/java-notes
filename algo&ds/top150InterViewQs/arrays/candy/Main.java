import java.util.Arrays;

/**
 *
 *
 * There are n children standing in a line. Each child is assigned a rating value given in the integer array ratings.
 *
 * You are giving candies to these children subjected to the following requirements:
 *
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 *
 */


public class Main {
    public static void main(String[] args) {
        int[] test_arr = new int[] {1,2,2};
        System.out.println(candy(test_arr));
    }


    //explained in readme
    public static int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies,1);

        for(int i = 1; i < ratings.length; i++) {
            if(ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i-1] + 1;
            }
        }

        for(int i = ratings.length - 2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                // max is used because, we wouldnt know if candies already has the highest candy count at that index.
                candies[i] = Math.max(candies[i], candies[i+1] + 1);
            }
        }

        int number_of_candies = 0;
        for(int x: candies) {
            number_of_candies = number_of_candies + x;
        }

        return number_of_candies;
    }
}
