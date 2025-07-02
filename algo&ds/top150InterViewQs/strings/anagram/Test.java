import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String s = "hello";
        String t = "olleh";
        assert isAnagram(s, t);
    }

    public static boolean isAnagram(String s, String t) {
        char[] sCharArr = s.toCharArray();
        char[] tCharArr = t.toCharArray();

        Arrays.sort(sCharArr);
        Arrays.sort(tCharArr);

        return Arrays.equals(sCharArr, tCharArr);
    }

}
