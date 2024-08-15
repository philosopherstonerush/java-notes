import java.util.*;

public class Test {
    public static void main(String[] args) {
        String[] stringList = new String[]{"eat","tea","tan","ate","nat","bat"};
        List<List<String>> ans = groupAnagrams(stringList);
        printPretty(ans);
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

    }

    public static void printPretty(List<List<String>> list ) {
        for(List<String> li: list) {
            System.out.println(li.toString());
        }
    }
}
