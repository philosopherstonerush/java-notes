import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        int[][] board = new int[][]{{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
        gameOfLife(board);
    }

    public static void gameOfLife(int[][] board) {

        if(board == null || board.length == 0) return;
        int m = board.length; int n = board[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                int lives = countLives(board, m, n, i, j);
                if((board[i][j] & 1) == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3;
                }
                if((board[i][j] & 1) == 0 && lives == 3) {
                    board[i][j] = 2;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }

        printPretty(board);
    }

    public static int countLives(int[][] board, int m, int n, int i, int j) {
        int lives = 0;
        for(int x = Math.max(i - 1, 0); x <= Math.min(i + 1, m-1); x++) {
            for(int y = Math.max(j - 1, 0); y <= Math.min(j + 1, n -1); y++) {
                // we do this because we are doing this in place meaning we have to track the current and next state in the same grid.
                lives += board[x][y] & 1;
            }
        }
        lives -= board[i][j] & 1;
        return lives;
    }

    public static void printPretty(int[][] board) {

        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }

    }
}
