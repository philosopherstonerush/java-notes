import java.util.ArrayList;

/**
 *
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 *
 * string convert(string s, int numRows);
 *
 *
 */

public class Main {

    public static void main(String[] args) {
        String t = "PAYPALISHIRING";
        int rows = 4;
        System.out.println(convert(t, rows));
    }

    public static String convert(String s, int numRows) {

        ArrayList<ArrayList<Character>> rows = new ArrayList<ArrayList<Character>>();
        StringBuilder sb = new StringBuilder();

        // Initializer the arrayList
        for(int i = 0; i < numRows; i++) {
            rows.add(new ArrayList<>());
        }

        int index = 0;

        while(index <= s.length() - 1) {
            // Take the first numRows characters and place it in each of the arrayList
            int count = 0;
            while (index <= s.length() - 1 && count < numRows) {

                rows.get(count).add(s.charAt(index));

                count++;
                index++;
            }

            // Moving from back, append each character to one of the arraylist
            count = numRows - 2;
            while(index <= s.length() - 1 && count >= 1) {

                rows.get(count).add(s.charAt(index));

                index++;
                count--;
            }
        }

        // Convert the arrayList of characters to string

        for(ArrayList<Character> elem: rows) {
            for(int i = 0; i < elem.size(); i++) {
                sb.append(elem.get(i));
            }
        }

        return sb.toString();
    }

}
