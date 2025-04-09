import java.math.BigInteger;
import java.sql.Array;
import java.util.*;

public class Test {
    public static void main(String[] args) {
        String[] stringList = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ans = groupAnagrams(stringList);
        printPretty(ans);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        int[] primes = new int[]{
                3,
                5,
                7,
                11,
                13,
                17,
                19,
                23,
                29,
                31,
                37,
                41,
                43,
                47,
                53,
                59,
                61,
                67,
                71,
                73,
                79,
                83,
                89,
                97,
                101,
                103,
                107,
                109
        };

        Map<Integer, List<String>> map = new HashMap<>();

        for(String i: strs) {
            int result = 1;
            for(int j = 0; j < i.length(); j++) {
                result *= primes[i.charAt(j) - 'a'];
            }
            List<String> vals = map.getOrDefault(result, new ArrayList<>());
            vals.add(i);
            map.put(result, vals);
        }


        List<List<String>> finalResult = new ArrayList<>();
        for(Integer key: map.keySet()) {
            List<String> strsSoFar = map.get(key);
            finalResult.add(strsSoFar);
        }

        return finalResult;
    }

    public static void printPretty(List<List<String>> list ) {
        for(List<String> li: list) {
            System.out.println(li.toString());
        }
    }
}
