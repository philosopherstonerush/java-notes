
/**
 *
 *
 * Given an integer n, return the number of trailing zeroes in n!.
 *
 * Note that n! = n * (n - 1) * (n - 2) * ... * 3 * 2 * 1.
 *
 *
 */


public class Main {

    public static void main(String[] args) {
        System.out.println(trailingZeroes(30));
    }

    // Logarthmic runtime :)
    // Check out notes for a detailed explanation
    public static int trailingZeroes(int n) {
        int div = 5;
        int zeros = 0;
        while(n > div) {
            int count = n / div;
            zeros += count;
            div = 5 * div;
        }

        return zeros;
    }

}
