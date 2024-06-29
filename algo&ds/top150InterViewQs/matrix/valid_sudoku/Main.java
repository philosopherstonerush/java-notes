public class Main {
    public static void main(String[] args) {
          // REALLY HARD TO WRITE SOMETHING HERE FOR THIS
    }

    public static boolean isValidSudoku(char[][] board) {

        // allocate extra memory for the number
        int[][] rows = new int[9][9];
        int[][] cols = new int[9][9];
        int[][][] boxes = new int[3][3][9];

        for(int i = 0; i < rows.length; i++) {
            for(int j = 0; j < cols.length; j++) {
                if(board[i][j] != '.') {
                    int number = board[i][j] - '0';
                    number = number - 1;
                    if(rows[i][number]++ > 0) return false;
                    if(cols[j][number]++ > 0) return false;
                    if(boxes[i/3][j/3][number]++ > 0) return false;
                }
            }
        }

        return true;
    }
}
