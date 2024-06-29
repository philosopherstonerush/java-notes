
public class Main {

    public static void main(String[] args) {
        int[][] testArr = new int[][]{{0,1,0}, {1,0,1}};
        int resultArr = minimumArea(testArr);
        System.out.println(resultArr);
    }

    public static int minimumArea(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        // left, right, up and down
        int l = Integer.MAX_VALUE;
        int u = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        int d = Integer.MIN_VALUE;

        for(int i = 0; i < n; i ++) {
            for(int j = 0; j < m; j++) {
                if(grid[i][j] == 1) {
                    l = Math.min(l, j);
                    u = Math.min(u, i);
                    r = Math.max(r, j);
                    d = Math.max(d, i);
                }
            }
        }

        int length = r - l + 1;
        int width = d - u + 1;

        return length * width;

    }
}
