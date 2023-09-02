import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        inSort ins = new inSort();

        int[] array = {1, 4, 3, 2, 5};

        ins.sort(array);

        System.out.println(Arrays.toString(array));
    }
}
