public class Main {

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    // use binary search to find the square root
    public static int mySqrt(int x) {

        if(x==0 || x==1) {
            return x;
        }

        int start = 0;
        int mid = -1;
        int end = x;

        while(start <= end) {
            mid = start + (end - start) / 2;
            if((long) mid * mid > x) {
                end = mid - 1;
            } else if ((long) mid * mid == x) {
                return mid;
            } else {
                start = mid + 1;
            }
        }

        return end;
    }

}
