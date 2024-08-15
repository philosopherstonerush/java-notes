import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {

    static int first = 0;
    static int second = 1;
    public static void main(String[] args) {
        matrix(4,4);
    }

    public static void matrix(int m, int n) {



    }

    public static int getTerm(int term) {
        if(term == 1) {
            return first;
        } else if (term == 2) {
            return second;
        } else {
            int temp = second;
            second = first + second;
            first = temp;
            return second;
        }
    }


    public static void printPretty(int[][] grid) {
        for(int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
    }

}
