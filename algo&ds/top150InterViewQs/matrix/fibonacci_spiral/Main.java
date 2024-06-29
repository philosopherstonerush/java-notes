import java.util.Arrays;

public class Main {

    public static int first = 0;
    public static int second = 1;

    public static void main(String[] args) {
        int m = 5;
        int n = 5;
        int[][] finalMatrix = makeSpiralMatrix(m, n);
        for(int i = 0; i < m; i++) {
            System.out.println(Arrays.toString(finalMatrix[i]));
        }
    }

    public static int[][] makeSpiralMatrix(int m, int n) {

        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            Arrays.fill(matrix[i], -1);
        }

        int a = 0;
        int b = 1;

        if (m == 1 && n == 1) {
            matrix[0][0] = a;
            return matrix;
        } else if (m == 1 && n == 2) {
            matrix[0][0] = a;
            matrix[0][1] = b;
            return matrix;
        } else if (m == 2 && n == 1) {
            matrix[0][0] = a;
            matrix[1][0] = b;
            return matrix;
        }

        int rowBegin = 0;
        int rowEnd = m-1;
        int colBegin = 0;
        int colEnd = n-1;
        int currTerm = 1;

        while(rowBegin <= rowEnd && colBegin <= colEnd) {

            // Traverse Right
            for(int i = colBegin; i <= colEnd; i++) {
                matrix[rowBegin][i] = getNumber(currTerm);
                currTerm++;
            }
            rowBegin++;

            // Traverse Down
            for(int i = rowBegin; i <= rowEnd; i++) {
                matrix[i][colEnd] = getNumber(currTerm);
                currTerm++;
            }
            colEnd--;

            // Traverse left
            if(rowBegin <= rowEnd) {
                for(int i = colEnd; i >= colBegin; i--) {
                    matrix[rowEnd][i] = getNumber(currTerm);
                    currTerm++;
                }
            }
            rowEnd--;

            // Traverse up
            if(colBegin <= colEnd) {
                for(int i = rowEnd; i >= rowBegin; i--) {
                    matrix[i][colBegin] = getNumber(currTerm);
                    currTerm++;
                }
            }
            colBegin++;
        }

        return matrix;

    }

    public static int getNumber(int term) {

        if (term == 1) {
            return first;
        } else if (term == 2) {
            return second;
        }

        int currTerm = first + second;
        first = second;
        second = currTerm;
        return currTerm;

    }

}
