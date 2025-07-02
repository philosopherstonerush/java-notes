import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        bubbleSort bs = new bubbleSort();
        int[] arr = {1, 5, 3, 2, 4};
        int[] arr1 = {5,1,3};

        // The interesting part here is how arr manipulates the arr declared above without making a new copy (pass by reference happens).

        bubbleSort(arr1);
        System.out.println(Arrays.toString(arr1));
    }

    public static void bubbleSort(int[] arr) {

    }

}
