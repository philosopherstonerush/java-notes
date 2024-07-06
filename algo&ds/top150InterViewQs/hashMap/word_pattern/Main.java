import java.util.HashMap;
import java.util.HashSet;

public class Main {

    public static void main(String args[]) {
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }

    public static boolean wordPattern(String pattern, String s) {

        HashMap<Character, String> map = new HashMap<>();
        HashSet<String> mapped = new HashSet<>();
        String[] listOfWords = s.split(" ");

        if (pattern.length() != listOfWords.length) return false;

        for(int i = 0; i < pattern.length(); i++) {
            char c = pattern.charAt(i);
            String wordMapped = map.get(c);
            if(wordMapped == null) {
                if(mapped.contains(listOfWords[i])) return false;
                mapped.add(listOfWords[i]);
                map.put(c, listOfWords[i]);
            }
            else if(wordMapped.equals(listOfWords[i])) continue;
            else return false;
        }

        return true;
    }

}
