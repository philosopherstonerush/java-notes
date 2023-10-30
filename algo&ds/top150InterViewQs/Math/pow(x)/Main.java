/**
 *
 *
 * Implement pow(x, n), which calculates x raised to the power n (i.e., xn).
 *
 */


public class Main {

    public static void main(String[] args) {
        System.out.println(myPow(7, 11));
    }


    // log2(O(N) runtime: Really fucking good. I only managed to get O(N)
    public static double myPow(double x, int n) {
        // if the power is negative then its obvious, we have to inverse.
        if(n < 0) {
            x = 1/ x;
        }

        // Integer min value is -2147483648 and max value is 2147483647
        // If you did abs on min value then it wont become a postiive value as it exceeds that range.
        // That is why we store it in long
        long N = Math.abs(n);

        double pow = 1;

        // This theory is explained in readME
        // while N is not zero
        while(N > 0) {
            // bitwise AND, basically N % 2 != 0
            if((N & 1) != 0) {
                pow *= x;
            }
            // increase the power of multiplier
            x *= x;

            // rightshift, basically N / 2
            N >>>=1;
        }

        return pow;
    }
}
