
public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindromeNumber(121));
    }
    public static boolean isPalindrome(int x) {
        String y = Integer.toString(x);

        // to save time, just check it till half the length.
        for(int i = 0; i < y.length()/2; i++) {
            char l = y.charAt(i);
            char r = y.charAt(y.length() - (i + 1));
            if(l != r) {
                return false;
            }
        }
        return true;
    }

    // Only with numbers
    public static boolean isPalindromeNumber(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }

        int reversed = 0;
        while (x > reversed) {
            reversed = reversed * 10 + x % 10;
            System.out.println(x + " " + reversed);
            x /= 10;
        }
        return (x == reversed) || (x == reversed / 10);
    }
}
