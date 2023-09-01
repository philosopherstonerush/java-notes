import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        bubbleSort bs = new bubbleSort();
        int[] arr = {1, 5, 3, 2, 4};

        // The interesting part here is how arr manipulates the arr declared above without making a new copy (pass by reference happens).

        bs.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
