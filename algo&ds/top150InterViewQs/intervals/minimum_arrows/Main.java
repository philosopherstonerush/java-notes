import java.util.Arrays;
import java.util.Comparator;

/*

We know that eventually we have to shoot down every balloon, so for each ballon there must be an arrow whose position is between balloon[0] and balloon[1] inclusively. Given that, we can sort the array of balloons by their ending position. Then we make sure that while we take care of each balloon in order, we can shoot as many following balloons as possible.

So what position should we pick each time? We should shoot as to the right as possible, because since balloons are sorted, this gives you the best chance to take down more balloons. Therefore the position should always be balloon[i][1] for the ith balloon.

This is exactly what I do in the for loop: check how many balloons I can shoot down with one shot aiming at the ending position of the current balloon. Then I skip all these balloons and start again from the next one (or the leftmost remaining one) that needs another arrow.

Example:

balloons = [[7,10], [1,5], [3,6], [2,4], [1,4]]
After sorting, it becomes:

balloons = [[2,4], [1,4], [1,5], [3,6], [7,10]]
So first of all, we shoot at position 4, we go through the array and see that all first 4 balloons can be taken care of by this single shot. Then we need another shot for one last balloon. So the result should be 2.



 */



public class Main {

    public static void main(String[] args) {
        int[][] points = new int[][]{{10,16}, {2,8}, {1,6}, {7,12}};
        System.out.println(findMinArrowShots(points));
    }

    public static int findMinArrowShots(int[][] points) {

        Arrays.sort(points, Comparator.comparingInt(l -> l[1]));
        int arrPos = points[0][1];
        int arrCount = 1;

        for(int i = 0; i < points.length; i++) {
            if(arrPos >= points[i][0]) {
                continue;
            }
            arrPos = points[i][1];
            arrCount++;
        }

        return arrCount;
    }

}
