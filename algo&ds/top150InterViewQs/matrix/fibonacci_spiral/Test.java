import java.lang.reflect.Array;
import java.util.Arrays;

public class Test {

    static int first = 0;
    static int second = 1;
    public static void main(String[] args) {
        matrix(4,4);
    }

    public static void matrix(int m, int n) {
        int start_i = 0;
        int end_i = m-1;
        int start_j = 0;
        int end_j = n-1;

        int term = 1;

        int[][] matrix = new int[m][n];

        while(start_i <= end_i && start_j <= end_j) {
            for(int i = start_j; i <= end_j; i++) {
                if(matrix[start_i][i] == 0) matrix[start_i][i] = getNextTerm(term);
                term++;
            }
            start_i++;

            for(int i = start_i; i <= end_i; i++) {
                if(matrix[i][end_j] == 0) matrix[i][end_j] = getNextTerm(term);
                term++;
            }
            end_j--;

            for(int i = end_j; i >= start_j; i--) {
                if(matrix[end_i][i] == 0) matrix[end_i][i] = getNextTerm(term);
                term++;
            }
            end_i--;

            for(int i = end_i; i >= start_i; i--) {
                if(matrix[i][start_j] == 0) matrix[i][start_j] = getNextTerm(term);
                term++;
            }
            start_j++;
        }

        printPretty(matrix);
    }

    public static int getNextTerm(int term) {
        if(term == 1) {
            return first;
        }
        if(term == 2) {
            return second;
        }

        int temp = first + second;
        first = second;
        second = temp;

        return temp;

    }

    public static void printPretty(int[][] grid) {
        for(int[] row: grid) {
            System.out.println(Arrays.toString(row));
        }
    }

}
