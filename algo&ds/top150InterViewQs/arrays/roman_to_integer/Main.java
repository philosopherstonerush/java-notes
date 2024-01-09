import java.util.HashMap;


/**
 *
 *
 *
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 *
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
 *
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
 *
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer.
 *
 *
 */


/**
 *
 * Constraints:
 *
 * 1 <= s.length <= 15
 * s contains only the characters ('I', 'V', 'X', 'L', 'C', 'D', 'M').
 * It is guaranteed that s is a valid roman numeral in the range [1, 3999].
 *
 */

public class Main {

    public static void main(String[] args) {
        String test_text = "MCMXCIV";
        System.out.println(romanToInt(test_text));
    }

    public static int romanToInt(String s) {

        // Refer to readME

        HashMap<Character, Integer> symbom_val = new HashMap<>();
        symbom_val.put('M', 1000);
        symbom_val.put('D', 500);
        symbom_val.put('C', 100);
        symbom_val.put('L', 50);
        symbom_val.put('X', 10);
        symbom_val.put('V', 5);
        symbom_val.put('I', 1);

        int ans = 0;

        int length = s.length();
        for(int i = 0; i < length; i++) {
            if(i  == 0) {
                ans += symbom_val.get(s.charAt(i));
            } else {
                Character temp1 = s.charAt(i);
                Character temp2 = s.charAt(i-1);

                if(symbom_val.get(temp1) > symbom_val.get(temp2)) {
                    ans -= symbom_val.get(temp2);
                    ans += (symbom_val.get(temp1) - symbom_val.get(temp2));
                } else {
                    ans += symbom_val.get(temp1);
                }
            }
        }
        return ans;
    }

}
