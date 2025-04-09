public class Test {
    public static void main(String[] args) {
        System.out.println(mySqrt(2147395599));
    }

    public static int mySqrt(int x) {

        if(x == 0 || x == 1) {
            return x;
        }

        int left = 0;
        int right = x;

        while(left < right) {
            int mid = left + ((right - left) / 2);
            if((long) mid * mid == x) {
                return mid;
            } else if((long) mid * mid < x) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;

    }

}
