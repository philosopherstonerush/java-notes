import java.util.Arrays;

/*

I think what happens is, to store information at the first element of each columns and rows. If a column contains a 0, it's first element will be 0. Same for rows. However, both first column and first row use matrix[0][0] which is problematic so she creates another variable for first column, col0.
Finally, start setting zeros from the bottom right corner.
brilliant! cheers!


 */


public class Main {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{0,1,2,0}, {3,4,5,2}, {1,3,1,5}};
        setZeroes(matrix);
    }
    public static void setZeroes(int[][] matrix) {
        int col0 = 1;
        int rows = matrix.length;
        int cols = matrix[0].length;

        for(int i = 0; i < rows; i++) {
            // this cant be in the loop inside as this can be manipulated by the zeros we set with matrix[i][0] and matrix[0][j]
            if(matrix[i][0] == 0) col0 = 0;
            for (int j = 1; j < cols; j++) {
                if(matrix[i][j] == 0) {
                    matrix[i][0] = matrix[0][j] = 0;
                }
            }
        }

        for(int i = rows - 1; i >= 0; i--) {
            for(int j = cols - 1; j >= 1; j--) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (col0 == 0) matrix[i][0] = 0;
        }

        printPretty(matrix);

    }

    public static void printPretty(int[][] matrix) {

        for(int[] elems: matrix) {
            System.out.println(Arrays.toString(elems));
        }

    }

}
