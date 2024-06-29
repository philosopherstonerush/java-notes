import java.util.*;

public class Main {

    public static void main(String[] args) {
        String s = "barfoothefoobarman";
        String[] words = new String[]{"foo","bar"};

        System.out.println(findSubstringBest(s, words).toString());
    }

    // BEST EXPLANATION VIDEO - refer to the video in the same folder

    public static List<Integer> findSubstring(String s, String[] words) {

        if (s.isEmpty() || words.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, Integer> wordFreq = new HashMap<>();

        for(String word: words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }

        int wordLen = words[0].length();
        int wordWindowLength = words.length * wordLen;

        List<Integer> indexes=  new ArrayList<>();

        // s.length() - wordWindowLength + 1 will make sure to not search the last 5 characters.
        for(int i = 0; i < s.length() - wordWindowLength + 1; i++) {
            HashMap<String, Integer> subStringFreq = new HashMap<>();
            int j = i;
            while(j < i + wordWindowLength) {
                String currWord = s.substring(j, j+wordLen);
                if(wordFreq.getOrDefault(currWord, -1) == -1) break;
                subStringFreq.put(currWord, subStringFreq.getOrDefault(currWord, 0) + 1);
                if(subStringFreq.get(currWord) > wordFreq.get(currWord)) break;
                j += wordLen;
            }

            if (j == i + wordWindowLength) {
                indexes.add(i);
            }
        }

        return indexes;
    }

    // THE BEST SOLUTION - USES NLP TO SOLVE IT
    public static List<Integer> findSubstringBest(String s, String[] words) {

        int N = s.length();
        List<Integer> indexes = new ArrayList<>(s.length());

        if(words.length == 0) return indexes;

        int wordLen = words[0].length();
        if(N < wordLen * words.length) {
            return indexes;
        }

        int last = N - wordLen + 1;

        // FIND THE NUMBER OF OCCURENCES, MAP TO THE INDEX
        Map<String, Integer> mapping = new HashMap<>(words.length);
        int[][] table = new int[2][words.length];

        // this carries the number of unique appearances
        int failures = 0;
        int index = 0;
        for(int i = 0; i < words.length; i++) {
            Integer mapped = mapping.get(words[i]);
            if(mapped == null) {
                ++failures;
                mapping.put(words[i], index);
                mapped = index++;
            }
            ++table[0][mapped];
        }

        // map the int array to the appropriate word's index.
        int[] smapping = new int[last];
        for(int i = 0; i < last; i++) {
            String section = s.substring(i, i + wordLen);
            Integer mapped = mapping.get(section);
            if(mapped == null) {
                smapping[i] = -1;
            } else {
                smapping[i] = mapped;
            }
        }

        // we iterate from 0 to wordLen.
        // Hence 'last' effectively ensures that words stop at last index.
        for(int i = 0; i < wordLen; i++) {
            int currentFailures = failures;
            int left = i;
            int right = i;
            Arrays.fill(table[1], 0);

            // minimum window substring problem
            while(right < last) {
                while(currentFailures > 0 && right < last) {
                    int target = smapping[right];
                    if(target != -1 && ++table[1][target] == table[0][target]) {
                        --currentFailures;
                    }
                    right += wordLen;
                }
                while(currentFailures == 0 && left < right) {
                    int target = smapping[left];
                    if(target != -1 && --table[1][target] == table[0][target] - 1) {
                        int length = right - left;
                        if((length / wordLen) == words.length) {
                            indexes.add(left);
                        }
                        ++currentFailures;
                    }
                    left += wordLen;
                }
            }
        }
        return indexes;
    }

}
