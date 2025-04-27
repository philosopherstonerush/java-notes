public class Test {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {

        int left = 1;
        int right = x;
        long mid = x;

        while(left <= right) {
            mid = left + ((right - left) / 2);
            if((long) (mid * mid) == (long) x) {
                return (int) mid;
            } else if((long) (mid * mid) < (long) x) {
                left = (int) (mid + 1);
            } else {
                right = (int) (mid - 1);
            }
        }

        return right;
    }

}
