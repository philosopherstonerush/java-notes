import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        int[][] testArr = new int[][]{{1,3}, {2,6}, {8,10}, {15,18}};
        var result = merge(testArr);
        for(var intArr: result) {
            System.out.println(Arrays.toString(intArr));
        }
    }

    public static int[][] merge(int[][] intervals) {

        if(intervals.length <= 1) return intervals;

        Arrays.sort(intervals, Comparator.comparingInt(l0 -> l0[0]));
        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];

        // the memory pointed to my this int arr can be changed.
        result.add(newInterval);
        for(int[] interval: intervals) {
            if(interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }

        return result.toArray(new int[result.size()][]);
    }
}
