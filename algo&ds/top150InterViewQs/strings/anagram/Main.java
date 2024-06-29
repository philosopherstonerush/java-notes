import java.util.Arrays;
import java.util.HashMap;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        String test = "skybllllue";
        String seq = "kysllueb";

        System.out.println(isAnagram(test, seq));

    }

    public static Boolean isAnagram(String test, String seq) {

        char[] testChar = test.toCharArray();
        char[] seqChar = seq.toCharArray();

        Arrays.sort(testChar);
        Arrays.sort(seqChar);

        return Arrays.equals(testChar, seqChar);
    }

}
