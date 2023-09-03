public class quickSort {


    // swap helper - swap the elements in the two indexes mentioned.
    public static void swap(int[] arr, int firstindex, int secondindex) {
        int temp = arr[firstindex];
        arr[firstindex] = arr[secondindex];
        arr[secondindex] = temp;
    }

    // swaps the indexes till
    public static int pivot(int[] arr, int pivotIndex, int endIndex) {
        int swapIndex = pivotIndex;

        // swapIndex++ ---> points to the first greater element compared to pivot/swapIndex
        for(int i = pivotIndex + 1; i <= endIndex; i++) {
            if(arr[i] < arr[pivotIndex]) {
                swapIndex++;
                swap(arr, swapIndex, i);
            }
        }

        swap(arr, pivotIndex, swapIndex);

        return swapIndex;
    }

    public static void quickSortHelper(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = pivot(arr, left, right);
            quickSortHelper(arr, left, pivotIndex - 1);
            quickSortHelper(arr, pivotIndex+1, right);
        }
    }

    // we dont want the user to send in 0 or the array.length - 1
    public static void quickSort(int[] arr) {
        quickSortHelper(arr, 0, arr.length-1);
    }
}
