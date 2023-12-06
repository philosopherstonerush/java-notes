import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ExSourceStream {
    public static void main(String[] args) {

        // Creating from collection

        List<String> nameCol = Arrays.asList("Rameh", "Bhopal");
        Stream<String> nameStream = nameCol.stream();

        // Creating from arrays

        String[] nameArr = new String[]{"Rameh", "Bhopal"};
        Stream<String> nameStream2 = Arrays.stream(nameArr);

        // Creating from streams.iterate()

        Stream<Integer> infiniteStream = Stream.iterate(0, n->n+1);

        // Creating from streams.generate()

        Stream<Double> infGeneratedStream = Stream.generate(Math::random);
    }
}
