import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] originalArray = {3,1,4,2};

        int [] sortedArray = sort(originalArray);

        System.out.println( "\nOriginal Array: " + Arrays.toString( originalArray ) );

        System.out.println( "\nSorted Array: " + Arrays.toString( sortedArray ) );
    }

    public static int[] merge(int[] arr1, int[] arr2) {
        int combined = arr1.length + arr2.length;
        int i = 0;
        int j = 0;
        int index = 0;

        int[] mergedArr = new int[combined];

        while(i < arr1.length && j < arr2.length) {
            if(arr1[i] < arr2[j]) {
                mergedArr[index] = arr1[i];
                i++;
            } else {
                mergedArr[index] = arr2[j];
                j++;
            }
            index++;
        }

        while(i < arr1.length) {
            mergedArr[index] = arr1[i];
            index++;
            i++;
        }

        while(j < arr2.length) {
            mergedArr[index] = arr2[j];
            index++;
            j++;
        }

        return mergedArr;
    }

    public static int[] sort(int[] arr) {

        if(arr.length == 1) {
            return arr;
        }

        int mid = arr.length / 2;

        int[] A = Arrays.copyOfRange(arr, 0, mid);
        int[] B = Arrays.copyOfRange(arr, mid, arr.length);

        A = sort(A);
        B = sort(B);

        return merge(A, B);
    }
}
