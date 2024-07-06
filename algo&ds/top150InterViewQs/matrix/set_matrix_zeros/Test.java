import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,1,1}, {1,0,1}, {1,1,1}};
        setZeroes(matrix);
    }
    public static void setZeroes(int[][] matrix) {

    }

    public static void printPretty(int[][] matrix) {

        for(int[] elems: matrix) {
            System.out.println(Arrays.toString(elems));
        }

    }
}
