import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 *
 * Given an array of strings words and a width maxWidth, format the text such that each line has exactly maxWidth characters and is fully (left and right) justified.
 *
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly maxWidth characters.
 *
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 *
 * For the last line of text, it should be left-justified, and no extra space is inserted between words.
 *
 * Note:
 *
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 *
 *
 */

public class Main {
    public static void main(String[] args) {
        String[] words = new String[]{"This", "is", "an", "example", "of", "text", "justification."};
        int maxWidth = 16;
        System.out.println(fullJustify(words, maxWidth).toString());
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {

        int index = 0;
        int no_of_words = words.length;
        List<String> result = new ArrayList<>();

        while(index < no_of_words) {
            // Get the max words that can be in a line
            List<String> words_in_line = getWordsForLine(index, words, maxWidth, no_of_words);

            // increase the index
            index += words_in_line.size();

            // Justify the words
            String justified_line = justifyLine(index, words_in_line, maxWidth, no_of_words);

            // add the result
            result.add(justified_line);
        }
        return result;
    }

    private static List<String> getWordsForLine(int index, String[] words, int maxWidth, int no_of_words) {

        List<String> words_in_line = new ArrayList<>();
        int line_length = 0;

        for(int i = index; i < no_of_words; i++) {

            // if the word can be added to the line given maxWith
            if(words[i].length() + line_length <= maxWidth) {
                words_in_line.add(words[i]);

                // +1 for a space between words
                line_length += words[i].length() + 1;
            } else {
                break;
            }
        }

        return words_in_line;
    }

    private static String justifyLine(int index, List<String> words_in_line, int maxWidth, int no_of_words) {

        int no_of_words_line = words_in_line.size();

        // no_of_words_line - 1 gives the spaces between words
        int extra_spaces = maxWidth - ( no_of_words_line - 1 + words_in_line.stream().mapToInt(String::length).sum() );

        // if its the last line
        if(index == no_of_words || no_of_words_line == 1) {
            return String.join(" ", words_in_line) + " ".repeat(extra_spaces);
        }

        // Get the extraspaces to be distributed to every word in the line
        int extraSpacesDistributedEvenly = extra_spaces / (no_of_words_line - 1);

        // distribute the spaces
        for(int i = 0; i < no_of_words_line - 1; i++) {
            words_in_line.set(i, words_in_line.get(i) + " ".repeat(extraSpacesDistributedEvenly));
        }

        // Find the leftover spaces
        int extraSpacesLeftOver = extra_spaces % (no_of_words_line - 1);

        // start giving away the spaces from left
        for(int i = 0; i < extraSpacesLeftOver; i++) {
            words_in_line.set(i, words_in_line.get(i) + " ");
        }

        return String.join(" ", words_in_line);
    }

}
