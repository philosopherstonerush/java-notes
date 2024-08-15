import java.util.Arrays;

public class Test {

    public static void main(String args[]) {
        int[][] board = new int[][]{{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
        gameOfLife(board);
    }

    public static void gameOfLife(int[][] board) {

        int rows = board.length;
        int cols = board[0].length;

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                int lives = countLives(board, i, j);
                if((board[i][j] & 1) == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3;
                }
                if((board[i][j] & 1) == 0 && lives == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < cols; j++) {
                board[i][j] >>= 1;
            }
        }

        printPretty(board);

    }

    public static int countLives(int[][] board, int st_i, int st_j) {

        int lives = 0;
        for(int i = Math.max(0, st_i-1); i <= Math.min(board.length-1, st_i+1); i++) {
            for(int j = Math.max(0, st_j-1); j <= Math.min(board[0].length-1, st_j+1); j++) {
                lives += board[i][j] & 1;
            }
        }

        lives -= (board[st_i][st_j]) & 1;
        return lives;
    }


    public static void printPretty(int[][] board) {

        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }

    }

}
