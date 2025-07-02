import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        int[] myArray = {4,6,1,7,3,2,5};
        Test t = new Test();
        t.quicksort(myArray);

        System.out.println(Arrays.toString( myArray ) );
    }

    public void quicksort(int[] arr) {
        quickSortHelper(arr, 0, arr.length - 1);
    }

    public void quickSortHelper(int[] arr, int left, int right) {
        while(left < right) {
            int pivotIndex = findPivot(arr, left, right);
            quickSortHelper(arr, left, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex + 1, right);
        }
    }

    public void swap(int[] arr, int firstIndex, int secondIndex) {
        int temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }

    public int findPivot(int[] arr, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;

        for(int i = pivotIndex + 1; i <= endIndex; i++) {
            if(arr[i] < arr[pivotIndex]) {
                swapIndex++;
                swap(arr, swapIndex, i);
            }
        }

        swap(arr, swapIndex, pivotIndex);
        return swapIndex;
    }

}


