import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {

    }

    public static void printPretty(int[][] matrix) {
        for(int[] c: matrix) {
            System.out.println(Arrays.toString(c));
        }
    }
}
