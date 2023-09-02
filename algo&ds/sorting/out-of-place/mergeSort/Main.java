import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        mergeSort m = new mergeSort();
        int[] originalArray = {3,1,4,2};

        int [] sortedArray = m.sort(originalArray);

        System.out.println( "\nOriginal Array: " + Arrays.toString( originalArray ) );

        System.out.println( "\nSorted Array: " + Arrays.toString( sortedArray ) );
    }
}
