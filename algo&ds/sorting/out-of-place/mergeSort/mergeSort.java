import java.util.Arrays;

public class mergeSort {

    // merges two SORTED arrays
    public int[] merge(int[] array1, int[] array2) {
        int combined = array1.length + array2.length;
        int index = 0;
        int i = 0;
        int j = 0;
        int[] mergedArr = new int[combined];

        while(i < array1.length && j < array2.length) {
            if(array1[i] < array2[j]) {
                mergedArr[index] = array1[i];
                i++;
                index++;
            } else {
                mergedArr[index] = array2[j];
                j++;
                index++;
            }
        }

        while(i < array1.length) {
            mergedArr[index] = array1[i];
            index++;
            i++;
        }

        while(j < array2.length) {
            mergedArr[index] = array2[j];
            index++;
            j++;
        }

        return mergedArr;
    }

    // recursive function - break and then merge using the helper function above.

    public int[] sort(int[] arr) {

        // base case

        if(arr.length == 1) {
            return arr;
        }

        int midIndex = arr.length / 2;

        // copy - [0, midIndex)
        int[] A = Arrays.copyOfRange(arr, 0, midIndex);

        //copy - [midIndex, arr.length)
        int[] B = Arrays.copyOfRange(arr, midIndex, arr.length);

        A = sort(A);
        B = sort(B);

        return merge(A, B);
    }
}
