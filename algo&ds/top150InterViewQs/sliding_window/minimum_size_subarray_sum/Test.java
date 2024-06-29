import java.util.Arrays;
import java.util.HashMap;

public class Test {

    public static void main(String[] args) {
        int[] arr = new int[]{0 , 1, 1, 0, 1, 0};
        findLongest(arr);
    }

    public static void findLongest(int[] arr) {

        int i = 0;
        int j = 0;

        HashMap<Integer, Integer> numberFreq = new HashMap<>();

        int ans = -1;
        int sum = 0;

        int indexS = 0;
        int indexE = 0;

        int N = arr.length;

        for(; j < N; ++j) {

            if(arr[j] == 1) sum += 1;
            else sum -= 1;

            // 1, 0, 1, 0 --
            for(; i < N && sum != 0; i++) {
                if(arr[i] == 1) sum -= 1;
                else sum += 1;
            }

            if(j - i + 1 > ans) {
                ans = j - i + 1;
                indexS = i;
                indexE = j;
            }
        }

        if (ans == -1) System.out.println(-1);
        else System.out.println(indexS + " " + indexE);

    }

    public static boolean equalZerosAndOnes(int[] arr, int i, int j) {

        int numberOfOnes = 0;
        int numberOfZeros = 0;

        for(int s = i; s < j; s ++) {
            if(arr[s] == 1) numberOfOnes++;
            else numberOfZeros++;
        }

        if(numberOfOnes == 0 && numberOfZeros == 0) return false;

        return numberOfOnes == numberOfZeros;

    }

}
