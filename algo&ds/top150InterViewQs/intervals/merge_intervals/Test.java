import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Test {

    public static void main(String[] args) {
        int[][] testArr = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        var result = merge(testArr);
        for(var intArr: result) {
            System.out.println(Arrays.toString(intArr));
        }
    }

    public static int[][] merge(int[][] intervals) {

    }

}
