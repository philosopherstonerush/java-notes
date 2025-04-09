import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 * Given an array of points where points[i] = [xi, yi] represents a point on the X-Y plane, return the maximum number of points that lie on the same straight line.
 *
 */


// https://afteracademy.com/blog/max-points-on-the-straight-line/

public class Main {

    public static void main(String[] args) {
        int[][] test = {{0,0}, {1,-1}, {1,1}};
        System.out.println(maxPoints(test));
    }

    /**
     *
     *
     * Two methods:
     *
     * 1) Brute Force Method - Calculate the eqn based on two points and find how many points lay on that line.
     *
     * 2) Use a map to store the slope of all the points (y2-y1) / (x2 - x1)
     *
     */

    // Another solution similar to the leetcode solution after this - this might be easier to understand
    public static int maxPoints2(int[][] points) {
        int maxPoints = 0;

        for(int i = 0; i < points.length; i++) {
            int overlapping = 1;
            int yaxis = 0;
            Map<Double, Integer> slope = new HashMap<>();

            int[] fpoint = points[i];

            for(int j = i + 1; j < points.length; j++) {
                if(fpoint[0] == points[j][0] && fpoint[1] == points[j][1]) {
                    overlapping++;
                }
                else if (fpoint[0] == points[j][0]) {
                    yaxis++;
                } else {
                    Double slop = (points[j][1] - fpoint[1]) / (double) (points[j][0] - fpoint[0]);
                    if(slop == -0.0) {
                        slop = 0.0;
                    }
                    slope.put(slop, slope.getOrDefault(slop, 0) + 1);
                }
            }

            int maxSlopeLines = 0;

            for(Map.Entry<Double, Integer> keySet: slope.entrySet()) {
                maxSlopeLines = Math.max(maxSlopeLines, slope.get(keySet.getKey()));
            }

            maxPoints = Math.max(maxPoints, Math.max(maxSlopeLines, yaxis) + overlapping);

        }

        return maxPoints;
    }

    public static int maxPoints(int[][] points) {

        // Maximum number of points that lay on the line
        int max_points = 0;

        for(int i = 0; i < points.length; i++) {

            // number of points that are in the straight line for the current point
            int local_max = 0;
            // The number of points in the vertical line
            int vertical = 1;
            // The number of points that overlap with the current point
            int overlap = 1;
            // Keeping track of slope's which indicate if points are in the same line.
            Map<Double, Integer> m = new HashMap<>();

            for(int j = i + 1; j < points.length; j++) {
                // if the points overlap, increment overlap
                if(points[i][0] == points[j][0] && points[i][1] == points[j][1]) {
                    overlap += 1;

                    // if the point's x coordinates are the same then increment vertical
                } else if (points[i][0] == points[j][0]) {
                    vertical += 1;

                    // calculate slope
                } else {
                    double slope = ((points[i][1] - points[j][1]) / (double) (points[i][0] - points[j][0]));

                    // apparently -0.0 is a thing for JVM
                    if(slope == -0.0) {
                        slope = 0.0;
                    }

                    // containsKey method if used, increase runtime so much
                    // Increment integer associated with slope double or just insert 1 for the new slope value.
                    m.put(slope, m.getOrDefault(slope, 0) + 1);
                }

            }

            // For all the slope values in the map, get the maximum number of points in a line
            for(double k: m.keySet()) {
                local_max = Math.max(m.get(k), local_max);
            }

            // local_max + overlap because if not this then slope will be zero then we cant account for the i's point's overlap. If j's points have an overlap, it doesnt matter as they will provide the same slope with i's points, this cannot be added to y-axis as essentially it belongs to the slope.

            // vertical is a special case as well because then too we have the division of 0 problem.

            // max_points is in the equation so we can account for the previous i's point's result.
            max_points = Math.max(local_max + overlap, Math.max(vertical, max_points));

        }

        return max_points;

    }

}
