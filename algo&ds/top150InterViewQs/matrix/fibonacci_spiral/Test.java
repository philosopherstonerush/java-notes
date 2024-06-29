import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {

    static int first = 0;
    static int second = 1;
    public static void main(String[] args) {
        matrix(3,4);
    }

    public static void matrix(int m, int n) {



    }


    public static void printPretty(int[][] grid) {
        for(int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
    }

}
