
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

        if(n < 5) return 0;

        int div = 5;
        int trailingZeros = 0;

        do {

            int temp = n / div;
            trailingZeros += temp;
            div = div * 5;

        } while(div < n);

        return trailingZeros;
    }

}
