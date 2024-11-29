import java.util.Arrays;

public class Test {

    public static void main(String args[]) {
        int[][] board = new int[][]{{0,1,0}, {0,0,1}, {1,1,1}, {0,0,0}};
        gameOfLife(board);
    }

    public static void gameOfLife(int[][] board) {



        printPretty(board);
    }

    public static int countLives(int[][] board, int x, int y) {

    }


    public static void printPretty(int[][] board) {

        for (int[] ints : board) {
            System.out.println(Arrays.toString(ints));
        }

    }

}
