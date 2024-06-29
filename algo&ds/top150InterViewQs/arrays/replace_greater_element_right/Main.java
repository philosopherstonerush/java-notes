import java.util.Arrays;

public class Main {

    public static void main(String[] args){
        int[] arr = new int[]{17,18,5,4,6,1};

        System.out.println(Arrays.toString(replaceElements(arr)));
    }

    public static int[] replaceElements(int[] arr) {

        int[] newArr = new int[arr.length];
        newArr[newArr.length - 1] = -1;

        for(int i = arr.length-2; i >= 0; i--) {
            newArr[i] = Math.max(newArr[i+1], arr[i+1]);
        }

        return newArr;

    }

}
