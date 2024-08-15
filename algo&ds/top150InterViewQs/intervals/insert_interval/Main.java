import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[][] arr = new int[][]{{1,2}, {3,5}, {6,7}, {8,10}, {12,16}};
        int[][] testArr = insert(arr, new int[]{4,8});
        for(var intArr: testArr) {
            System.out.println(Arrays.toString(intArr));
        }
    }

    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new LinkedList<>();
        int i = 0;

        // add all previous intervals to result
        while(i < intervals.length && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }

        // merge the overlapping ones
        while(i < intervals.length && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }

        // add the final merged one
        result.add(newInterval);

        // add the rest to the result
        while(i < intervals.length) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

}
