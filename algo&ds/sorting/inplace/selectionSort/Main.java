import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        int[] array = {2, 1, 5, 3, 4};

        selSort ss = new selSort();

        ss.sort(array);

        System.out.println(Arrays.toString(array));

    }
}
