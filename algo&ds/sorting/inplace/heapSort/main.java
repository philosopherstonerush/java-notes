 import java.util.ArrayList;
import java.util.List;

public class main {

    //    why is heapify taking nlogn time complexity?
    //    https://stackoverflow.com/a/60841556

    // Unbelievably this is a good video for this
    // https://www.youtube.com/watch?v=Q_eia3jC9Ts

    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>(List.of(5,3,4,2,1,-1));
        arr = heapSort(arr);
        System.out.println(arr);
    }

    // this heapsort sorts the arr in ascending order

    public static List<Integer> heapSort(List<Integer> arr) {

        /*

            🔍 Why (n / 2) - 1?

            In a binary heap, elements at indices n/2 to n-1 are all leaf nodes — and leaf nodes already satisfy the heap property (they have no children).

            So we only need to "heapify" the internal nodes, starting from the last non-leaf node at index (n/2) - 1, and move upward to the root (i = 0).

         */

        int n = arr.size();
        for(int i = (n / 2) - 1; i >= 0; i--) {
            arr = heapify(arr, n, i);
        }

        for(int i = n - 1; i > 0; i--) {
            int temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);

            // we are reducing the size by 1, since we dont care about the last element we just replaced (already sorted)
            // the current element at the root needs to go down
            arr = heapify(arr, i, 0);
        }

        return arr;
    }

    public static List<Integer> heapify(List<Integer> arr, int n, int i) {
        int largest = i;

        // math for finding the left and right child of a i node in binary tree based on a list.
        int l = 2 * i + 1;
        int r = 2 * i + 2;

        // These checks l < n and r < n help to make sure that l and r are actually pointing to children in the array

        if(l < n && arr.get(l) > arr.get(largest)) {
            largest = l;
        }

        if(r < n && arr.get(r) > arr.get(largest)) {
            largest = r;
        }

        if(largest != i) {
            int temp = arr.get(i);
            arr.set(i,arr.get(largest));
            arr.set(largest, temp);

            arr = heapify(arr, n, largest);
        }

        return arr;
    }


}
