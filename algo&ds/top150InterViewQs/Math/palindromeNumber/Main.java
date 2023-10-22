
public class Main {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10));
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
}
