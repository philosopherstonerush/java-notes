import java.util.*;

public class Main {

    public static void main(String[] args) {
        String[] stringList = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ans = groupAnagrams(stringList);
        printPretty(ans);
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
                map.put(sortedString, List.of(x));
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
