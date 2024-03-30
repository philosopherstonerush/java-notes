import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args) {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(fullJustify(words, maxWidth).toString());
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {

        int no_of_words = words.length;
        int index = 0;
        List<String> result = new ArrayList<>();
        while(index < no_of_words) {

            List<String> words_in_line = getWordsForLine(words, maxWidth, index, no_of_words);
            index += words_in_line.size();
            String res = getJustifiedString(words_in_line, maxWidth, index, no_of_words);
            result.add(res);
        }

        return result;
    }

    public static List<String> getWordsForLine(String[] words, int maxWidth, int index, int no_of_words) {

        List<String> res = new ArrayList<>();
        int line_len = 0;
        for(int i = index; i < no_of_words; i++) {
            if(words[i].length() + line_len > maxWidth) {
                break;
            }
            res.add(words[i]);
            line_len += words[i].length() + 1;
        }

        return res;
    }

    public static String getJustifiedString(List<String> words_in_line, int maxWidth, int index, int no_of_words) {

        int words_in_line_length = words_in_line.size();
        int extraSpaces = maxWidth - (words_in_line_length - 1 + words_in_line.stream().mapToInt(String::length).sum());

        if(index == no_of_words || words_in_line.isEmpty() || words_in_line_length == 1) {
            return String.join(" ", words_in_line) + " ".repeat(extraSpaces);
        }

        int extraSpacesEven = extraSpaces / (words_in_line_length - 1);

        for(int i = 0; i < words_in_line_length - 1; i++) {
            words_in_line.set(i, words_in_line.get(i) + " ".repeat(extraSpacesEven));
        }

        int extraSpacesLeft = extraSpaces % (words_in_line_length - 1);

        for(int i = 0; i < extraSpacesLeft; i++) {
            words_in_line.set(i, words_in_line.get(i) + " ");
        }

        return String.join(" ", words_in_line);

    }

}
