import java.util.Arrays;


// source: https://github.com/argonautica/sorting-algorithms/blob/master/Java/TimSort.java
// to better understand it: https://www.youtube.com/watch?app=desktop&v=GhP5WbE4GYo

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[]{5,4,2,1};
        Main m = new Main();
        m.timSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    int RUN = 32;

    public void insertionSort(int[] arr, int left, int right) {
        for(int i = left + 1; i <= right; i++) {
            int temp = arr[i];
            int j = i - 1;
            while(j >= 0 && arr[j] > temp && j >= left) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
    }

    public void merge(int[] arr, int left, int right, int mid) {

        // Not understanding why not + 1 for rightArrLen? Refer readme.MD
        int leftArrLen = mid - left + 1;
        int rightArrLen = right - mid;

        int[] leftArr = new int[leftArrLen];
        int[] rightArr = new int[rightArrLen];

        for(int i = 0; i < leftArrLen; i++) {
            leftArr[i] = arr[i + left];
        }

        for(int i = 0; i < rightArrLen; i++) {
            rightArr[i] = arr[mid + 1 + i];
        }

        int i = 0;
        int j = 0;
        int k = left;

        while(i < leftArrLen && j < rightArrLen) {
            if(leftArr[i] < rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }

        while(i < leftArrLen) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }

        while(j < rightArrLen) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }

    }

    public void timSort(int[] arr) {
        int length = arr.length;

        for(int i = 0; i < length; i += RUN) {
            insertionSort(arr, i, Math.min(arr.length - 1, (i + RUN - 1)));
        }

        for(int size = RUN; size < length; size = 2 * size) {
            for(int left = 0; left < length; left += 2 * size) {
                int mid = left + size - 1;
                int right = Math.min((left + (2 * size - 1)), length - 1);

                merge(arr, left, mid, right);
            }
        }
    }
}
