public class Main {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1,0,1}, {1,1,1}};
        System.out.println(minimumSum(grid));
    }

    public static int minimumArea(int[][] grid, int st_i, int st_ie, int st_j, int st_je) {
        int i, j;
        int startRow = Integer.MAX_VALUE;
        int endRow = Integer.MIN_VALUE;
        int startCol = Integer.MAX_VALUE;
        int endCol = Integer.MIN_VALUE;
        int found = 0;
        for(i=st_i; i <= st_ie; i++) {
            for(j=st_j; j <= st_je; j++) {
                if(grid[i][j] == 1) {
                    startRow = Math.min(startRow, i);
                    startCol = Math.min(startCol, j);
                    endRow = Math.max(endRow, i);
                    endCol = Math.max(endCol, j);
                    found = 1;
                }
            }
        }
        return (found == 1) ? (endRow - startRow + 1) * (endCol - startCol + 1) : 0;
    }

    public static int minimumSum(int[][] grid) {

        int ans = Integer.MAX_VALUE;
        int one = Integer.MAX_VALUE;
        int two = Integer.MAX_VALUE;
        int three = Integer.MAX_VALUE;
        int m = grid.length;
        int n = grid[0].length;

        // i = first guard line
        // j = second guard line

        // Basic idea is to do what 1st version of this problem did by containerizing all different areas.

    /*
        -------------
        |    (1)    |
        |           |
        -------------
        | (2) | (3) |
        |     |     |
        -------------
    */
        for(int i = 0; i < m; i++) {
            one = minimumArea(grid, 0, i, 0, n-1);
            for(int j = 0; j < n; j++) {
                two = minimumArea(grid, i + 1, m -1, 0, j);
                three = minimumArea(grid, i + 1, m - 1, j + 1, n -1);
                ans = Math.min(ans, one+two+three);
            }
        }

    /*
        -------------
        |     | (2) |
        |     |     |
          (1) -------
        |     |     |
        |     | (3) |
        -------------
    */

        for(int j = 0; j < n; j++) {
            one = minimumArea(grid, 0, m - 1, 0, j);
            for(int i = 0; i < m; i++) {

                two = minimumArea(grid, 0, i, j+1, n-1);
                three = minimumArea(grid, i + 1, m - 1, j + 1, n - 1);
                ans = Math.min(ans, one+two+three);
            }
        }


    /*
        -------------
        | (2) | (3) |
        |     |     |
        ------------
        |           |
        |    (1)    |
        -------------
    */

        for(int i = 0; i < m; i++) {
            one = minimumArea(grid, i + 1, m - 1, 0, n-1);
            for(int j = 0; j < n; j++) {
                two = minimumArea(grid, 0, i, 0, j);
                three = minimumArea(grid, 0, i, j + 1, n - 1);
                ans = Math.min(ans, one+two+three);
            }
        }

    /*
        -------------
        |     |     |
        | (2) |     |
        ------- (1) |
        |     |     |
        | (3) |     |
        -------------
    */

        for(int j = 0; j < n; j++) {
            one = minimumArea(grid, 0, m-1, j +1, n -1);
            for(int i = 0; i < m; i++) {
                two = minimumArea(grid, 0, i, 0, j);
                three = minimumArea(grid, i + 1, m - 1, 0, j);
                ans = Math.min(ans, one + two + three);
            }
        }

    /*
        -------------
        |   |   |   |
        |   |   |   |
        |(1)|(2)|(3)|
        |   |   |   |
        |   |   |   |
        -------------
    */

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                one = minimumArea(grid, 0, m - 1, 0,  i);
                two = minimumArea(grid, 0, m -1, i + 1, j);
                three = minimumArea(grid, 0, m - 1, j + 1, n - 1);
                ans = Math.min(ans, one+two+three);
            }
        }


    /*
        -------------
        |    (1)    |
        -------------
        |    (2)    |
        -------------
        |    (3)    |
        -------------
    */

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < m; j++) {
                one = minimumArea(grid, 0, i, 0, n - 1);
                two = minimumArea(grid, i + 1, j, 0, n - 1);
                three = minimumArea(grid, j + 1, m - 1, 0 , n - 1);
                ans = Math.min(ans, one+two+three);
            }
        }

        return ans;
    }

}
