import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Array;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        String[] stringList = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ans = groupAnagrams(stringList);
        printPretty(ans);
//        printPrimes(120);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
    }

    public static void printPrimes(int limit) {
        for(int i = 1; i < limit; i++) {
            BigInteger temp = BigInteger.valueOf(i);
            if(temp.isProbablePrime(1)) {
                System.out.println(i);
            }
        }
    }

    public static void printPretty(List<List<String>> list ) {
        for(List<String> li: list) {
            System.out.println(li.toString());
        }
    }
}
