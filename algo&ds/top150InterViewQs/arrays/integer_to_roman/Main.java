import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        int integer = 3;

        String output = intToRoman(3);

        System.out.println(output);
    }


    // Questions like this are a pain in the arse. These type of questions need you to understand what you are aiming for before you could code it.
    public static String intToRoman(int num) {

        // Refer to roman to integer problem if you dont know how 900, 400, 40 etc are logically formed in roman
        int[] values = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4 ,1};
        String[] numerals = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

        StringBuilder stringBuilder = new StringBuilder();
        int value = num;
        int i = 0;
        while(value > 0) {
            if(value - values[i] >= 0) {
                stringBuilder.append(numerals[i]);
                value = value - values[i];
            } else {
                i++;
            }
        }

        return stringBuilder.toString();

    }

}
