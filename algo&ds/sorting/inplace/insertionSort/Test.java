import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        inSort ins = new inSort();

        int[] array = {1, 4, 3, 2, 5};

        insertionSort(array);

        System.out.println(Arrays.toString(array));
    }

    public static void insertionSort(int[] arr) {
        for(int i = 1; i < arr.length; i++) {
            int j = i + 1;
            while(j > -1 && arr[j] < arr[j-1]) {
                int temp = arr[j];
                arr[j] = arr[j-1];
                arr[j-1] = temp;
                j--;
            }
        }
    }
}
