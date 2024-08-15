import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] stringList = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ans = bestGroupAnagrams(stringList);
        printPretty(ans);
    }

    public static List<List<String>> bestGroupAnagrams(String[] strs) {

        // map every lowercase alphabet to a list of prime numbers
        int[] PRIMES = new int[]{3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};

        Map<Integer, List<String>> map = new HashMap<>();

        for(String str: strs) {
            int value = 1;
            for(int i = 0; i < str.length(); i++) {
                value *= PRIMES[str.charAt(i) - 'a'];
            }
            if(map.containsKey(value)) {
                List<String> toInsert = map.get(value);
                toInsert.add(str);
                map.put(value, toInsert);
            } else {
                // ERROR if its just List.of() because Arrays.asList only returns a fixed size list that cannot be altered.

                // https://stackoverflow.com/questions/2965747/why-do-i-get-an-unsupportedoperationexception-when-trying-to-remove-an-element-f
                map.put(value, new ArrayList<>(List.of(str)));
            }
        }

        List<List<String>> finaAns = new ArrayList<>();

        for(Integer val: map.keySet()) {
            finaAns.add(map.get(val));
        }

        return finaAns;
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();

        for(String x: strs) {
            char[] charX = x.toCharArray();
            Arrays.sort(charX);
            String sortedString = String.valueOf(charX);

            if(map.containsKey(sortedString)) {
                List<String> list = map.get(sortedString);
                list.add(x);
                map.put(sortedString, list);
            } else {

                map.put(sortedString, new ArrayList<>(List.of(x)));
            }
        }

        List<List<String>> ans = new ArrayList<>();
        for(String y: map.keySet()) {
            ans.add(map.get(y));
        }

        return ans;
    }

    public static void printPretty(List<List<String>> list ) {
        for(List<String> li: list) {
            System.out.println(li.toString());
        }
    }

}
