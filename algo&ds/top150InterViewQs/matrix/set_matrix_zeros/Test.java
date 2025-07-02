import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,0,7,8},{0,10,11,12},{13,14,15,0}};
        int[][] matrix1 = new int[][]{{0,0,3}};
        setZeroes(matrix1);
    }
    public static void setZeroes(int[][] matrix) {
        printPretty(matrix);
    }

    public static void printPretty(int[][] matrix) {

        for(int[] elems: matrix) {
            System.out.println(Arrays.toString(elems));
        }

    }
}
