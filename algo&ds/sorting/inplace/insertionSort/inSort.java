
// Insertion sort is selecting one element (just use the index element) to act as sorted array. So we stay with i+1

public class inSort {
    public void sort(int[] array) {
        for(int i = 1; i < array.length; i++) {
            int temp = array[i];

            // sort the new element into the array

            int j = i - 1;

            // j = -1, to prevent j from descending into madness

            while(j > -1 && temp < array[j]) {
                array[j+1] = array[j];
                array[j] = temp;
                j--;
            }
        }
    }
}
