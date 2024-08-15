import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Test {
    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,3}, {6,9}};
        int[][] testArr = insert(arr, new int[]{2,5});
        for(var intArr: testArr) {
            System.out.println(Arrays.toString(intArr));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {

    }
}
