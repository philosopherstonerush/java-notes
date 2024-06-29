import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        printPretty(matrix);
        System.out.println("-------------------------");
        rotate(matrix);
    }

    public static void rotate(int[][] matrix) {
        //transpose
        int s = 0;
        int e = matrix.length - 1;
        while(s < e) {
            int[] temp = matrix[s];
            matrix[s] = matrix[e];
            matrix[e] = temp;
            s++; e--;
        }

        // swap symmetry
        // j = i + 1 because, we are going for slanted lines
        // ex: [1,2,3]
        //     [4,5,6]
        //     [7,8,9]
        // 2,4 - one slated symmetry
        // 3,5,7 - another slated symmetry
        // 6,8 - another
        for(int i = 0; i < matrix.length; i++) {
            for(int j = i+1; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        printPretty(matrix);

    }

    public static void printPretty(int[][] matrix) {
        for(int[] c: matrix) {
            System.out.println(Arrays.toString(c));
        }
    }

}
