import java.util.HashSet;

/*

First turn the input into a set of numbers. That takes O(n) and then we can ask in O(1) whether we have a certain number.

Then go through the numbers. If the number x is the start of a streak (i.e., x-1 is not in the set), then test y = x+1, x+2, x+3, ... and stop at the first number y not in the set. The length of the streak is then simply y-x and we update our global best with that. Since we check each streak only once, this is overall O(n). This ran in 44 ms on the OJ, one of the fastest Python submissions.

 */


public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{100,4,200,1,3,2};
        System.out.println(longestConsecutive(nums));
    }

    public static int longestConsecutive(int[] nums) {
        HashSet<Integer> numsSet = new HashSet<>();
        for(int i: nums) {
            numsSet.add(i);
        }

        int best = 0;
        for(int i: numsSet) {
            if (!numsSet.contains(i-1)) {
                int y = i + 1;
                while (numsSet.contains(y)) {
                    y += 1;
                }
                best = Math.max(best, y - i);
            }
        }

        return best;
    }
}
