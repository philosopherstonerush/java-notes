import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class Main {

    public static void main(String args[]) {
        System.out.println(summaryRanges(new int[]{-1000000000,-9999,0,1,2,10,100,1000,999999999,1000000000}));
    }

    public static List<String> summaryRanges(int[] nums) {
        LinkedHashSet<Long> hashset = new LinkedHashSet<>();
        for(long i: nums) {
            hashset.add(i);
        }

        List<String> result = new ArrayList<>();

        for(long i : hashset) {
            if(!hashset.contains(i-1)) {
                long y = i + 1;
                while(hashset.contains(y)) {
                    y += 1;
                }
                if(y != i + 1) {
                    result.add(i + "->" + (y - 1));
                } else {
                    result.add(String.valueOf(y-1));
                }
            }
        }

        return result;
    }

}
